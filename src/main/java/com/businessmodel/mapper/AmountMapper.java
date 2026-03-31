package com.businessmodel.mapper;

import java.math.BigDecimal;

import com.businessmodel.dto.AmountDto;
import com.businessmodel.entity.Customer;
import com.businessmodel.entity.Payment;
import com.businessmodel.entity.PaymentId;

public class AmountMapper {

	public static AmountDto toRevenueDTO(BigDecimal totalAmount) {
		AmountDto dto = new AmountDto();
		dto.setTotalAmount(totalAmount);
		return dto;
	}

	public static AmountDto toCustomerSpendingDto(Integer customerNumber, BigDecimal totalAmount) {
		AmountDto dto = new AmountDto();
		dto.setCustomerNumber(customerNumber);
		dto.setTotalAmount(totalAmount);

		return dto;
	}

	public static Payment toEntity(AmountDto dto) {
		PaymentId paymentId = new PaymentId();
		paymentId.setCustomerNumber(dto.getCustomerNumber());
		paymentId.setCheckNumber(dto.getCheckNumber());

		Payment payment = new Payment();
		payment.setId(paymentId);
		payment.setPaymentDate(dto.getPaymentDate());
		payment.setAmount(dto.getAmount());

		Customer customer = new Customer();
		customer.setCustomerNumber(dto.getCustomerNumber());

		payment.setCustomer(customer);

		return payment;
	}

	public static AmountDto toDTO(Payment payment) {

		AmountDto dto = new AmountDto();

		dto.setCustomerNumber(payment.getId().getCustomerNumber());
		dto.setCheckNumber(payment.getId().getCheckNumber());
		dto.setPaymentDate(payment.getPaymentDate());
		dto.setAmount(payment.getAmount());

		return dto;
	}
}