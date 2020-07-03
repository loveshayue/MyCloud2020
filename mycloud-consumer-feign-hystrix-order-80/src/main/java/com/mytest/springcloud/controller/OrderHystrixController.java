package com.mytest.springcloud.controller;

import com.mytest.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderHystrixController {

    /**
     * Hystrix 一般用在消费端做服务降级，也可用在服务端
     */

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentFeignService.paymentInfo_OK(id);
    }

    /**
     * 服务端sleep3S,会报500
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        return paymentFeignService.paymentInfo_TimeOut(id);
    }
}
