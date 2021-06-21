package com.sr.core.mapper;

import com.sr.core.pojo.CoreCategory;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author lkj
 * @date 2021/06/04
 */
public interface CoreCategoryMapper {

    /**
     * 插入一条CoreCategory
     *
     * @param coreCategory CoreCategory对象
     * @return 插入的行数
     */
    int insert(CoreCategory coreCategory);

    /**
     * 批量增加CoreCategory
     *
     * @param coreCategorys CoreCategory数组
     * @return 批量增加的记录数
     */
    int insertBatch(List<CoreCategory> coreCategorys);

    /**
     * 删除一条CoreCategory
     *
     * @param coreCategory CoreCategory对象
     * @return 删除的记录数
     */
    int delete(CoreCategory coreCategory);

    /**
     * 更新一条CoreCategory
     *
     * @param coreCategory CoreCategory对象
     * @return 删除的记录数
     */
    int update(CoreCategory coreCategory);

    /**
     * 根据条件查询CoreCategory列表
     * @param params 查询条件
     * @return CoreCategory列表
     */
    List<CoreCategory> selectByParams(@Param("params") Map<String, Object> params);

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
    List<CoreCategory> selectByParamsWithPage(
        @Param("params") Map<String, Object> params,
        @Param("offset") Integer offset,
        @Param("pageSize") Integer pageSize
    );

}
