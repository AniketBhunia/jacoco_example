package com.javaspringboot.backend_with_springboot_day1.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.javaspringboot.backend_with_springboot_day1.model.Product;
import com.javaspringboot.backend_with_springboot_day1.repository.ProductRepository;
import com.javaspringboot.backend_with_springboot_day1.service.ProductService;
import com.javaspringboot.backend_with_springboot_day1.service.ProductServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ProductController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ProductControllerDiffblueTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    /**
     * Method under test: {@link ProductController#addProduct(Product)}
     */
    @Test
    void testAddProduct() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        Product product = new Product();
        product.setBookId(1L);
        product.setBookName("Book Name");
        product.setBookPublishedDate(LocalDate.of(1970, 1, 1));
        product.setProductSupplier("JaneDoe");
        ProductRepository productRepository = mock(ProductRepository.class);
        when(productRepository.save(Mockito.<Product>any())).thenReturn(product);
        ProductController productController = new ProductController(new ProductServiceImpl(productRepository));

        Product product2 = new Product();
        product2.setBookId(1L);
        product2.setBookName("Book Name");
        product2.setBookPublishedDate(LocalDate.of(1970, 1, 1));
        product2.setProductSupplier("JaneDoe");

        // Act
        String actualAddProductResult = productController.addProduct(product2);

        // Assert
        verify(productRepository).save(Mockito.<Product>any());
        assertEquals("Product Added Successfully", actualAddProductResult);
    }

    /**
     * Method under test: {@link ProductController#getAllProducts()}
     */
    @Test
    void testGetAllProducts() throws Exception {
        // Arrange
        when(productService.getAllProducts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/Product/");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}
