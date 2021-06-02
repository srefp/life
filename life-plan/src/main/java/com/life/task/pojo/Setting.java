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
 * @date 2021/06/01
 */
@Table(name = "setting")
@Data
public class Setting {
    
    /** 自定义设置key */
    @Column(name = "key")
    private String key;

    /** 用户ID */
    @Column(name = "user_id")
    private Long userId;

    /** 自定义设置value */
    @Column(name = "value")
    private String value;

    /** 排序 */
    @Column(name = "order_num")
    private Integer orderNum;

}
