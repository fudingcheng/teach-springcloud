package com.itheima.feign;

import com.itheima.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignImpl implements ProductFeignClient{
    @Override
    public Product findById3(Integer id) {
        Product product = new Product();
        product.setName("消费方降级了...");
        return product;
    }
}
