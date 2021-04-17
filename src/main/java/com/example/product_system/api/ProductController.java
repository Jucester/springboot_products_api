package com.example.product_system.api;

import com.example.product_system.model.Product;
import com.example.product_system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/product")
@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(path = "{id}")
    public Product getProductById(@PathVariable("id") UUID id) {
        return productService.getProductById(id)
                             .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public int deleteProduct(@PathVariable("id") UUID id) {
        return productService.deleteProduct(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }
}
