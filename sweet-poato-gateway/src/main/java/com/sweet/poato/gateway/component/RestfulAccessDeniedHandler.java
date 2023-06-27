package com.sweet.poato.gateway.component;

import cn.hutool.json.JSONUtil;
import com.sweet.poato.gateway.handle.GateWayErrorWebExceptionHandler;
import com.sweet.poato.gateway.utils.Result;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/2/22 13:46
 */
@Component
public class RestfulAccessDeniedHandler /*implements ServerAccessDeniedHandler*/{




    /**
     * 自定义返回结果：没有权限访问时
     */
   /* @Override
    public Mono<Void> handle(ServerWebExchange serverWebExchange, AccessDeniedException e) {
        ServerHttpResponse response = serverWebExchange.getResponse();
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        response.getHeaders().set("Access-Control-Allow-Origin", "*");
        response.getHeaders().set("Cache-Control", "no-cache");
        response.getHeaders().set("Access-Control-Allow-Credentials", "true");
        response.getHeaders().set("Access-Control-Allow-Methods", "*");
        response.getHeaders().set("Access-Control-Allow-Headers", "Content-Type,Access-Token");
        response.getHeaders().set("Access-Control-Expose-Headers", "*");
        String body= JSONUtil.toJsonStr(Result.forbidden(e.getMessage()));
        DataBuffer buffer =  response.bufferFactory().wrap(body.getBytes(Charset.forName("UTF-8")));
        return response.writeWith(Mono.just(buffer));
    }*/


}
