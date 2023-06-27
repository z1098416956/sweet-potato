package com.sweet.poato.web.controller.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sweet.poato.result.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/3/29 12:00
 */
@RestController
@RequestMapping(value = "/v1/user")
public class UserController {

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    public Result<Map<String,Object>> getUserInfo(){
        Map<String, Object> objectObjectHashMap = new HashMap<>();
        return Result.success("成功",objectObjectHashMap);
    }
}
