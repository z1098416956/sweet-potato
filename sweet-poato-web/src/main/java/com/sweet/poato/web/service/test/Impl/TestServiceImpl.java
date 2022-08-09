package com.sweet.poato.web.service.test.Impl;

import com.sweet.poato.web.feign.MerchandiseApiService;
import com.sweet.poato.web.service.test.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Override
    public Result<String> getTestInfo() {
        merchandiseApiService.getTestInfo();
        return Result.success("sss",222);
    }
}
