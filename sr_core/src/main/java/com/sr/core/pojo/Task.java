package com.sr.core.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * 
 *
 * @author lkj
 * @date 2021/05/26
 */
@Table(name = "core_task")
@Data
public class Task {
    
    /** 任务ID */
    @Column(name = "id")
    private Long id;

    /** 父任务ID（ID为0表示无父任务） */
    @Column(name = "parent_id")
    private Long parentId;

    /** 类别ID */
    @Column(name = "category_id")
    private Long categoryId;

    /** 内容 */
    @Column(name = "content")
    private String content;

    /** 优先级（0：未标注，1：低优先级，2：中优先级，3高优先级） */
    @Column(name = "priority")
    private Integer priority;

    /** 排序编号 */
    @Column(name = "order_num")
    private Integer orderNum;

    /** 开始时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "start_time")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "end_time")
    private Date endTime;

    /** 创建时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "create_time")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "update_time")
    private Date updateTime;

    /** 是否已完成（0：未完成，1：已完成） */
    @Column(name = "is_finish")
    private Boolean finish;

    /** 是否被删除（0：未被删除，1：已被删除） */
    @Column(name = "is_delete")
    private Boolean delete;

    /** 用户ID */
    @JsonIgnore
    @Column(name = "user_id")
    private Long userId;

    private List<Task> children;

}
