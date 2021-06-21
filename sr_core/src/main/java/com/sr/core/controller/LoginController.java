package com.sr.core.controller;

import cn.hutool.core.lang.UUID;
import com.sr.core.common.Constants;
import com.sr.core.common.LoginUser;
import com.sr.core.common.Result;
import com.sr.core.controller.base.BaseController;
import com.sr.core.entity.LoginBody;
import com.sr.core.mapper.SysPermMapper;
import com.sr.core.pojo.SysPerm;
import com.sr.core.service.LoginService;
import com.sr.core.service.PermService;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.base.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lkj
 * @date 2021/5/18
 */
@CrossOrigin
@RestController
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private PermService permService;

    @Autowired
    private SysPermMapper sysPermMapper;

    @Value("${login.captcha-type}")
    private String captchaType;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     * 生成验证码
     */
    @GetMapping("/captchaImage")
    public Result getCode() {
        // 保存验证码信息
        String uuid = UUID.randomUUID().toString(true);
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;

        Captcha captcha = new ArithmeticCaptcha(111, 36, 2);
        // 当验证码类型为 arithmetic时且长度 >= 2 时，captcha.text()的结果有几率为浮点型
        String captchaValue = captcha.text();
        if (captcha.getCharType() == 1 && captchaValue.contains(".")) {
            captchaValue = captchaValue.split("\\.")[0];
        }

        redisTemplate.opsForValue().set(verifyKey, captchaValue, 2, TimeUnit.MINUTES);

        Result result = Result.success();
        result.put("uuid", uuid);
        result.put("img", captcha.toBase64());
        return result;
    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginBody loginBody) {
        Result result = Result.success();
        // 生成令牌
        String token = loginService.login(
                loginBody.getUsername(),
                loginBody.getPassword(),
                loginBody.getCode(),
                loginBody.getUuid()
        );
        result.put("token", token);
        return result;
    }

    @GetMapping("/getInfo")
    public Result getInfo(HttpServletRequest request) {
        LoginUser loginUser = getLoginUser(request);

        List<SysPerm> sysPerms = sysPermMapper.listByUserId(loginUser.getId());
        Result result = Result.success();
        Long userId = getUserId(request);
        result.put("user", loginUser);
        result.put("perm", sysPerms);
        result.put("id", userId);
        return result;
    }

}
