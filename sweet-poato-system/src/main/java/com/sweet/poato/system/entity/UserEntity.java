package com.sweet.poato.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import sweet.poato.base.BaseEntity;

/**
 * @Author: TheSunshine
 * @Date: 2022/12/22 18:16
 * @Version 1.0
 */
@Data
@TableName(value = "system_user")
public class UserEntity extends BaseEntity {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 用户名称
     */
    private String username;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * 用户真实头像
     */
    private String name;
    /**
     * 性别 0女1男2保密
     */
    private Integer sex;
    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户类型1 普通用户 2系统用户
     */
    private Integer sysType;
}
