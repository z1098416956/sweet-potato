package com.sweet.poato.system.service;

import sweet.poato.req.system.QueryUserInfoVO;
import sweet.poato.res.system.UserInfoVO;
import sweet.poato.result.Result;

/**
 * @Author: TheSunshine
 * @Date: 2022/12/22 18:36
 * @Version 1.0
 */
public interface UserService {

    /**
     * 根据手机号查询用户信息
     * @param queryUserInfoVO
     * @return
     */
    public Result<UserInfoVO> queryUserInfoByPhone(QueryUserInfoVO queryUserInfoVO);
}
