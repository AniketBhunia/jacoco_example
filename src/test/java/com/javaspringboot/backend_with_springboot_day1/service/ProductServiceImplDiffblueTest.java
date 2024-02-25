package com.javaspringboot.backend_with_springboot_day1.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.javaspringboot.backend_with_springboot_day1.model.Product;
import com.javaspringboot.backend_with_springboot_day1.repository.ProductRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProductServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ProductServiceImplDiffblueTest {
    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl productServiceImpl;

    /**
     * Method under test: {@link ProductServiceImpl#getAllProducts()}
     */
    @Test
    void testGetAllProducts() {
        // Arrange
        ArrayList<Product> productList = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(productList);

        // Act
        List<Product> actualAllProducts = productServiceImpl.getAllProducts();

        // Assert
        verify(productRepository).findAll();
        assertTrue(actualAllProducts.isEmpty());
        assertSame(productList, actualAllProducts);
    }

    /**
     * Method under test: {@link ProductServiceImpl#AddProduct(Product)}
     */
    @Test
    void testAddProduct() {
        // Arrange
        Product product = new Product();
        product.setBookId(1L);
        product.setBookName("Book Name");
        product.setBookPublishedDate(LocalDate.of(1970, 1, 1));
        product.setProductSupplier("JaneDoe");
        when(productRepository.save(Mockito.<Product>any())).thenReturn(product);

        Product product2 = new Product();
        product2.setBookId(1L);
        product2.setBookName("Book Name");
        product2.setBookPublishedDate(LocalDate.of(1970, 1, 1));
        product2.setProductSupplier("JaneDoe");

        // Act
        productServiceImpl.AddProduct(product2);

        // Assert
        verify(productRepository).save(Mockito.<Product>any());
    }
}
