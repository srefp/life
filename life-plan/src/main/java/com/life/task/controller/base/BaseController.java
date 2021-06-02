package com.life.task.controller.base;

import com.life.task.common.LoginUser;
import com.life.task.service.TokenService;
import com.life.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lkj
 * @date 2021/5/26
 */
@CrossOrigin
@Component
public class BaseController {

    @Autowired
    protected TokenService tokenService;

    protected LoginUser getLoginUser(HttpServletRequest request) {
        String token = request.getHeader("token");
        return tokenService.getLoginUser(token);
    }

    protected Long getUserId(HttpServletRequest request) {
        String token = request.getHeader("token");
        return tokenService.getLoginUser(token).getId();
    }
}
