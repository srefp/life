package com.life.task.mapper;

import com.life.task.pojo.Task;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author lkj
 * @date 2021/05/02
 */
public interface TaskMapper extends Mapper<Task> {
    
    int insertOne(Task task);

    /**
     * 根据条件查询任务列表
     * @param params 查询条件
     * @return 任务列表
     */
    List<Task> selectByParams(@Param("params") Map<String, Object> params);

    /**
     * 更新不为空的属性
     *
     * @param task 任务
     * @return 更改的行数
     */
    int update(Task task);

    /**
     * 批量增加PlanTask
     * @param tasks PlanTask数组
     * @return 是否批量增加成功
     */
    int insertBatch(List<Task> tasks);

}
