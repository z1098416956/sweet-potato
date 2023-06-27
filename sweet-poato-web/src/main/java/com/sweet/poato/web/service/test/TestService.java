package com.sweet.poato.web.service.test;

import sweet.poato.res.Test;
import sweet.poato.res.system.UserInfoVO;
import sweet.poato.result.Result;

/**
 * @Author: TheSunshine
 * @Date: 2022/8/8 17:17
 * @Version 1.0
 */
public interface TestService {

    public Result<String> getTestInfo();

    public Result<Test> getTestDTO();

    public Result<UserInfoVO> queryUserInfoByPhone();
}
