package com.javaspringboot.backend_with_springboot_day1.controller;

import com.javaspringboot.backend_with_springboot_day1.model.Product;
import com.javaspringboot.backend_with_springboot_day1.service.ProductService;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product){
        productService.AddProduct(product);
        return "Product Added Successfully";
    }
    @GetMapping("/")
    public List<Product>getAllProducts(){
        return productService.getAllProducts();
    }

}
