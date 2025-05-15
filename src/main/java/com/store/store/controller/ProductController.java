package com.store.store.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.store.dto.ProductDTO;
import com.store.store.model.Product;
import com.store.store.service.ProductService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor()
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
    List<Product> products = productService.getProducts();
    return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createNewProduct(@RequestBody Product product) {
            Product newProduct = productService.saveWithoutDTO(product);
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PostMapping("/withDTO")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {
        ProductDTO newProductDTO = productService.saveProduct(product);
        return new ResponseEntity<>(newProductDTO, HttpStatus.CREATED);
    }
    
}
