package com.juancarlos.orderservice.client;

import com.juancarlos.orderservice.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "customer-service")
public interface CustomerClient {

    @GetMapping(value = "/cuse/customers/orden/{id}")
    CustomerDTO validateOrder(@PathVariable("id") Long id);

}
