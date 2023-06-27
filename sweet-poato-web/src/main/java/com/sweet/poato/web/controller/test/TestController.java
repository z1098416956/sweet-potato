package com.sweet.poato.web.controller.test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sweet.poato.web.service.student.StudentService;
import com.sweet.poato.web.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sweet.poato.res.Test;
import sweet.poato.res.student.StudentListVO;
import sweet.poato.res.system.UserInfoVO;
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

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/getTestInfo",method = RequestMethod.GET)
    public Result<Page<StudentListVO>> queryStudentPage(){

        return studentService.queryStudentPage("aaa");
    }

    @RequestMapping(value = "/getTestDTO",method = RequestMethod.GET)
    public Result<Test> getTestDTO(){

        return testService.getTestDTO();
    }

    @RequestMapping(value = "/getTest1",method = RequestMethod.POST)
    public Result getTest1(@RequestBody String body){
        return Result.success("成功","1");
    }



    @RequestMapping(value = "/queryUserInfoByPhone",method = RequestMethod.GET)
    public Result<UserInfoVO> queryUserInfoByPhone(){

        return testService.queryUserInfoByPhone();
    }
}
