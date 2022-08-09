package com.sweet.poato.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: TheSunshine
 * @Date: 2022/8/8 17:07
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = {"com.sweet.poato.web"})
@EnableDiscoveryClient
@EnableFeignClients
public class ControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControllerApplication.class,args);
    }


    @Bean
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }
}
