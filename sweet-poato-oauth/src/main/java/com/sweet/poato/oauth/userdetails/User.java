package com.sweet.poato.oauth.userdetails;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * @Author: TheSunshine
 * @Date: 2022/12/21 18:10
 * @Version 1.0
 */
@Data
public class User implements UserDetails {
    /**
     * 用户ID
     */
    private  Long id;

    /**
     * 登录账号
     */
    private  String username;

    /**
     * 密码
     */
    private  String password;

    /**
     * 真实名称
     */
    private  String name;

    /**
     * 头像
     */
    private  String avatar;


    /**
     * 手机号码
     */
    private String phone;


    /**
     * 0女1男2保密
     */
    private Integer sex;

    /**
     * 用户类型1 普通用户 2系统用户
     */
    private  Integer sysType;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

    public User(){}


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
