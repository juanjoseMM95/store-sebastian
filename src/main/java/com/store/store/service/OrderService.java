package com.store.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.store.dto.OrderDTO;
import com.store.store.mapper.OrderMapper;
import com.store.store.model.Order;
import com.store.store.repository.OrderRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderDTO> getOrders(){
        List<Order> orders = orderRepository.findAll();
        return orderMapper.orderToOrderDTOs(orders);
    }

    public OrderDTO saveOrder(OrderDTO orderDTO){
        Order newOrder = orderMapper.orderDTOtoOrder(orderDTO);
        orderRepository.save(newOrder);
        return orderMapper.orderToOrderDTO(newOrder);
    }
}
