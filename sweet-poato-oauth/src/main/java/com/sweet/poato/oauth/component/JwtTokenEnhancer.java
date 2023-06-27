package com.sweet.poato.oauth.component;

import com.sweet.poato.oauth.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: TheSunshine
 * @Date: 2022/12/21 17:54
 * @Version 1.0
 */
@Component
public class JwtTokenEnhancer implements TokenEnhancer {

    /**
     * Provides an opportunity for customization of an access token (e.g. through its additional information map) during
     * the process of creating a new token for use by a client.
     *
     * @param accessToken    the current access token with its expiration and refresh token
     * @param authentication the current authentication including client and user details
     * @return a new token enhanced with additional information
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> info = new HashMap<>();
        String grantType = authentication.getOAuth2Request().getGrantType();
        if(grantType.equals(AuthorizationGrantType.CLIENT_CREDENTIALS.getValue())) {
            String clientId = authentication.getPrincipal().toString();
            info.put("appId",clientId);
        }
        if(grantType.equals(AuthorizationGrantType.PASSWORD.getValue())) {
            User user = (User) authentication.getPrincipal();
            if (user.getSysType() == 1) {
                return accessToken;
            }
            //TODO 如果是系统用户 可以通过feign往redis里面设置权限
        }
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
