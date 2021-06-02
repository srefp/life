package com.life.task.controller;

import com.life.task.annotation.Log;
import com.life.task.common.Result;
import com.life.task.dto.UserDTO;
import com.life.task.page.PageHandler;
import com.life.task.page.PageRequest;
import com.life.task.page.PageResponse;
import com.life.task.pojo.SysUser;
import com.life.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author lkj
 * @date 2021/5/14
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 1. 保存用户
     *
     * @return Result
     */
    @Log
    @PostMapping
    public Result saveUser (@RequestBody UserDTO userDTO) {
        SysUser tom = userService.getUser("tom");
        if (tom != null) {
            throw new IllegalArgumentException(userDTO.getUsername());
        }
        userService.saveUser(userDTO);
        return Result.success("保存用户成功");
    }

    /**
     * 2. 修改用户
     *
     * @return Result
     */
    @Log
    @PutMapping
    public Result changeUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
        return Result.success("修改用户成功");
    }

    /**
     * 3. 修改头像
     *
     * @param headImgUrl 头像地址
     * @return Result
     */
    @Log
    @PutMapping(params = "headImgUrl")
    public Result user (@RequestParam("headImgUrl") String headImgUrl) {
        return Result.success();
    }

    /**
     * 4. 修改密码
     *
     * @return Result
     */
    @PutMapping("/{username}")
    public Result changePassword (
            @PathVariable("username") String username,
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword
    ) {
        System.out.println(oldPassword);
        System.out.println(newPassword);
        System.out.println(username);
        return Result.success();
    }

    /**
     * 5. 用户列表
     *
     * @return Result
     */
    @GetMapping
    public Result userList (@RequestParam Integer pageNum,
                            @RequestParam Integer pageSize,
                            @RequestParam Map<String, Object> params) {
        PageRequest pageRequest = new PageRequest(pageNum, pageSize, params);
        
        PageResponse pageResponse = new PageHandler(
                req -> userService.count(req.getParams()),
                req -> userService.selectByParams(req.getParams(), (req.getPageNum() - 1) * req.getPageSize(), req.getPageSize())
        ).handle(pageRequest);

        Result result = Result.success();
        result.put("total", pageResponse.getTotal());
        result.put("data", pageResponse.getData());
        return result;
    }

    /**
     * 6. 获取当前登录用户
     *
     * @return Result
     */
    @GetMapping("/current")
    public Result userCurrent () {
        return Result.success();
    }

    /**
     * 7. 根据用户ID获取用户
     *
     * @return Result
     */
    @GetMapping("/{id}")
    public Result userById(@PathVariable("id") Long id) {
        return Result.success();
    }

}
