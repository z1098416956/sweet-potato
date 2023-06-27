package com.sweet.poato.network;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: TheSunshine
 * @Date: 2022/8/6 18:05
 * @Version 1.0
 */
@SpringBootApplication( )
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.sweet.poato.network.dao")
public class NetworkApplication {

    public static void main(String[] args) {

        SpringApplication.run(NetworkApplication.class,args);
    }

    @Bean
    @LoadBalanced  // 微服务名替换为具体的ip:port
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
