package com.businessmodel.service.impl;

import com.businessmodel.dto.*;
import com.businessmodel.mapper.CustomerMapper;
import com.businessmodel.mapper.OrderMapper;
import com.businessmodel.entity.Customer;
import com.businessmodel.entity.Employee;
import com.businessmodel.entity.Order;
import com.businessmodel.repository.CustomerRepo;
import com.businessmodel.repository.OrderRepo;
import com.businessmodel.repository.PaymentRepo;
import com.businessmodel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        Pageable pageable = PageRequest.of(page, size);
        Page<Customer> customerPage =
                customerRepo.findByCountry(country, pageable);
        return customerPage.map(CustomerMapper::toCustomerDto);
    }

	@Override
	public List<CustomerDto> getTopCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDto> getOrdersByCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDto> getOrdersByCustomerIdAndStatus(Integer customerId, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AmountDto getTotalPaymentAmount(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupportDto getCustomerSupport(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

   /* @Override
    public List<CustomerDto> getTopCustomers() {
        List<Customer> customer=customerRepo.findTop10ByOrderByCreditLimitDesc();
        List<CustomerDto> customerDto=new ArrayList<>();
        customer.forEach(c->customerDto.add(CustomerMapper.toCustomerDto(c)));
        return customerDto;
    }

    @Override
    public List<OrderDto> getOrdersByCustomer(Integer customerId) {
        List<Order> orders=orderRepo.findByCustomerCustomerNumber(customerId);
        List<OrderDto> orderDto=new ArrayList<>();
        orders.forEach(o-> OrderMapper.toOrderDto(o));
        return orderDto;
    }

    @Override
    public List<OrderDto> getOrdersByCustomerIdAndStatus(Integer customerId, String status) {
        List<Order> orders=orderRepo.findByCustomerCustomerNumberAndStatus(customerId, status);
        List<OrderDto> orderDto=new ArrayList<>();
        orders.forEach(o-> OrderMapper.toOrderDto(o));
        return orderDto;
    }

    @Override
    public AmountDto getTotalPaymentAmount(Integer customerId) {
        Double total=paymentRepo.sumPaymentByCustomer(customerId);
        return AmountEntityMapper.toAmountDto(total);
    }

    @Override
    public SupportDto getCustomerSupport(Integer customerId) {
        Customer customer=customerRepo.findById(customerId).get();
        Employee emp=customer.getSalesRep();
        return SupportEntityMapper.toSupportDto(emp);
    } */
}


