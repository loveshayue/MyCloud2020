package com.mytest.springcloud.controller;

import com.mytest.springcloud.entity.CommonResult;
import com.mytest.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    public static final String URL = "http://localhost:8001";
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> createPayment(Payment payment) {
        return restTemplate.postForObject(URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> createPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(URL + "/payment/get/" + id, CommonResult.class);
    }
}
