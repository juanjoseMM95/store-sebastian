package com.store.store.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.store.store.dto.OrderDTO;
import com.store.store.service.OrderService;

public class OrderControllerTest {

    @Mock
    OrderService orderService;  //doble de prueba

    //Sujeto de prueba  //A quien se le hace la prueba
    @InjectMocks
    OrderController orderController;

    @BeforeEach
    public void setup(){  //se ejecuta antes de ejecutar cualquier metodo de prueba
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void TestReturningOrders(){
        //Arrange (Arreglar)
        when(orderService.getOrders()).thenReturn(List.of(new OrderDTO(1l,"Order DTO 1",null)));
        ResponseEntity<List<OrderDTO>> responseEntity = orderController.getOrders();
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }

    
}


// public class OrderControllerTest {

//     //Doble de prueba
//     @org.mockito.Mock
//     OrderService orderService;

//     @org.mockito.InjectMocks
//     OrderController orderController;

//     @org.junit.jupiter.api.BeforeEach
//     public void setup() {
//        org.mockito.MockitoAnnotations.openMocks(this);
//     }

//     @org.junit.jupiter.api.Test
//     public void testReturningOrders() {
//        when(orderService.getOrders())
//              .thenReturn(java.util.List.of(new com.example.store.dto.OrderDTO(1l, "Order DTO 1", null)));
//        org.springframework.http.ResponseEntity<java.util.List<com.example.store.dto.OrderDTO>> responseEntity = orderController.getOrders();
//        assertEquals(org.springframework.http.HttpStatus.OK, responseEntity.getStatusCode());
//     }
// }
