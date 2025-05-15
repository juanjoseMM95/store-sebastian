package com.store.store.service;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.store.store.controller.OrderController;
import com.store.store.model.Product;
import com.store.store.repository.ProductRepository;

@WebMvcTest(OrderController.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void getProductTest(){
        when(productRepository.findAll()).thenReturn(List.of(new Product()));
        List<Product> productos = productService.getProducts();
        assertFalse(productos.isEmpty());
    }
}
