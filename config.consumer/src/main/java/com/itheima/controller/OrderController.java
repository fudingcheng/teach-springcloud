package com.itheima.controller;


import com.itheima.domain.Product;
import com.itheima.feign.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {

    @Value("${config}")
    private String config;



    @Autowired
    private ProductFeignClient productFeignClient;

    @RequestMapping("/findById3/{id}")
    public Product findById3(@PathVariable("id") Integer id) {
        System.out.println(config);
        return productFeignClient.findById3(id);
    }


}
