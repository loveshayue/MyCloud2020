package com.mytest.springcloud.controller;

import com.mytest.springcloud.entity.CommonResult;
import com.mytest.springcloud.entity.Payment;
import com.mytest.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Payment)表控制层
 *
 * @author liyn
 * @since 2020-06-30 15:06:35
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    /**
     * 服务对象
     */
    @Resource
    private PaymentService paymentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id) {
        Payment payment = this.paymentService.queryById(id);
        log.info("search result :" + payment);
        if (payment != null) {
            return new CommonResult(200, "success", payment);
        } else {
            return new CommonResult(444, "fail", null);
        }
    }

    @PostMapping(value = "create")
    public CommonResult<Payment> createPayment(@RequestBody Payment payment) {
        int result = this.paymentService.insert(payment);
        log.info("create result :" + result);
        if (result > 0) {
            return new CommonResult(200, "success", payment);
        } else {
            return new CommonResult(444, "fail", null);
        }
    }
}