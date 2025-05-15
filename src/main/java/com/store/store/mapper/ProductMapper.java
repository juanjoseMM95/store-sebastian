package com.store.store.mapper;

import org.springframework.stereotype.Component;

import com.store.store.dto.ProductDTO;
import com.store.store.model.Product;

@Component
public class ProductMapper {
    //Metodo que reciba obj product y lo transforme a DTO

    public ProductDTO toDTO(Product product){
        if(product == null){
            return null;
        }
        String categoryName = product.getCategory() != null ? product.getCategory().getCategoryName() : null;

        return new ProductDTO(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getDescription(),
            categoryName
        );
    }
}
