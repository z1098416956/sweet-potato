package com.sweet.poato.web.service.test.Impl;

import com.sweet.poato.web.feign.MerchandiseApiService;
import com.sweet.poato.web.feign.SystemApiService;
import com.sweet.poato.web.service.test.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sweet.poato.req.system.QueryUserInfoVO;
import sweet.poato.res.Test;
import sweet.poato.res.system.UserInfoVO;
import sweet.poato.result.Result;

/**
 * @Author: TheSunshine
 * @Date: 2022/8/8 17:18
 * @Version 1.0
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private MerchandiseApiService merchandiseApiService;

    @Autowired
    private SystemApiService systemApiService;

    @Override
    public Result<String> getTestInfo() {
        Result<String> testInfo = merchandiseApiService.getTestInfo();
        return testInfo;
    }

    @Override
    public Result<Test> getTestDTO() {
        Result<Test> testDTO = merchandiseApiService.getTestDTO();
        return testDTO;
    }

    @Override
    public Result<UserInfoVO> queryUserInfoByPhone() {
        QueryUserInfoVO queryUserInfoVO = new QueryUserInfoVO();
        queryUserInfoVO.setPhone("19912341234");
        Result<UserInfoVO> result = systemApiService.queryUserInfoByPhone(queryUserInfoVO);
        return result;
    }
}
