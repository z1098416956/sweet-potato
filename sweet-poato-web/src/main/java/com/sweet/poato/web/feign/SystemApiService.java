package com.sweet.poato.web.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sweet.poato.req.system.QueryUserInfoVO;
import sweet.poato.res.system.UserInfoVO;
import sweet.poato.result.Result;

@FeignClient(name = "system-service")
public interface SystemApiService {


  @RequestMapping(value = "/v1/user/queryUserInfoByPhone",method = RequestMethod.POST)
  public Result<UserInfoVO> queryUserInfoByPhone(@RequestBody QueryUserInfoVO queryUserInfoVO);
}
