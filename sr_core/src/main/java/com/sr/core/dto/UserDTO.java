package com.sr.core.dto;

import com.sr.core.pojo.SysUser;
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
