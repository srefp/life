package com.life.task.mapper;

import com.life.task.pojo.SysRole;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author lkj
 * @date 2021/05/08
 */
public interface SysRoleMapper extends Mapper<SysRole> {
    
    /**
     * 批量增加SysRole
     * @param sysRoles SysRole数组
     * @return 是否批量增加成功
     */
    int insertBatch(List<SysRole> sysRoles);

    /**
     * 根据ID获取角色
     * @param id 用户ID
     * @return 角色
     */
    SysRole selectById(Long id);
}
