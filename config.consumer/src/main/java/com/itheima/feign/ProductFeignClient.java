package com.itheima.feign;


import com.itheima.config.LogLevel;
import com.itheima.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "CONFIG.PROVIDER", configuration = LogLevel.class, fallback = ProductFeignImpl.class)
public interface ProductFeignClient {

    @RequestMapping("/product/findById/{id}")
    public Product findById3(@PathVariable("id") Integer id);

}
