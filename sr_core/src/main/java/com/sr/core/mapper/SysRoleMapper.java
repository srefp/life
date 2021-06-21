package com.sr.core.mapper;

import com.sr.core.pojo.SysRole;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author lkj
 * @date 2021/05/08
 */
public interface SysRoleMapper {
    
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
