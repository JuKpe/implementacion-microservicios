package com.juancarlos.customerservice.repository;

import com.juancarlos.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
