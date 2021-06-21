package com.sr.core.service;


import com.sr.core.mapper.CoreTodoMapper;
import com.sr.core.common.Result;
import com.sr.core.pojo.CoreTodo;
import org.springframework.beans.factory.annotation.Autowired;
import com.sr.core.page.PageHandler;
import com.sr.core.page.PageRequest;
import com.sr.core.page.PageResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lkj
 * @date 2021/06/09
 */
@Service
public class CoreTodoService {

    @Autowired
    private CoreTodoMapper coreTodoMapper;

    /**
     * 增加一条CoreTodo
     *
     * @param coreTodo CoreTodo对象
     * @return 增加的记录数
     */
    public int insert(CoreTodo coreTodo) {
        return coreTodoMapper.insert(coreTodo);
    }

    /**
     * 批量增加CoreTodo
     *
     * @param coreTodos CoreTodo数组
     * @return 是否批量增加成功
     */
    public int insertBatch(CoreTodo[] coreTodos) {
        List<CoreTodo> collect = Arrays.stream(coreTodos).collect(Collectors.toList());
        return coreTodoMapper.insertBatch(collect);
    }

    /**
     * 删除一条CoreTodo
     *
     * @param id 主键ID
     * @return 删除的记录数
     */
    public int delete(Long id) {
        return coreTodoMapper.delete(id);
    }

    /**
     * 更新一条CoreTodo
     *
     * @param coreTodo CoreTodo对象
     * @return 更新的记录数
     */
    public int update(CoreTodo coreTodo) {
        return coreTodoMapper.update(coreTodo);
    }

    /**
     * 根据条件查询CoreTodo列表
     *
     * @param params 查询条件
     * @return CoreTodo列表
     */
    public List<CoreTodo> selectByParams(Map<String, Object> params) {
        return coreTodoMapper.selectByParams(params);
    }

    /**
     * 根据条件查询数据条数
     *
     * @param params 查询条件
     * @return 满足条件的数据记录数
     */
    public int count(Map<String, Object> params) {
        return coreTodoMapper.count(params);
    }

    /**
     * 根据参数进行分页查询
     *
     * @param params 参数
     * @return 查询的数据
     */
    public Result selectByParamsWithPage(
            Map<String, Object> params
    ) {
        int pageNum = (int) params.get("pageNum");
        int pageSize = (int) params.get("pageSize");
        PageRequest pageRequest = new PageRequest(pageNum, pageSize, params);
        PageResponse pageResponse = new PageHandler(
                req -> coreTodoMapper.count(req.getParams()),
                req -> coreTodoMapper.selectByParamsWithPage(params, (req.getPageNum() - 1) * req.getPageSize(), req.getPageSize())
        ).handle(pageRequest);

        Result result = Result.success();
        result.put("total", pageResponse.getTotal());
        result.put("data", pageResponse.getData());
        return result;
    }

}
