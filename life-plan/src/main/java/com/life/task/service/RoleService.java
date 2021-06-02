package com.life.task.service;

import com.life.task.mapper.SysRoleMapper;
import com.life.task.pojo.SysRole;
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
        return sysRoleMapper.selectAll();
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
