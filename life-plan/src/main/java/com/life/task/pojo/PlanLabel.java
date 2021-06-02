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
 * 
 *
 * @author lkj
 * @date 2021/05/02
 */
@Table(name = "plan_label")
@Data
public class PlanLabel {
    
    /** 标签ID */
    @Column(name = "id")
    private Long id;

    /** 用户ID */
    @Column(name = "user_id")
    private Long userId;

    /** 标签名 */
    @Column(name = "name")
    private String name;

    /** 创建时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "create_time")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "update_time")
    private Date updateTime;

    /** 是否被删除（0：未被删除，1：已被删除） */
    @Column(name = "is_delete")
    private Boolean isDelete;

}
