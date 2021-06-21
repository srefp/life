package com.sr.core.mapper;

import com.sr.core.pojo.SysRolePerm;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author lkj
 * @date 2021/05/09
 */
public interface SysRolePermMapper {
    
    /**
     * 批量增加SysRolePerm
     * @param sysRolePerms SysRolePerm数组
     * @return 是否批量增加成功
     */
    int insertBatch(List<SysRolePerm> sysRolePerms);
    
}
