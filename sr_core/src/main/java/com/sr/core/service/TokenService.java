package com.sr.core.service;

import com.sr.core.common.LoginUser;
import com.sr.core.common.Token;

/**
 * token管理器
 * @author lkj
 * @date 2021/5/9
 */
public interface TokenService {

    Token saveToken(LoginUser loginUser);

    void refresh(LoginUser loginUser);

    LoginUser getLoginUser(String token);

    boolean deleteToken(String token);

}
