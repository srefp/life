package com.life.task.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
