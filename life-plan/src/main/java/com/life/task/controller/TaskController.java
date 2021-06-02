package com.life.task.controller;

import com.life.task.common.Result;
import com.life.task.controller.base.BaseController;
import com.life.task.pojo.Task;
import com.life.task.pojo.SysUser;
import com.life.task.service.TaskService;
import com.life.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author lkj
 * @date 2021/5/1
 */
@CrossOrigin
@RestController
@RequestMapping("/task")
public class TaskController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    /**
     * 1. 新建一个任务放在收集箱中
     *
     * @return Result
     */
    @PostMapping
    public Result insertTask(@RequestBody Task task, HttpServletRequest request) {
        Long userId = getUserId(request);
        task.setUserId(userId);
        taskService.insertOne(task);
        return Result.success("新建任务成功");
    }

    /**
     * 2. 修改任务
     *
     * @return Result
     */
    @PutMapping
    public Result updateTask(@RequestBody Task task) {
        int updateColumn = taskService.updateNotNull(task);
        System.out.println(updateColumn);
        Result result = Result.success(task);
        result.put("updates", updateColumn);
        return result;
    }

    /**
     * 3. 查看任务列表
     *
     * @return Result
     */
    @GetMapping
    public Result taskList(
            @RequestParam Map<String, Object> params,
            HttpServletRequest request
    ) {
        String simpleName = params.getClass().getSimpleName();
        System.out.println(simpleName);
        // 获取用户ID
        Long userId = getUserId(request);
        params.put("userId", userId);
        List<Task> tasks = taskService.selectByParams(params);
        return Result.success(tasks);
    }

}
