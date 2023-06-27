package com.sweet.poato.system.dao;

import com.sweet.poato.system.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import sweet.poato.base.CommonMapper;
import sweet.poato.base.LambdaQueryWrapperX;

import java.util.List;

/**
 * @Author: TheSunshine
 * @Date: 2022/12/22 18:25
 * @Version 1.0
 */
@Mapper
public interface UserDao extends CommonMapper<UserEntity> {

    default UserEntity queryUserInfoByPhone(String phone){
        LambdaQueryWrapperX<UserEntity> lambdaQueryWrapperX = new LambdaQueryWrapperX<>();
        lambdaQueryWrapperX.eq(UserEntity::getPhone,phone);
        List<UserEntity> userEntities = selectList(lambdaQueryWrapperX);
        if (CollectionUtils.isEmpty(userEntities)){
            return null;
        }
        return userEntities.get(0);
    }
}
