package com.businessmodel.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import com.businessmodel.dto.CustomerDto;
import com.businessmodel.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @GetMapping
    public Page<CustomerDto> getCustomersByCountry(
            @RequestParam String country,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return customerService.getCustomersByCountry(country, page, size);
    }
}