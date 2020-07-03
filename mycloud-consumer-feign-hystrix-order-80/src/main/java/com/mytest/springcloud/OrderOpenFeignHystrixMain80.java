package com.mytest.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableEurekaClient
@EnableFeignClients //没有这个注解service会报错
@SpringBootApplication
public class OrderOpenFeignHystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignHystrixMain80.class, args);
    }
}
