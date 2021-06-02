package com.life.task.mapper;

import com.life.task.pojo.SysPerm;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.security.Permission;
import java.util.List;

/**
 * @author lkj
 * @date 2021/05/09
 */
public interface SysPermMapper extends Mapper<SysPerm> {
    
    /**
     * 批量增加SysPerm
     * @param sysPerms SysPerm数组
     * @return 是否批量增加成功
     */
    int insertBatch(List<SysPerm> sysPerms);

    /**
     * 通过用户ID获取用户对应的权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    List<SysPerm> listByUserId(@Param("userId") Long userId);
}
