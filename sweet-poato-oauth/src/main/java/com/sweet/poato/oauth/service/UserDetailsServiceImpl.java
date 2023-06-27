package com.sweet.poato.oauth.service;

import com.sweet.poato.oauth.feign.SystemApiFeign;
import com.sweet.poato.oauth.utils.Result;
import com.sweet.poato.oauth.vo.QueryUserInfoVO;
import com.sweet.poato.oauth.vo.UserInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.sweet.poato.oauth.userdetails.User;

/**
 * @Author: TheSunshine
 * @Date: 2022/12/19 17:18
 * @Version 1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SystemApiFeign systemApiFeign;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryUserInfoVO queryUserInfoVO = new QueryUserInfoVO();
        queryUserInfoVO.setPhone(username);
        Result<UserInfoVO> result = systemApiFeign.queryUserInfoByPhone(queryUserInfoVO);
        if (!result.getSuccess()){
            //TODO 这里需要完善全局异常处理 暂时不处理
        }
        UserInfoVO data = result.getData();
        User user = new User();
        BeanUtils.copyProperties(data,user);
        return user;
    }
}
