package com.sr.core.mapper;

import com.sr.core.pojo.CoreMap;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author lkj
 * @date 2021/06/04
 */
public interface CoreMapMapper {

    /**
     * 插入一条CoreMap
     *
     * @param coreMap CoreMap对象
     * @return 插入的行数
     */
    int insert(CoreMap coreMap);

    /**
     * 批量增加CoreMap
     *
     * @param coreMaps CoreMap数组
     * @return 批量增加的记录数
     */
    int insertBatch(List<CoreMap> coreMaps);

    /**
     * 删除一条CoreMap
     *
     * @param id 主键ID
     * @return 删除的记录数
     */
    int delete(Long id);

    /**
     * 更新一条CoreMap
     *
     * @param coreMap CoreMap对象
     * @return 删除的记录数
     */
    int update(CoreMap coreMap);

    /**
     * 根据条件查询CoreMap列表
     * @param params 查询条件
     * @return CoreMap列表
     */
    List<CoreMap> selectByParams(@Param("params") Map<String, Object> params);

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
    List<CoreMap> selectByParamsWithPage(
        @Param("params") Map<String, Object> params,
        @Param("offset") Integer offset,
        @Param("pageSize") Integer pageSize
    );

}
