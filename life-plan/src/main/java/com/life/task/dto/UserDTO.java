package com.life.task.dto;

import com.life.task.pojo.SysUser;
import lombok.Data;

import java.util.List;

/**
 * @author lkj
 * @date 2021/5/14
 */
@Data
public class UserDTO extends SysUser {

    private List<Long> roleIds;

}
