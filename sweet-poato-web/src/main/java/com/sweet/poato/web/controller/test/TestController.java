package com.sweet.poato.web.controller.test;

import com.sweet.poato.web.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sweet.poato.result.Result;

/**
 * @Author: TheSunshine
 * @Date: 2022/8/8 17:16
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/test1")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/getTestInfo",method = RequestMethod.GET)
    public Result<String> getTestInfo(){

        return testService.getTestInfo();
    }
}
