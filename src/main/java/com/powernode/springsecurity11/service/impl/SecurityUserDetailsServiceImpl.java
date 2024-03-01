package com.powernode.springsecurity11.service.impl;

import com.powernode.springsecurity11.entity.SysUser;
import com.powernode.springsecurity11.service.SysUserService;
import com.powernode.springsecurity11.vo.SecurityUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author hzz
 * @Date 2024-03-01 0:03
 */
@Service
@Slf4j
public class SecurityUserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserService.getByUserName(username);
        if(null == user){
            throw new UsernameNotFoundException("该用户不存在");
        }

        SecurityUser securityUser = new SecurityUser(user);
        return securityUser;

    }
}
