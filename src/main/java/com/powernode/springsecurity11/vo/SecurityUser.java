package com.powernode.springsecurity11.vo;

import com.powernode.springsecurity11.entity.SysUser;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Author hzz
 * @Date 2024-02-29 23:54
 */
public class SecurityUser implements UserDetails {

    private final SysUser sysUser;

    public SecurityUser(SysUser sysUser){
        this.sysUser = sysUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 没有配置权限
        return null;
    }

    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return sysUser.getAccountNoExpired().equals(1);
    }

    @Override
    public boolean isAccountNonLocked() {
        return sysUser.getAccountNoLocked().equals(1);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return sysUser.getCredentialsNoExpired().equals(1);
    }

    @Override
    public boolean isEnabled() {
        return sysUser.getEnabled().equals(1);
    }
}
