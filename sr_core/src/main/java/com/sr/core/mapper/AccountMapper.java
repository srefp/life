package com.sr.core.mapper;

import com.sr.core.pojo.CoreAccount;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author lkj
 * @date 2021/06/01
 */
public interface AccountMapper {

    /**
     * 批量增加CoreAccount
     *
     * @param accounts CoreAccount数组
     * @return 是否批量增加成功
     */
    int insertBatch(List<CoreAccount> accounts);

    /**
     * 根据条件查询账单列表
     *
     * @param params 查询条件
     * @return 账单列表
     */
    List<CoreAccount> selectByParams(@Param("params") Map<String, Object> params);

    /**
     * 根据参数进行分页查询
     *
     * @param params 参数
     * @param offset 偏移量
     * @param pageSize 页面大小
     * @return 查询的数据
     */
    List<CoreAccount> selectByParamsWithPage(
            @Param("params") Map<String, Object> params,
            @Param("offset") Integer offset,
            @Param("pageSize") Integer pageSize
    );

    /**
     * 根据条件查询数据条数
     * @param params 查询条件
     * @return 查询的数据
     */
    int count(@Param("params") Map<String, Object> params);

}
