package com.sweet.poato.gateway.config;

import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/6/19 17:26
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    @Bean
    public GatewayFilterFactory<RateLimitFilter.Config> rateLimitFilterFactory(RedisTemplate<String, Object> redisTemplate) {
        return new RateLimitFilter(redisTemplate);
    }
}
