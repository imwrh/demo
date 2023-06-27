package com.example.demo.dao;



import com.example.demo.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductDAO {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int productId);
    List<Product> getProducts(@Param("productName") String productName,@Param("page") int page,@Param("pageSize") int pageSize);


    int getTotalProducts(String productName);
    Product getProductById(int productId);

    int selectByName(String name);
}
