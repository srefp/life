package com.life.task.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author lkj
 * @date 2021/5/14
 */
@Data
public class BaseEntity<ID> {

    private ID id;

    private Date createTime = new Date();

    private Date updateTime = new Date();

}
