package com.aking.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author AkingBb
 * @date 2021/4/13 14:13
 */
@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527 {
    public static void main(String[] args) {
        SpringApplication.run(Zuul_9527.class,args);
    }
}
