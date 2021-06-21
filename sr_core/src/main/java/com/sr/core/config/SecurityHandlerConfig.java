package com.sr.core.config;

import com.sr.core.common.HttpStatus;
import com.sr.core.common.LoginUser;
import com.sr.core.common.Result;
import com.sr.core.common.Token;
import com.sr.core.filter.TokenFilter;
import com.sr.core.service.TokenService;
import com.sr.core.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * @author lkj
 * @date 2021/5/8
 */
@Configuration
public class SecurityHandlerConfig {

    @Autowired
    private TokenService tokenService;

    /**
     * 登录成功，返回Token
     *
     * @return token
     */
    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return (httpServletRequest, response, authentication) -> {
            LoginUser loginUser = (LoginUser) authentication.getPrincipal();

            Token token = tokenService.saveToken(loginUser);
            ResponseUtil.responseJson(response, HttpStatus.UNAUTHORIZED, token);
        };
    }

    /**
     * 登录失败
     */
    @Bean
    public AuthenticationFailureHandler loginFailureHandler() {
        return (httpServletRequest, response, e) -> {
            String msg;
            if (e instanceof BadCredentialsException) {
                msg = "密码错误";
            } else {
                msg = e.getMessage();
            }
            ResponseUtil.responseJson(response, HttpStatus.UNAUTHORIZED, msg);
        };
    }

    /**
     * 未登录，返回401
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (httpServletRequest, response, e) -> {
            Result result = Result.error("未认证");
            ResponseUtil.responseJson(response, HttpStatus.UNAUTHORIZED, result);
        };
    }

    /**
     * 退出处理
     */
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return (request, response, authentication) -> {
            Result result = Result.success("退出成功");

            String token = TokenFilter.getToken(request);
            tokenService.deleteToken(token);

            ResponseUtil.responseJson(response, HttpStatus.SUCCESS, result);
        };
    }
}
