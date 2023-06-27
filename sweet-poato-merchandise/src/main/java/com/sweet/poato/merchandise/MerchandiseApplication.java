package com.sweet.poato.merchandise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: TheSunshine
 * @Date: 2022/8/6 18:05
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = {"sweet.poato.handler"
        ,"com.sweet.poato.merchandise"
        ,"sweet.poato.feign"
         })
@EnableFeignClients
public class MerchandiseApplication {

    public static void main(String[] args) {

        SpringApplication.run(MerchandiseApplication.class,args);
    }

    @Bean
    @LoadBalanced  // 微服务名替换为具体的ip:port
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
