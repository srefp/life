package com.life.task.controller;

import com.life.task.common.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author lkj
 * @date 2021/5/18
 */
@CrossOrigin
@RestController
@RequestMapping("/job")
public class JobController {
    /**
     * 1. 添加定时任务
     *
     * @return Result
     */
    @PostMapping
    public Result job (
    ) {
        return Result.success();
    }

    /**
     * 2. 修改定时任务
     *
     * @return Result
     */
    @PutMapping
    public Result changeJob (
    ) {
        return Result.success();
    }

    /**
     * 3. 删除定时任务
     *
     * @return Result
     */
    @DeleteMapping("/{id}")
    public Result DeleteJob (
            @PathVariable("id") Long id
    ) {
        return Result.success();
    }

    /**
     * 4. 根据id获取定时任务
     *
     * @return Result
     */
    @GetMapping("/{id}")
    public Result getJobById (
            @PathVariable("id") Long id
    ) {
        return Result.success();
    }

    /**
     * 5. 定时任务列表
     *
     * @return Result
     */
    @GetMapping
    public Result jobList (
    ) {
        return Result.success();
    }

    /**
     * 6. 检验cron表达式
     *
     * @param cron cron表达式
     * @return Result
     */
    @GetMapping("/cron")
    public Result cron (
            @RequestParam("cron") String cron
    ) {
        return Result.success();
    }

}
