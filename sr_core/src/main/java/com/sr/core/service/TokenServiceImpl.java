package com.sr.core.service;

import com.sr.core.common.LoginUser;
import com.sr.core.common.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author lkj
 * @date 2021/5/11
 */
@Service
public class TokenServiceImpl implements TokenService {

    /** token过期秒数 */
    @Value("{token.expire-seconds}")
    private String expireSeconds;

    @Autowired
    private RedisTemplate<String, LoginUser> redisTemplate;

    @Autowired
    private SysLogService logService;

    @Override
    public Token saveToken(LoginUser loginUser) {
        String token = UUID.randomUUID().toString();

        loginUser.setToken(token);
        cacheLoginUser(loginUser);
        // 登录日志
        logService.save(loginUser.getId(), "登录", true, null);

        return new Token(token, loginUser.getLoginTime());
    }

    private void cacheLoginUser(LoginUser loginUser) {
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + Integer.valueOf(expireSeconds) * 1000);

        // 缓存
        redisTemplate.boundValueOps(getTokenKey(loginUser.getToken())).set(loginUser, Integer.valueOf(expireSeconds), TimeUnit.SECONDS);
    }

    /**
     * 更新缓存的用户信息
     * @param loginUser 登录用户信息
     */
    @Override
    public void refresh(LoginUser loginUser) {
        cacheLoginUser(loginUser);
    }

    @Override
    public LoginUser getLoginUser(String token) {
        return redisTemplate.boundValueOps(getTokenKey(token)).get();
    }

    @Override
    public boolean deleteToken(String token) {
        String key = getTokenKey(token);
        LoginUser loginUser = redisTemplate.opsForValue().get(key);
        if (loginUser != null) {
            redisTemplate.delete(key);
            // 退出日志
            logService.save(loginUser.getId(), "退出", true, null);
            return true;
        }
        return false;
    }

    private String getTokenKey(String token) {
        return "tokens:" + token;
    }
}
