package com.sweet.poato.gateway.component;

import cn.hutool.json.JSONUtil;
import com.sweet.poato.gateway.utils.Result;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/2/22 14:26
 */
@Component
public class RestAuthenticationEntryPoint implements ServerAuthenticationEntryPoint {

    /**
     * 自定义返回结果：没有登录或token过期时
     */
    @Override
    public Mono<Void> commence(ServerWebExchange serverWebExchange, AuthenticationException e) {
        ServerHttpResponse response = serverWebExchange.getResponse();
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        response.getHeaders().set("Access-Control-Allow-Origin", "*");
        response.getHeaders().set("Cache-Control", "no-cache");
        response.getHeaders().set("Access-Control-Allow-Credentials", "true");
        response.getHeaders().set("Access-Control-Allow-Methods", "*");
        response.getHeaders().set("Access-Control-Allow-Headers", "Content-Type,Access-Token");
        response.getHeaders().set("Access-Control-Expose-Headers", "*");
        String body= JSONUtil.toJsonStr(Result.unauthorized(e.getMessage()));
        DataBuffer buffer =  response.bufferFactory().wrap(body.getBytes(Charset.forName("UTF-8")));
        return response.writeWith(Mono.just(buffer));
    }
}
