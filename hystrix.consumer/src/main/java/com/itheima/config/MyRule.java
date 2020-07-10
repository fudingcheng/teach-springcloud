package com.itheima.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

// @Configuration
public class MyRule {

    // @Bean
    public IRule rule(){
        return new RandomRule();
    }

}
