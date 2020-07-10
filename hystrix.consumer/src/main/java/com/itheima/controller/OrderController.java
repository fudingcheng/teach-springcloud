package com.itheima.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itheima.domain.Product;
import com.itheima.feign.ProductFeignClient;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/findById/{id}")
    public Product findById(@PathVariable("id") Integer id) {

        List<ServiceInstance> instances = discoveryClient.getInstances("FEIGN.PROVIDER");
        String uri = null;
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost() + ":" + instance.getPort());
            uri = instance.getUri().toString();
        }

        //return restTemplate.getForObject("http://127.0.0.1:8080/product/findById/1", Product.class);
        return restTemplate.getForObject(uri + "/product/findById/1", Product.class);
    }

    @RequestMapping("/findById2/{id}")
    public Product findById2(@PathVariable("id") Integer id) {

        return restTemplate.getForObject("http://FEIGN.PROVIDER/product/findById/1", Product.class);
    }


    @Autowired
    private ProductFeignClient productFeignClient;

    @RequestMapping("/findById3/{id}")
    public Product findById3(@PathVariable("id") Integer id) {

        return productFeignClient.findById3(id);
    }


    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
