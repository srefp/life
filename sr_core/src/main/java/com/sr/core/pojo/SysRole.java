package com.sr.core.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * 角色信息表
 *
 * @author lkj
 * @date 2021/05/08
 */
@Table(name = "sys_role")
@Data
public class SysRole {
    
    /** 角色ID */
    @Column(name = "role_id")
    private Long roleId;

    /** 角色名称 */
    @Column(name = "role_name")
    private String roleName;

    /** 角色权限字符串 */
    @Column(name = "role_key")
    private String roleKey;

    /** 数据范围（1：全部数据权限 2：自定数据权限 3：本班级数据权限 4：仅本人数据权限） */
    @Column(name = "data_scope")
    private String dataScope;

    /** 描述 */
    @Column(name = "description")
    private String description;

    /** 创建时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "create_time")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "update_time")
    private Date updateTime;

}
