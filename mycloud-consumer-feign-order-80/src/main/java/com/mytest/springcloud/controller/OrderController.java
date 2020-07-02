package com.mytest.springcloud.controller;

import com.mytest.springcloud.entity.CommonResult;
import com.mytest.springcloud.entity.Payment;
import com.mytest.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return paymentFeignService.selectOne(id);
    }

}
