package com.sr.core.controller;

import com.sr.core.common.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author lkj
 * @date 2021/5/18
 */
@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileController {


    /**
     * 1. 文件上传
     *
     * @return Result
     */
    @PostMapping
    public Result fileUpload(@RequestBody MultipartFile file) {
        return Result.success();
    }

    /**
     * 2. layui富文本文件自定义上传
     *
     * @return Result
     */
    @PostMapping("/layui")
    public Result fileLayuiUpload() {
        return Result.success();
    }

    /**
     * 3. 文件查询
     *
     * @return Result
     */
    @GetMapping
    public Result fileQuery() {
        return Result.success();
    }

    /**
     * 4. 文件删除
     *
     * @return Result
     */
    @DeleteMapping("/{id}")
    public Result fileDel(@PathVariable("id") Long id) {
        return Result.success();
    }

}
