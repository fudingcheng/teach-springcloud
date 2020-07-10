package com.itheima.controller;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Value("${server.port}")
    private int port;

    @RequestMapping("/findById/{id}")
    @HystrixCommand(fallbackMethod = "hystrixMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public Product findById(@PathVariable("id") Integer id) {

        //如果id=1,触发异常
        if(id==-1){
            int r = 1/0;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Product product = productService.findById(id);
        product.setId(port);
        return product;
    }

    public Product hystrixMethod(Integer id){
        Product  product  = new Product();
        product.setName("服务提供方降级...");
        return product;
    }

}
