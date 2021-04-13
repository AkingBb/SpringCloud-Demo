package com.aking.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author AkingBb
 * @date 2021/4/13 10:36
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_Dashboard_9001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_Dashboard_9001.class,args);
    }
}
