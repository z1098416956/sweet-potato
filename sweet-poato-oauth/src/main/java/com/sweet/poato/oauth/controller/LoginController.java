package com.sweet.poato.oauth.controller;

import com.sweet.poato.oauth.utils.Result;
import com.sweet.poato.oauth.vo.PassportTokenVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

/**
 * @Author: TheSunshine
 * @Date: 2022/12/22 19:07
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/oauth")
public class LoginController {

    @Autowired
    private TokenEndpoint tokenEndpoint;



    /**
     * 登录
     * @param principal
     * @param parameterMap
     * @return
     * @throws HttpRequestMethodNotSupportedException
     */
    @PostMapping("/token")
    public Result<PassportTokenVO> login (Principal principal, @RequestParam Map<String, String> parameterMap){
        try {
            String grantType = parameterMap.get(OAuth2Utils.GRANT_TYPE);
            OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(principal, parameterMap).getBody();
            PassportTokenVO passportTokenVO = null;
            if(grantType.equals(AuthorizationGrantType.CLIENT_CREDENTIALS.getValue())) {
                passportTokenVO = PassportTokenVO.builder()
                        .accessToken(oAuth2AccessToken.getValue())
                        .expiresIn(oAuth2AccessToken.getExpiresIn())
                        .tokenHead("Bearer ").build();
            }
            if(grantType.equals(AuthorizationGrantType.PASSWORD.getValue())) {
                passportTokenVO = PassportTokenVO.builder()
                        .accessToken(oAuth2AccessToken.getValue())
                        .refreshToken(oAuth2AccessToken.getRefreshToken().getValue())
                        .expiresIn(oAuth2AccessToken.getExpiresIn())
                        .tokenHead("Bearer ").build();
            }
            return Result.success("成功",passportTokenVO);
        }catch (Exception e){
            log.error("e ==========> :{}",e);
            return Result.error(401,"认证失败");
        }

    }
}
