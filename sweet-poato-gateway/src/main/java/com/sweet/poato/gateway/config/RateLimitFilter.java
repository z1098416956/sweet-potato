package com.sweet.poato.gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
/**
 * 利用redis限流
 * @author The Sunshine
 * @version 1.0
 * @date 2023/6/19 15:45
 */
@Component
public class RateLimitFilter extends AbstractGatewayFilterFactory<RateLimitFilter.Config> {

    private final RedisTemplate<String, Object> redisTemplate;

    public RateLimitFilter(RedisTemplate<String, Object> redisTemplate) {
        super(Config.class);
        this.redisTemplate = redisTemplate;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // 从请求中获取IP地址或其他唯一标识符
            String key = exchange.getRequest().getRemoteAddress().getHostName();

            // 利用Redis实现限流逻辑，这里使用简单的计数器
            long count = redisTemplate.opsForValue().increment(key, 1);
            if (count > config.getMaxRequests()) {
                // 达到限流阈值，返回429 Too Many Requests错误
                exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
                return exchange.getResponse().setComplete();
            }

            // 未达到限流阈值，继续请求处理
            return chain.filter(exchange);
        };
    }


    public static class Config {
        private int maxRequests;

        public int getMaxRequests() {
            return maxRequests;
        }

        public void setMaxRequests(int maxRequests) {
            this.maxRequests = maxRequests;
        }
    }


}
