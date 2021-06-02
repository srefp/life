package com.life.task.common;

import lombok.Data;

/**
 * @author lkj
 * @date 2021/5/9
 */
@Data
public class Token {

    private String token;

    /** 登录时间戳（毫秒） */
    private Long loginTime;

    public Token(String token, Long loginTime) {
        super();
        this.token = token;
        this.loginTime = loginTime;
    }
}
