package com.example.demo.service.impl;


import com.example.demo.dao.ProductDAO;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import com.example.demo.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDAO productDAO;

    @Override
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(int productId) {
        productDAO.deleteProduct(productId);
    }

    @Override
    public PageData<Product> getProducts(String productName, int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        List<Product> products = productDAO.getProducts(productName, offset, pageSize);
        int total = productDAO.getTotalProducts(productName);

        return new PageData<>(page,pageSize,total,products);
    }

    @Override
    public Product getProductById(int productId) {
        return productDAO.getProductById(productId);
    }

    @Override
    public int selectByName(String name) {
        return productDAO.selectByName(name);
    }
}
