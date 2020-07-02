package com.mytest.springcloud.controller;

import ch.qos.logback.core.html.IThrowableRenderer;
import com.mytest.springcloud.entity.CommonResult;
import com.mytest.springcloud.entity.Payment;
import com.mytest.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

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
            return new CommonResult(200, "success, serverport" + serverPort, payment);
        } else {
            return new CommonResult(444, "fail, serverport" + serverPort, null);
        }
    }

    @PostMapping(value = "create")
    public CommonResult<Payment> createPayment(@RequestBody Payment payment) {
        int result = this.paymentService.insert(payment);
        log.info("create result :" + result);
        if (result > 0) {
            return new CommonResult(200, "success, serverport" + serverPort, payment);
        } else {
            return new CommonResult(444, "fail, serverport" + serverPort, null);
        }
    }

    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("* * * * * service:" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("MYCLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
}