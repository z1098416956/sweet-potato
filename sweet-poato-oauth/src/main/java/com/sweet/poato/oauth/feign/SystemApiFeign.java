package com.sweet.poato.oauth.feign;

import com.sweet.poato.oauth.utils.Result;
import com.sweet.poato.oauth.vo.QueryUserInfoVO;
import com.sweet.poato.oauth.vo.UserInfoVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: TheSunshine
 * @Date: 2022/12/22 18:49
 * @Version 1.0
 */
@FeignClient(name = "system-service")
public interface SystemApiFeign {

    /**
     * 根据手机号查询用户信息
     * @param queryUserInfoVO
     * @return
     */
    @RequestMapping(value = "/v1/user/queryUserInfoByPhone",method = RequestMethod.POST)
    public Result<UserInfoVO> queryUserInfoByPhone(@RequestBody QueryUserInfoVO queryUserInfoVO);
}
