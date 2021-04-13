package com.aking.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author AkingBb
 * @date 2021/4/12 14:27
 */
@Configuration
public class MyRule {
    @Bean
    public IRule akingRule(){
        return new RandomRule();
    }
}
