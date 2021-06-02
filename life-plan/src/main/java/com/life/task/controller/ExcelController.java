package com.life.task.controller;

import com.life.task.common.Result;
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
@RequestMapping("/excel")
public class ExcelController {

    /**
     * 1. 检验sql，并返回sql返回的数量
     *
     * @return Result
     */
    @PostMapping("/sql-count")
    public Result excelSqlCount (
    ) {
        return Result.success();
    }

    /**
     * 2. 根据sql导出excel
     *
     * @return Result
     */
    @PostMapping
    public Result excel (
    ) {
        return Result.success();
    }

}
