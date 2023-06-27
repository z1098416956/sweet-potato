package com.sweet.poato.system.service.impl;

import com.sweet.poato.system.dao.UserDao;
import com.sweet.poato.system.entity.UserEntity;
import com.sweet.poato.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sweet.poato.enums.SystemErrorCodeConstants;
import sweet.poato.req.system.QueryUserInfoVO;
import sweet.poato.res.system.UserInfoVO;
import sweet.poato.result.Result;

import javax.annotation.Resource;

/**
 * @Author: TheSunshine
 * @Date: 2022/12/22 18:38
 * @Version 1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    /**
     * 根据手机号查询用户信息
     *
     * @param queryUserInfoVO
     * @return
     */
    @Override
    public Result<UserInfoVO> queryUserInfoByPhone(QueryUserInfoVO queryUserInfoVO) {
        UserEntity userEntity = userDao.queryUserInfoByPhone(queryUserInfoVO.getPhone());
        if (userEntity == null){
            return Result.error(SystemErrorCodeConstants.USER_NOT_EXIST);
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(userEntity,userInfoVO);
        return Result.success("成功",userInfoVO);
    }
}
