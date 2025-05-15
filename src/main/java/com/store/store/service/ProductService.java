package com.store.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.store.dto.ProductDTO;
import com.store.store.mapper.ProductMapper;
import com.store.store.model.Product;
import com.store.store.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product saveWithoutDTO(Product product){
        return productRepository.save(product);
    }

    public ProductDTO saveProduct(Product product){
        productRepository.save(product);
        return productMapper.toDTO(product);
    }

}
