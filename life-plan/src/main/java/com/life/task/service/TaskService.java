package com.life.task.service;

import com.life.task.mapper.TaskMapper;
import com.life.task.pojo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lkj
 * @date 2021/5/2
 */
@Service
public class TaskService {

    @Autowired
    private TaskMapper taskMapper;

    /**
     * 插入一条任务
     *
     * @param task 任务
     * @return 插入的行数
     */
    public int insertOne(Task task) {
        return taskMapper.insertOne(task);
    }

    /**
     * 根据用户ID查询任务列表
     *
     * @param params 查询条件
     * @return 任务列表
     */
    public List<Task> selectByParams(Map<String, Object> params) {
        List<Task> tasks = taskMapper.selectByParams(params);
        return setSubTask(0L, tasks);
    }

    private List<Task> setSubTask(Long parentId, List<Task> tasks) {
        // 定义父任务
        List<Task> rootTasks;
        // 给父任务添加内容
        rootTasks = tasks.stream()
                .filter(e -> e.getParentId().equals(parentId))
                .collect(Collectors.toList());

        if (rootTasks.size() == 0) {
            return null;
        }

        // 去除父任务
        tasks.removeAll(rootTasks);

        // 给子任务添加孙子任务
        rootTasks.forEach(child -> child.setChildren(setSubTask(child.getId(), tasks)));

        return rootTasks;
    }

    /**
     * 更新PlanTask
     *
     * @param task PlanTask
     * @return 更新的行数
     */
    public int updateNotNull(Task task) {
        return taskMapper.update(task);
    }
}
