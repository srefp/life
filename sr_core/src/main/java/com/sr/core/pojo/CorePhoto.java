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
@Table(name = "core_photo")
@Data
public class CorePhoto {
    
    /** 图片ID */
    @Column(name = "id")
    private Long id;

    /** 图片名称 */
    @Column(name = "name")
    private String name;

    /** 保存路径（相对路径） */
    @Column(name = "location")
    private String location;

    /** 图片描述 */
    @Column(name = "description")
    private String description;

    /** 创建时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "create_time")
    private Date createTime;

    /** 用户ID */
    @Column(name = "user_id")
    private Long userId;

}
