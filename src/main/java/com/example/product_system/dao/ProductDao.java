package com.example.product_system.dao;

import com.example.product_system.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductDao {

    int insertProduct(UUID id, Product product);

    default int addProduct(Product product) {
        UUID id = UUID.randomUUID();
        return insertProduct(id, product);
    }

    List<Product> getProducts();

    Optional<Product> getProductById(UUID id);

    int deleteProductById(UUID id);

    int updateProductById(UUID id, Product product);
}
