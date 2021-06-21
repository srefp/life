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
 * 记账表
 *
 * @author lkj
 * @date 2021/06/04
 */
@Table(name = "core_account")
@Data
public class CoreAccount {
    
    /** 账单ID */
    @Column(name = "id")
    private Long id;

    /** 账单金额 */
    @Column(name = "amount")
    private BigDecimal amount;

    /** 花费描述 */
    @Column(name = "content")
    private String content;

    /** 账单种类ID */
    @Column(name = "category_id")
    private Long categoryId;

    /** 支付时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "pay_time")
    private Date payTime;

    /** 账单类型（1：正常消费，2：借款，3：还款） */
    @Column(name = "kind")
    private Integer kind;

    /** 用户ID */
    @Column(name = "user_id")
    private Long userId;

}
