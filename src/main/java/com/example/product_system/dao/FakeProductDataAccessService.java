package com.example.product_system.dao;

import com.example.product_system.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Override
    public Optional<Product> getProductById(UUID id) {
        return DB.stream()
                 .filter(product -> product.getId().equals(id))
                 .findFirst();
    }

    @Override
    public int deleteProductById(UUID id) {
        Optional<Product> productFound = getProductById(id);
        if (!productFound.isPresent()) {
            return 0;
        } else {
            DB.remove(productFound.get());
            return 1;
        }
    }

    @Override
    public int updateProductById(UUID id, Product newProduct) {
        return getProductById(id).map(product -> {
            int indexOfProduct = DB.indexOf(product);
            if (indexOfProduct >= 0) {
                DB.set(indexOfProduct, new Product(id, newProduct.getName()));
                return 1;
            }
            return 0;
        })
        .orElse(0);
    }


}
