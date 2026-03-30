package com.businessmodel.service;

import com.businessmodel.dto.AmountDto;
import com.businessmodel.dto.CustomerDto;
import com.businessmodel.dto.OrderDto;
import com.businessmodel.dto.SupportDto;

import java.util.List;

public interface CustomerService {
    public List<CustomerDto> getCustomersByCountry(String country);
    public List<CustomerDto> getTopCustomers();
    public List<OrderDto> getOrdersByCustomer(Integer customerId);
    public List<OrderDto> getOrdersByCustomerIdAndStatus(Integer customerId, String status);
    public AmountDto getTotalPaymentAmount(Integer customerId);
    public SupportDto getCustomerSupport(Integer customerId);
}
