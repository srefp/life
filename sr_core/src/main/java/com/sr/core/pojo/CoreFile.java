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
 * 文件表
 *
 * @author lkj
 * @date 2021/06/04
 */
@Table(name = "core_file")
@Data
public class CoreFile {
    
    /** 文件ID */
    @Column(name = "id")
    private Long id;

    /** 文件名 */
    @Column(name = "name")
    private String name;

    /** 文件描述 */
    @Column(name = "decription")
    private String decription;

    /** 文件的相对位置 */
    @Column(name = "location")
    private String location;

    /** 创建时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "create_time")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "update_time")
    private Date updateTime;

    /** 用户ID */
    @Column(name = "user_id")
    private Long userId;

}
