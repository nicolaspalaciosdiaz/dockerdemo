package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(int theId);

    Product save(Product theProduct);

    String deleteById(int theId);
}
