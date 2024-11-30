package com.juancarlos.customerservice.controller;

import com.juancarlos.customerservice.customisedException.CustomerNotFoundException;
import com.juancarlos.customerservice.entity.Customer;
import com.juancarlos.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuse")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(value = "customers")
    public void createCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }

    @GetMapping(value = "customers")
    public List<Customer> listCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping(value = "customers/{id}")
    public Customer getCustomers(@PathVariable("id") Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + id + " not found"));
    }

    //Get a customer by id to create an order
    @GetMapping(value = "customers/orden/{id}")
    public Customer validateOrder(@PathVariable("id") Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + id + " not found"));
    }

}

/*
NOTE: if access to the routes does not work even if they are OK, do a clear and install in maven.
 */


