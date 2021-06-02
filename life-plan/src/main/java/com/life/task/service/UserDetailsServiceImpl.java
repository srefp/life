package com.life.task.service;

import com.life.task.common.LoginUser;
import com.life.task.mapper.SysPermMapper;
import com.life.task.pojo.SysPerm;
import com.life.task.pojo.SysUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Permission;
import java.util.List;

/**
 * @author lkj
 * @date 2021/5/8
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private SysPermMapper sysPermMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = userService.getUser(username);
        if (sysUser == null) {
            throw new AuthenticationCredentialsNotFoundException("用户名不存在");
        }

        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(sysUser, loginUser);
        List<SysPerm> permissions = sysPermMapper.listByUserId(sysUser.getId());
        loginUser.setPermissions(permissions);

        return loginUser;
    }
}
