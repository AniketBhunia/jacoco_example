package com.javaspringboot.backend_with_springboot_day1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;
    private String productName;
    private String productSupplier;
    private LocalDate productPublishedDate;

    public void setBookId(long bookId) {
        this.productId = bookId;
    }

    public void setBookName(String bookName) {
        this.productName = bookName;
    }

    public void setProductSupplier(String bookAuthor) {
        this.productSupplier = bookAuthor;
    }

    public void setBookPublishedDate(LocalDate date) {
        this.productPublishedDate = date;
    }
}
