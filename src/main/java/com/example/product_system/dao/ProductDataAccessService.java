package com.example.product_system.dao;

import com.example.product_system.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class ProductDataAccessService implements ProductDao  {

    @Override
    public int insertProduct(UUID id, Product product) {
        return 0;
    }

    @Override
    public List<Product> getProducts() {
        return List.of(new Product(UUID.randomUUID(), "FROM POSTGRES DB"));
    }

    @Override
    public Optional<Product> getProductById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteProductById(UUID id) {
        return 0;
    }

    @Override
    public int updateProductById(UUID id, Product product) {
        return 0;
    }
}
