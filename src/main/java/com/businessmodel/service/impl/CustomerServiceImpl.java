package com.businessmodel.service.impl;

import com.businessmodel.dto.*;
import com.businessmodel.entity.Customer;
import com.businessmodel.entity.Employee;
import com.businessmodel.entity.Order;
import com.businessmodel.exception.BadRequestException;
import com.businessmodel.exception.BusinessException;
import com.businessmodel.exception.ResourceNotFoundException;
import com.businessmodel.mapper.CustomerMapper;
import com.businessmodel.mapper.OrderMapper;
import com.businessmodel.mapper.SupportMapper;
//import com.businessmodel.mapper.CustomerEntityMapper;
//import com.businessmodel.mapper.OrderEntityMapper;
import com.businessmodel.repository.CustomerRepo;
import com.businessmodel.repository.OrderRepo;
import com.businessmodel.repository.PaymentRepo;
import com.businessmodel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private PaymentRepo paymentRepo;

    @Override
    public Page<CustomerDto> getCustomersByCountry(String country, int page, int size) {
        if (country == null || country.isBlank()) {
            throw new BadRequestException("Country cannot be empty");
        }
        if (page < 0 || size <= 0) {
            throw new BadRequestException("Invalid pagination parameters");
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<Customer> customerPage = customerRepo.findByCountry(country, pageable);
        return customerPage.map(CustomerMapper::toCustomerDto);
    }

    @Override
    public List<CustomerDto> getTopCustomers(int page, int size) {
        if (page < 0 || size <= 0) {
            throw new BadRequestException("Invalid pagination parameters");
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<Customer> customerPage = customerRepo.findAllByOrderByCreditLimitDesc(pageable);
        List<CustomerDto> list=new ArrayList<>();
        for(Customer c:customerPage.getContent()) {
            list.add(CustomerMapper.toCustomerDto(c));
        }
        return list;
    }

    @Override
    public Page<OrderDto> getOrdersByCustomer(Integer customerId, int page, int size) {
        if (page < 0 || size <= 0) {
            throw new BadRequestException("Invalid pagination parameters");
        }
        Customer customer= customerRepo.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + customerId + " not found"));
        Pageable pageable = PageRequest.of(page, size);
        Page<Order> orderPage=orderRepo.findByCustomer(customer,pageable);
        return orderPage.map(order ->  OrderMapper.toOrderDto(order));
    }

    @Override
    public List<OrderDto> getOrdersByCustomerIdAndStatus(Integer customerId, String status) {
        Customer customer= customerRepo.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + customerId + " not found"));
        List<Order> orders = orderRepo.findByCustomer_CustomerNumberAndStatus(customerId, status);
        List<OrderDto> orderDto = new ArrayList<>();
        orders.forEach(o -> orderDto.add(OrderMapper.toOrderDto(o)));
        return orderDto;
    }

    @Override
    public SupportDto getCustomerSupport(Integer customerId) {
        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + customerId + " not found"));
        Employee emp = customer.getSalesRep();
        if(emp == null) {
            throw new BusinessException("No support assigned to this customer");
        }
        return SupportMapper.toSupportDto(emp);
    }

}