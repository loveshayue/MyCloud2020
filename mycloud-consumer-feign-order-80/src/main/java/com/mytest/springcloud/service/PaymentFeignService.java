package com.mytest.springcloud.service;

import com.mytest.springcloud.entity.CommonResult;
import com.mytest.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 1.OpenFeign默认只等待1S，超时报错
 * 2.FeignClient好像既可以调controller层，又可以调service层，待后续学习验证
 */
@Component
@FeignClient(value = "MYCLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {


    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id);
}
