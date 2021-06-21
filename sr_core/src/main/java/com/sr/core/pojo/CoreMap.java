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
 * @date 2021/06/04
 */
@Table(name = "core_map")
@Data
public class CoreMap {
    
    /** 映射表ID */
    @Column(name = "id")
    private Long id;

    /** 键 */
    @Column(name = "key")
    private String key;

    /** 值 */
    @Column(name = "value")
    private String value;

    /** 类别ID */
    @Column(name = "category_id")
    private Long categoryId;

    /** 用户ID */
    @Column(name = "user_id")
    private Long userId;

}
