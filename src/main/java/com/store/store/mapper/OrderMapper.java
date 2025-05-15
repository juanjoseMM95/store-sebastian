package com.store.store.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.store.store.dto.OrderDTO;
import com.store.store.dto.ProductDTO;
import com.store.store.model.Order;
import com.store.store.model.Product;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    //para poder convertir una order a order DTO
    //se debe convertir la lista de products de order a la lista de
    //products de orderDTO, que sería la segunda conversión que se hace, acto seguido
    //se debe convertir product a productDTO, para que la lista de la segunda conversión
    //quede bien. en los comentarios de abajo queda los métodos explícitos.

    @Mapping(source = "products", target="products")
    OrderDTO orderToOrderDTO(Order order); //Order -> OrderDTO

    List<ProductDTO> productsToProductDTOs(List<Product> products);

    @Mapping(source = "category.categoryName", target = "categoryName")
    ProductDTO productToProductDTO(Product product);

    List<OrderDTO> orderToOrderDTOs(List<Order> orders);

    @InheritInverseConfiguration
    Order orderDTOtoOrder(OrderDTO orderDTO);
}

// @Component




// public class OrderMapperImpl implements OrderMapper {

//     @Override
//     public OrderDTO orderToOrderDTO(Order order) {
//         if (order == null) {
//             return null;
//         }

//         OrderDTO dto = new OrderDTO();
//         dto.setId(order.getId());
//         dto.setClientId(order.getClientId());
//         dto.setProducts(productsToProductDTOs(order.getProducts()));

//         return dto;
//     }

//     @Override
//     public ProductDTO productToProductDTO(Product product) {
//         if (product == null) {
//             return null;
//         }

//         ProductDTO dto = new ProductDTO();
//         dto.setId(product.getId());
//         dto.setName(product.getName());
//         dto.setValue(product.getValue());
//         dto.setCategoryName(product.getCategory() != null ? product.getCategory().getCategoryName() : null);

//         return dto;
//     }

//     @Override
//     public List<ProductDTO> productsToProductDTOs(List<Product> products) {
//         if (products == null) {
//             return null;
//         }

//         List<ProductDTO> dtoList = new ArrayList<>();
//         for (Product product : products) {
//             dtoList.add(productToProductDTO(product));
//         }

//         return dtoList;
//     }

//     @Override
//     public List<OrderDTO> orderToOrderDTOs(List<Order> orders) {
//         if (orders == null) {
//             return null;
//         }

//         List<OrderDTO> dtoList = new ArrayList<>();
//         for (Order order : orders) {
//             dtoList.add(orderToOrderDTO(order));
//         }

//         return dtoList;
//     }

//     @Override
//     public Order orderDTOtoOrder(OrderDTO dto) {
//         if (dto == null) {
//             return null;
//         }

//         Order order = new Order();
//         order.setId(dto.getId());
//         order.setClientId(dto.getClientId());
//         // Aquí se esperaría tener un método para convertir DTOs a entidades
//         // order.setProducts(productDTOsToProducts(dto.getProducts())); 
//         return order;
//     }
// }
