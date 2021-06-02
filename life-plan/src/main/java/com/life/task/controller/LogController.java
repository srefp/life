package com.life.task.controller;

import com.life.task.common.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lkj
 * @date 2021/5/18
 */
@CrossOrigin
@RestController
@RequestMapping("/log")
public class LogController {


    /**
     * 1. 获取日志列表
     *
     * @return Result
     */
    @GetMapping
    public Result log () {
        return Result.success();
    }

}
