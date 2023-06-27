package com.sweet.poato.merchandise.controller;

import com.sweet.poato.merchandise.service.MerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sweet.poato.res.Test;
import sweet.poato.result.Result;

/**
 * @Author: TheSunshine
 * @Date: 2022/8/8 16:39
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/test")
public class MerchandiseController  {


    @Autowired
    private MerchandiseService merchandiseService;

    @RequestMapping(value = "/getTestInfo",method = RequestMethod.GET)
    public Result<String> getTestInfo() {

        return merchandiseService.getTestInfo();
    }


    @RequestMapping(value = "/getTestDTO",method = RequestMethod.GET)
    public Result<Test> getTestDTO(){

        return merchandiseService.getTestDTO();
    }
}
