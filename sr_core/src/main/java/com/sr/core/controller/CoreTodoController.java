package com.sr.core.controller;

import com.sr.core.pojo.CoreTodo;
import com.sr.core.service.CoreTodoService;
import com.sr.core.common.Result;
import com.sr.core.controller.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author lkj
 * @date 2021/06/09
 */
@CrossOrigin
@RestController
@Api("CoreTodo接口")
@RequestMapping("/todo")
public class CoreTodoController extends BaseController {

    @Autowired
    private CoreTodoService coreTodoService;

    /**
     * 增加一条CoreTodo
     *
     * @param coreTodo CoreTodo对象
     * @return 是否增加成功
     */
    @ApiOperation("增加一条CoreTodo")
    @PostMapping
    public Result insert(@RequestBody CoreTodo coreTodo, HttpServletRequest request) {
        Long userId = getUserId(request);
        coreTodo.setUserId(userId);
        int addColumnNum = coreTodoService.insert(coreTodo);
        if (addColumnNum == 1) {
            return Result.success("增加CoreTodo成功");
        } else {
            return Result.error("增加CoreTodo失败");
        }
    }

    /**
     * 批量增加CoreTodo
     * @param coreTodos CoreTodo数组
     * @return 是否批量增加成功
     */
    @ApiOperation("批量增加CoreTodo")
    @PostMapping("/batch")
    public Result insertBatch(@RequestBody CoreTodo[] coreTodos) {
        int addColumnNum = coreTodoService.insertBatch(coreTodos);
        if (addColumnNum == coreTodos.length) {
            return Result.success("批量增加CoreTodo成功");
        } else {
            return Result.error("批量增加CoreTodo失败");
        }
    }

    /**
     * 删除一条CoreTodo
     *
     * @param id 主键ID
     * @return 是否删除成功
     */
    @ApiOperation("删除一条CoreTodo")
    @DeleteMapping
    public Result delete(@RequestParam Long id) {
        int deleteColumnNum = coreTodoService.delete(id);
        if (deleteColumnNum >= 1) {
            return Result.success("删除CoreTodo成功");
        } else {
            return Result.error("删除CoreTodo失败");
        }
    }
    
    /**
     * 修改一条CoreTodo
     *
     * @param coreTodo CoreTodo对象
     * @return 是否修改成功
     */
    @ApiOperation("修改一条CoreTodo")
    @PutMapping
    public Result update(@RequestBody CoreTodo coreTodo) {
        int updateColumnNum = coreTodoService.update(coreTodo);
        if (updateColumnNum >= 1) {
            return Result.success("修改CoreTodo成功");
        } else {
            return Result.error("修改CoreTodo失败");
        }
    }

    /**
     * 查看任务列表（不分页）
     *
     * @return Result
     */
    @ApiOperation(value = "列表")
    @GetMapping
    public Result list(
        @RequestParam Map<String, Object> params,
        HttpServletRequest request
    ) {
        Long userId = getUserId(request);
        params.put("userId", userId);
        List<CoreTodo> coreTodos = coreTodoService.selectByParams(params);
        return Result.success(coreTodos);
    }

    /**
     * 查看任务列表（分页）
     *
     * @return Result
     */
    @ApiOperation(value = "列表")
    @GetMapping(params = { "pageNum", "pageSize" })
    public Result listWithPage(
        @RequestParam Map<String, Object> params,
        HttpServletRequest request
    ) {
        Long userId = getUserId(request);
        params.put("userId", userId);
        return coreTodoService.selectByParamsWithPage(params);
    }

}
