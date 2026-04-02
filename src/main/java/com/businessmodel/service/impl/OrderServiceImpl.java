package com.businessmodel.service.impl;

import com.businessmodel.dto.*;
import com.businessmodel.entity.*;
import com.businessmodel.exception.BadRequestException;
import com.businessmodel.exception.ResourceNotFoundException;
import com.businessmodel.mapper.OrderMapper;
import com.businessmodel.repository.*;
import com.businessmodel.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final CustomerRepo customerRepo;
    private final OrderDetailRepo orderDetailRepo;

//    @Override
//    public List<OrderDto> getOrdersByCustomer(Integer customerId) {
//        if(customerId==null){
//            throw new BadRequestException("Customer Id cannot be null");
//        }
//        Customer customer = customerRepo.findById(customerId)
//                .orElseThrow(() -> new ResourceNotFoundException("Customer not find with id: " + customerId));
//        Page<Order> order = orderRepo.findByCustomer(customer, PageRequest.of(0, 10));
//        List<OrderDto> orderDto= new ArrayList<>();
//        order.forEach(o -> orderDto.add(OrderMapper.toOrderDto(o)));
//        return orderDto;
//    }

    @Override
    public Page<OrderDto> getOrdersByStatus(String status, int  page, int size) {
        if (page < 0 || size <= 0) {
            throw new BadRequestException("Invalid pagination parameters");
        }
        if(status==null || status.isBlank()){
            throw new BadRequestException("Status cannot be null or empty");
        }
        Pageable pageable=PageRequest.of(page,size);
        Page<Order> orderPage = orderRepo.findByStatus(status, pageable);
        return orderPage.map(order -> OrderMapper.toOrderDto(order));
    }

    @Override
    public OrderWithDetailsDto getOrderWithDetails(Integer orderId) {
        Order order=orderRepo.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not find with id: " + orderId));
        return OrderMapper.toOrderWithDetailsDto(order);
    }

}