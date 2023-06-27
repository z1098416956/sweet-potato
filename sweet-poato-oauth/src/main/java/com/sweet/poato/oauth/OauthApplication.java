package com.sweet.poato.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: TheSunshine
 * @Date: 2022/8/12 17:21
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = {"com.sweet.poato.oauth.feign",
        "com.sweet.poato.oauth"})
@EnableDiscoveryClient
@EnableFeignClients
public class OauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class,args);
    }
}
