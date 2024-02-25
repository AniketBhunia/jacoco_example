package com.javaspringboot.backend_with_springboot_day1.service;

import com.javaspringboot.backend_with_springboot_day1.model.Product;
import com.javaspringboot.backend_with_springboot_day1.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void AddProduct(Product product) {
        product.setBookPublishedDate(LocalDate.now());
        productRepository.save(product);
    }

}
