package com.sr.core.mapper;

import com.sr.core.pojo.CoreTodo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author lkj
 * @date 2021/06/09
 */
public interface CoreTodoMapper {

    /**
     * 插入一条CoreTodo
     *
     * @param coreTodo CoreTodo对象
     * @return 插入的行数
     */
    int insert(CoreTodo coreTodo);

    /**
     * 批量增加CoreTodo
     *
     * @param coreTodos CoreTodo数组
     * @return 批量增加的记录数
     */
    int insertBatch(List<CoreTodo> coreTodos);

    /**
     * 删除一条CoreTodo
     *
     * @param id 主键ID
     * @return 删除的记录数
     */
    int delete(Long id);

    /**
     * 更新一条CoreTodo
     *
     * @param coreTodo CoreTodo对象
     * @return 删除的记录数
     */
    int update(CoreTodo coreTodo);

    /**
     * 根据条件查询CoreTodo列表
     * @param params 查询条件
     * @return CoreTodo列表
     */
    List<CoreTodo> selectByParams(@Param("params") Map<String, Object> params);

    /**
     * 根据条件查询数据条数
     *
     * @param params 查询条件
     * @return 满足条件的数据记录数
     */
    int count(@Param("params") Map<String, Object> params);

    /**
     * 根据参数进行分页查询
     *
     * @param params 参数
     * @param offset 偏移量
     * @param pageSize 页面大小
     * @return 查询的数据
     */
    List<CoreTodo> selectByParamsWithPage(
        @Param("params") Map<String, Object> params,
        @Param("offset") Integer offset,
        @Param("pageSize") Integer pageSize
    );

}
