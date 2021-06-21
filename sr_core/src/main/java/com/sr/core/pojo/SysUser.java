package com.sr.core.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * 
 *
 * @author lkj
 * @date 2021/05/14
 */
@Table(name = "sys_user")
@Data
public class SysUser {
    
    /** 用户ID */
    @Column(name = "id")
    private Long id;

    /** 用户名 */
    @Column(name = "username")
    private String username;

    /** 手机号 */
    @Column(name = "telephone")
    private String telephone;

    /** 密码 */
    @JsonIgnore
    @Column(name = "password")
    private String password;

    /** 邮箱 */
    @Column(name = "email")
    private String email;

    /** 生日 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "birthday")
    private Date birthday;

    /** 性别 */
    @Column(name = "sex")
    private Boolean sex;

    /** 用户头像 */
    @JsonIgnore
    @Column(name = "head_portrait")
    private String headPortrait;

    /** 是否在线（0：离线，1：在线） */
    @Column(name = "status")
    private Boolean status;

    /** 是否被删除（0：未被删除，1：已被删除） */
    @Column(name = "is_delete")
    private Boolean delete;

    /** 创建时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "create_time")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "update_time")
    private Date updateTime;

}
