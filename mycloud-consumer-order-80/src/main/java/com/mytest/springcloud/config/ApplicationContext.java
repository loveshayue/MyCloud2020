package com.mytest.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContext {

    @Bean
    @LoadBalanced //不添加会报未知主机异常
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
