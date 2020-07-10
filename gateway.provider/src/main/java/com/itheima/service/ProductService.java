package com.itheima.service;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public Product findById(Integer id){
        return productDao.findById(id);
    }

}
