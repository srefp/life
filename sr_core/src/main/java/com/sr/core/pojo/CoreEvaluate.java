package com.sr.core.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 *
 * @author lkj
 * @date 2021/06/04
 */
@Table(name = "core_evaluate")
@Data
public class CoreEvaluate {
    
    /** 评价表 */
    @Column(name = "id")
    private Long id;

    /** 评分 */
    @Column(name = "score")
    private BigDecimal score;

    /** 评价时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "create_time")
    private Date createTime;

    /** 用户ID */
    @Column(name = "user_id")
    private Long userId;

}
