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
 * 菜单权限表
 *
 * @author lkj
 * @date 2021/05/09
 */
@Table(name = "sys_perm")
@Data
public class SysPerm {
    
    /** 菜单ID */
    @Column(name = "id")
    private Long id;

    /** 菜单名称 */
    @Column(name = "name")
    private String name;

    /** 父菜单ID */
    @Column(name = "parent_id")
    private Long parentId;

    /** 显示顺序 */
    @Column(name = "order_num")
    private Integer orderNum;

    /** 组件路径 */
    @Column(name = "component")
    private String component;

    /** 菜单类型（D:目录 M:菜单 B:按钮） */
    @Column(name = "type")
    private String type;

    /** 菜单状态（0:显示 1:隐藏） */
    @Column(name = "is_visible")
    private Boolean visible;

    /** 权限标识 */
    @Column(name = "perms")
    private String perms;

    /** 菜单图标 */
    @Column(name = "icon")
    private String icon;

    /** 路由地址 */
    @Column(name = "path")
    private String path;

    /** 是否为外链（0:是 1:否） */
    @Column(name = "is_frame")
    private Boolean frame;

    /** 是否缓存（0缓存 1不缓存） */
    @Column(name = "is_cache")
    private Boolean cache;

}
