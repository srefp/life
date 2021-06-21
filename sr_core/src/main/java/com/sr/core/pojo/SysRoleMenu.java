package com.sr.core.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 角色和菜单关联表
 *
 * @author lkj
 * @date 2021/05/08
 */
@Table(name = "sys_role_menu")
@Data
public class SysRoleMenu {
    
    /** 角色ID */
    @Column(name = "role_id")
    private Long roleId;

    /** 菜单ID */
    @Column(name = "menu_id")
    private Long menuId;

}
