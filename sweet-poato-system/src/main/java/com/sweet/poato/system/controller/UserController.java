package com.sweet.poato.system.controller;

import com.sweet.poato.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sweet.poato.req.system.QueryUserInfoVO;
import sweet.poato.res.system.UserInfoVO;
import sweet.poato.result.Result;

/**
 * @Author: TheSunshine
 * @Date: 2022/12/22 18:46
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据手机号查询用户信息
     * @param queryUserInfoVO
     * @return
     */
    @RequestMapping(value = "/queryUserInfoByPhone",method = RequestMethod.POST)
    public Result<UserInfoVO> queryUserInfoByPhone(@RequestBody QueryUserInfoVO queryUserInfoVO){

        return userService.queryUserInfoByPhone(queryUserInfoVO);
    }

}
