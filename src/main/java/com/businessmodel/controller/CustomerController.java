package com.businessmodel.controller;

import com.businessmodel.dto.OrderDto;
import com.businessmodel.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import com.businessmodel.dto.CustomerDto;
import com.businessmodel.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    private final OrderService orderService;

    @GetMapping
    public Page<CustomerDto> getCustomersByCountry(
            @RequestParam String country,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return customerService.getCustomersByCountry(country, page, size);
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<?> getOrdersByCustomer(
            @PathVariable Integer id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        try {
            Page<OrderDto> orders = orderService.getOrdersByCustomer(id, page, size);

            if (orders.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No orders found for customer id: " + id);
            }

            return ResponseEntity.ok(orders);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }


}


