package com.itheima.dao;


import com.itheima.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

    public Product findById(Integer id) {
        return new Product(1, "苹果手机", 5000.00);
    }

}
