package com.sr.core.service;

import com.sr.core.mapper.SysRoleMapper;
import com.sr.core.pojo.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lkj
 * @date 2021/5/19
 */
@Service
public class RoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    public List<SysRole> roleList() {
        return null;
    }

    /**
     * 3. 根据ID获取角色
     * @param id 用户ID
     * @return 角色
     */
    public SysRole getRoleById(Long id) {
        return sysRoleMapper.selectById(id);
    }
}
