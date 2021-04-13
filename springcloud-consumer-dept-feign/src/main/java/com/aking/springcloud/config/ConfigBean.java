package com.aking.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author AkingBb
 * @date 2021/4/7 11:37
 */
@Configuration
public class ConfigBean { //@Configuration -- spring applicationContext.xml

    /**
     * 配置负载均衡实现RestTemplate
     * IRule 负载均衡算法接口 自定义算法实现该接口即可
     * eg:
     * RandomRule 随机算法
     * RoundRobinRule 默认轮询算法
     */
    @Bean
    @LoadBalanced //Ribbon
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
