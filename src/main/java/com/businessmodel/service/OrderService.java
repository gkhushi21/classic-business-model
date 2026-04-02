package com.businessmodel.service;

import com.businessmodel.dto.OrderDto;
import com.businessmodel.dto.OrderWithDetailsDto;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    Page<OrderDto> getOrdersByStatus(String status, int page, int size);
    //    List<OrderDto> getOrdersByCustomerId(Integer customerId);
    OrderWithDetailsDto getOrderWithDetails(Integer orderId);
//    List<OrderDto> getOrdersByCustomer(Integer customerId);
}