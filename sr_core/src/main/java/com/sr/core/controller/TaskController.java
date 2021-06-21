package com.sr.core.controller;

import com.sr.core.common.Result;
import com.sr.core.controller.base.BaseController;
import com.sr.core.pojo.Task;
import com.sr.core.service.TaskService;
import com.sr.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sr.core.common.TaskPageConstants.*;


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
        // 获取用户ID
        Long userId = getUserId(request);
        params.put("userId", userId);
        List<Task> tasks = taskService.selectByParams(params);
        return Result.success(tasks);
    }

    /**
     * 4. 查看任务列表，
     *
     * @return Result
     */
    @GetMapping(params = "select")
    public Result selectTask(@PathParam("select") String select, HttpServletRequest request) {
        // 获取用户ID
        Long userId = getUserId(request);
        Map<String, Object> params = new HashMap<>(3, 1L);
        params.put("userId", userId);
        params.put("delete", false);
        List<Task> tasks = null;
        if (TODAY.equals(select)) {
            tasks = taskService.selectByParams(params);
        } else if (COLLECTION_BOX.equals(select)){
            params.put("categoryId", 1L);
            tasks = taskService.selectByParams(params);
        } else if (RECENT_SEVEN_DAYS.equals(select)) {
            tasks = taskService.recentSevenDays(userId);
        } else if (FINISHED.equals(select)) {
            params.put("finish", true);
            tasks = taskService.selectByParams(params);
        } else if (DELETED.equals(select)) {
            params.put("delete", true);
            tasks = taskService.selectByParams(params);
        }
        Result result = Result.success(tasks);
        if (tasks != null) {
            result.put("total", tasks.size());
        }
        return result;
    }

}
