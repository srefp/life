package com.life.task.controller;

import com.life.task.common.Result;
import com.life.task.pojo.SysPerm;
import com.life.task.service.PermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lkj
 * @date 2021/5/18
 */
@CrossOrigin
@RestController
@RequestMapping("/perm")
public class PermController {

    @Autowired
    private PermService permService;

    /**
     * 1. 获取当前登录用户拥有的权限
     *
     * @return Result
     */
    @GetMapping("/current")
    public Result permCurrent () {
        return Result.success();
    }

    /**
     * 2. 获取权限列表
     *
     * @return Result
     */
    @GetMapping
    public Result permList (
    ) {
        return Result.success();
    }

    /**
     * 3. 获取所有权限
     *
     * @return Result
     */
    @GetMapping("/all")
    public Result permAll (
    ) {
        return Result.success();
    }

    /**
     * 4. 一级菜单
     *
     * @return Result
     */
    @GetMapping("/parents")
    public Result permParents (
    ) {
        return Result.success();
    }

    /**
     * 5. 根据角色ID获取权限
     *
     * @param roleId 角色ID
     * @return Result
     */
    @GetMapping(params = "roleId")
    public Result perm (
            @RequestParam("roleId") String roleId
    ) {
        return Result.success();
    }

    /**
     * 6. 保存菜单
     *
     * @return Result
     */
    @PostMapping
    public Result permSave (
    ) {
        return Result.success();
    }

    /**
     * 7. 根据菜单ID获取菜单
     *
     * @return Result
     */
    @GetMapping("/{id}")
    public Result permById (
            @PathVariable("id") Long id
    ) {
        return Result.success();
    }

    /**
     * 8. 修改菜单
     *
     * @return Result
     */
    @PutMapping
    public Result permChange (
    ) {
        return Result.success();
    }

    /**
     * 9. 校验当前用户的权限
     *
     * @return Result
     */
    @GetMapping("/owns")
    public Result permOwns (
    ) {
        return Result.success();
    }

    /**
     * 10. 删除菜单
     *
     * @return Result
     */
    @DeleteMapping("/{id}")
    public Result permDel (
            @PathVariable("id") Long id
    ) {
        return Result.success();
    }
}
