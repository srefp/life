package com.sr.core.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 
 *
 * @author lkj
 * @date 2021/06/01
 */
@Table(name = "user_setting")
@Data
public class UserSetting {
    
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
