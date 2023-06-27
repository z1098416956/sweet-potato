package com.sweet.poato.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/6/27 10:15
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ImApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImApplication.class,args);
    }
}
