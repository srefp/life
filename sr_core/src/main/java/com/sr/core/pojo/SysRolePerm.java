package com.sr.core.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 角色和菜单关联表
 *
 * @author lkj
 * @date 2021/05/09
 */
@Table(name = "sys_role_perm")
@Data
public class SysRolePerm {
    
    /** 角色ID */
    @Column(name = "role_id")
    private Long roleId;

    /** 权限ID */
    @Column(name = "perm_id")
    private Long permId;

}
