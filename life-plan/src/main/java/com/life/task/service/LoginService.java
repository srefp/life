package com.life.task.service;

import com.life.task.common.Constants;
import com.life.task.common.HttpStatus;
import com.life.task.common.LoginUser;
import com.life.task.common.Token;
import com.life.task.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sun.misc.MessageUtils;

import javax.annotation.Resource;

/**
 * @author lkj
 * @date 2021/5/19
 */
@SuppressWarnings({"unchecked", "rawtypes"})
@Service
public class LoginService {

    @Autowired
    private TokenService tokenService;

    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 登录验证
     *
     * @param username 用户名
     * @param password 密码
     * @param code     验证码
     * @param uuid     唯一标识
     * @return 结果
     */
    public String login(String username, String password, String code, String uuid) {
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;
        String captcha = (String) redisTemplate.opsForValue().get(verifyKey);
        redisTemplate.delete(verifyKey);
        // 验证码校验
        if (captcha == null) {
            throw new RuntimeException("无法获取验证码");
        }
        if (!code.equalsIgnoreCase(captcha)) {
            throw new RuntimeException("验证码错误");
        }

        // 用户验证
        Authentication authentication;
        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                throw new RuntimeException();
            } else {
                throw new RuntimeException(e.getMessage());
            }
        }

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return tokenService.saveToken(loginUser).getToken();
    }

}
