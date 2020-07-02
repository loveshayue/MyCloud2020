package com.mytest.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * IRule 需配置在非@ComponentScan 包下
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule(); //定义为随机 ，得学习下@Bean
    }


    /**
     * P42，Ribbon手写轮询算法，暂时未看，因需要了解cas的相关知识
     */
}
