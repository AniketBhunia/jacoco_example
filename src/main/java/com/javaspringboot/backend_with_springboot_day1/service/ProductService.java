package com.javaspringboot.backend_with_springboot_day1.service;

import com.javaspringboot.backend_with_springboot_day1.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface ProductService {
    public List<Product> getAllProducts();
    public void AddProduct(Product product);
}
