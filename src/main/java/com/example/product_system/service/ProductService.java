package com.example.product_system.service;

import com.example.product_system.dao.ProductDao;
import com.example.product_system.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductService(@Qualifier("fakerDao") ProductDao productDao) {
        this.productDao = productDao;
    }

    public int addProduct(Product product) {
        return productDao.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return productDao.getProducts();
    }
}
