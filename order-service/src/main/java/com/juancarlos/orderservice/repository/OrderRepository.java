package com.juancarlos.orderservice.repository;

import com.juancarlos.orderservice.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, Long> {
    List<Order> findByCustomerId(Long customerId);

}
