package com.sr.core.controller;

import com.sr.core.common.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lkj
 * @date 2021/5/18
 */
@CrossOrigin
@RestController
@RequestMapping("/mail")
public class MailController {


    /**
     * 1. 保存邮件
     *
     * @return Result
     */
    @PostMapping
    public Result mail () {
        return Result.success();
    }
}
