package com.aking.springcloud;

import com.aking.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author AkingBb
 * @date 2021/4/7 11:53
 */
@SpringBootApplication
@EnableEurekaClient
/**
 * 在服务启动时去加载我们自定义的Ribbon负责均衡算法类
 */
@RibbonClient(name = "SPRING-CLOUD-PROVIDER-DEPT",configuration = MyRule.class)
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class,args);
    }
}
