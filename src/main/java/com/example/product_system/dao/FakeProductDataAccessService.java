package com.example.product_system.dao;

import com.example.product_system.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakerDao")
public class FakeProductDataAccessService implements ProductDao {

    private static List<Product> DB = new ArrayList<>();

    @Override
    public int insertProduct(UUID id, Product product) {
        DB.add(new Product(id, product.getName()));
        return 1;
    }

    @Override
    public List<Product> getProducts() {
        return DB;
    }


}
