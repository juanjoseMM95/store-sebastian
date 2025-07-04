package com.store.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.store.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
