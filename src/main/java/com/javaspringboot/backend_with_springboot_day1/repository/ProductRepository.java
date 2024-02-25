package com.javaspringboot.backend_with_springboot_day1.repository;

import com.javaspringboot.backend_with_springboot_day1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
