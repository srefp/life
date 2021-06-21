package com.sr.core.pojo;

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
 * @date 2021/06/09
 */
@Table(name = "core_todo")
@Data
public class CoreTodo {
    
    /** 番茄钟ID */
    @Column(name = "id")
    private Long id;

    /** 是否完成 */
    @Column(name = "is_finish")
    private Boolean isFinish;

    /** 开始时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "start_time")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "end_time")
    private Date endTime;

    /** 任务ID */
    @Column(name = "task_id")
    private Long taskId;

    /** 用户ID */
    @JsonIgnore
    @Column(name = "user_id")
    private Long userId;

}
