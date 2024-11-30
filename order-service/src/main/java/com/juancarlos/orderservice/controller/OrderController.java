package com.juancarlos.orderservice.controller;

import com.juancarlos.orderservice.client.CustomerClient;
import com.juancarlos.orderservice.dto.CustomerDTO;
import com.juancarlos.orderservice.entity.Order;
import com.juancarlos.orderservice.repository.OrderRepository;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orse")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerClient customerClient;


    @PostMapping(value = "orders")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
            orderRepository.save(order);
            return ResponseEntity.ok("Order created successfully.");
    }

    @GetMapping(value = "orders")
    public List<Order> listOrders() {
        return orderRepository.findAll();
    }

    @GetMapping(value = "orders/customer/{customerId}")
    public List<Order> listOrdersByCustomerId(@PathVariable("customerId") Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @PostMapping(value = "guardar")
    @CircuitBreaker(name = "customer-service", fallbackMethod = "fallbackMethod")
    public ResponseEntity<String> createOrderValidated(@RequestBody Order order) {

        try {
            // Validate the existence of the customer before creating an order.
            CustomerDTO customer = customerClient.validateOrder(order.getCustomerId());
            orderRepository.save(order);
            return ResponseEntity.ok("Order created successfully.");
        } catch (FeignException.NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found.");
        }
    }

    // Method fallback
    public String fallbackMethod(Throwable throwable) {
        return "Servicio no disponible temporalmente. Intentelo más tarde";
    }

}
