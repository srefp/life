package com.life.task.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.life.task.pojo.SysPerm;
import com.life.task.pojo.SysUser;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lkj
 * @date 2021/5/8
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginUser extends SysUser implements UserDetails {

    private Boolean credentialsNonExpired = true;

    private Boolean accountNonLocked = true;

    private Boolean accountNonExpired = true;

    private Boolean enabled = true;

    private Collection<? extends GrantedAuthority> authorities;

    private Integer expireSeconds = 7200;

    private List<SysPerm> permissions;

    private String token;

    /** 登录时间戳（毫秒） */
    private Long loginTime;

    /** 过期时间戳 */
    private Long expireTime;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissions.parallelStream().filter(p -> !StringUtils.isEmpty(p.getPerms()))
                .map(p -> new SimpleGrantedAuthority(p.getPerms()))
                .collect(Collectors.toSet());
    }

    /**
     * 账号是否未过期
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账号是否未锁定
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是否未过期
     */
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账号是否激活
     */
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

}
