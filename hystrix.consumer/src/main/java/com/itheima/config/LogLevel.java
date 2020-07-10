package com.itheima.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogLevel {


    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
