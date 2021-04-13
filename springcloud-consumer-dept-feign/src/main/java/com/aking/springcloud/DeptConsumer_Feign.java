package com.aking.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author AkingBb
 * @date 2021/4/7 11:53
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.aking.springcloud"})
@ComponentScan("com.aking.springcloud")
public class DeptConsumer_Feign {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_Feign.class,args);
    }
}
