package com.sr.core.service;

import com.sr.core.dto.UserDTO;
import com.sr.core.mapper.SysUserMapper;
import com.sr.core.pojo.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * @author lkj
 * @date 2021/5/2
 */
@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger("adminLogger");

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public SysUser getUser(String username) {
        return sysUserMapper.getUser(username);
    }

    public SysUser saveUser(UserDTO user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(false);
        sysUserMapper.save(user);
        saveUserRoles(user.getId(), user.getRoleIds());

        log.debug("新增用户{}", user.getUsername());
        return user;
    }

    private void saveUserRoles(Long userId, List<Long> roleIds) {
        if (roleIds != null) {
            sysUserMapper.deleteUserRole(userId);
            if (!CollectionUtils.isEmpty(roleIds)) {
                sysUserMapper.saveUserRoles(userId, roleIds);
            }
        }
    }

    public void changePassword(String username, String oldPassword, String newPassword) {
        SysUser user = sysUserMapper.getUser(username);
        if (user == null) {
            throw new IllegalArgumentException("用户不存在");
        }

        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new IllegalArgumentException("旧密码错误");
        }

        int isChange = sysUserMapper.changePassword(user.getId(), passwordEncoder.encode(newPassword));
        if (isChange == 0) {
            throw new RuntimeException("修改密码失败");
        }
        log.debug("修改{}的密码", username);
    }

    @Transactional
    public SysUser updateUser(UserDTO user) {
        sysUserMapper.update(user);
        saveUserRoles(user.getId(), user.getRoleIds());

        return user;
    }

    /**
     * 获取参数条件下的记录数
     *
     * @param params 参数
     * @return 记录数
     */
    public int count(Map<String, Object> params) {
        return sysUserMapper.count(params);
    }

    /**
     * 根据参数进行分页查询
     *
     * @param params   参数
     * @param offset   偏移量
     * @param pageSize 页面大小
     * @return 查询的数据
     */
    public List<SysUser> selectByParams(
            Map<String, Object> params,
            Integer offset,
            Integer pageSize
    ) {
        return sysUserMapper.selectByParams(params, offset, pageSize);
    }

}
