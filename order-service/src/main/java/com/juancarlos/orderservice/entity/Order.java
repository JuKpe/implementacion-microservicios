package com.juancarlos.orderservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "orders")
@Setter
@Getter
@NoArgsConstructor
public class Order {
    @Id
    private Long id;
    private Long customerId;
    private List<String> items;
    private double totalAmount;
}
