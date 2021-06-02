package com.life.task.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * 
 *
 * @author lkj
 * @date 2021/05/17
 */
@Table(name = "sys_log")
@Data
public class SysLog {
    
    /** 日志ID */
    @Column(name = "id")
    private Long id;

    /** 用户ID */
    @Column(name = "user_id")
    private Long userId;

    /** 模块 */
    @Column(name = "module")
    private String module;

    /** 是否失败（0：成功，1失败） */
    @Column(name = "flag")
    private Boolean flag;

    /** 评论 */
    @Column(name = "remark")
    private String remark;

    /** 创建时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "create_time")
    private Date createTime;

}
