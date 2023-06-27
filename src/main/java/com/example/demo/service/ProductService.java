package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.util.PageData;

public interface ProductService {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int productId);
    PageData<Product> getProducts(String productName, int page, int pageSize);
    Product getProductById(int productId);

    int selectByName(String name);
}
