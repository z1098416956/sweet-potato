package com.sweet.poato.merchandise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: TheSunshine
 * @Date: 2022/8/6 18:05
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = {"com.sweet.poato.merchandise","sweet.poato.feign"})
@EnableDiscoveryClient
@EnableFeignClients
public class MerchandiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MerchandiseApplication.class,args);
    }

    @Bean
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }
}
