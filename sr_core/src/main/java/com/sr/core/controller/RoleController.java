package com.sr.core.controller;

import com.sr.core.common.Result;
import com.sr.core.pojo.SysRole;
import com.sr.core.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lkj
 * @date 2021/5/18
 */
@CrossOrigin
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 1. 保存角色
     *
     * @return Result
     */
    @PostMapping
    public Result role (
    ) {
        return Result.success();
    }

    /**
     * 2. 角色列表
     *
     * @return Result
     */
    @GetMapping
    public Result roleList (
    ) {
        List<SysRole> roles = roleService.roleList();
        return Result.success(roles);
    }

    /**
     * 3. 根据ID获取角色
     *
     * @return Result
     */
    @GetMapping("/{id}")
    public Result roleById (
            @PathVariable("id") Long id
    ) {
        SysRole role = roleService.getRoleById(id);
        return Result.success(role);
    }

    /**
     * 4. 获取所有角色
     *
     * @return Result
     */
    @GetMapping("/all")
    public Result roleAll (
    ) {
        return Result.success();
    }

    /**
     * 5. 根据用户ID获取拥有的角色
     *
     * @param userId 用户ID
     * @return Result
     */
    @GetMapping(params = "userId")
    public Result roleById (
            @RequestParam("userId") String userId
    ) {
        return Result.success();
    }

    /**
     * 6. 删除角色
     *
     * @return Result
     */
    @DeleteMapping("/{id}")
    public Result roleDel (
            @PathVariable("id") Long id
    ) {
        return Result.success();
    }

}
