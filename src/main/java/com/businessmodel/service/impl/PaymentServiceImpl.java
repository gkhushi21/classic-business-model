package com.businessmodel.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.businessmodel.dto.AmountDto;
import com.businessmodel.entity.Payment;
import com.businessmodel.mapper.AmountMapper;
import com.businessmodel.repository.CustomerRepo;
import com.businessmodel.repository.PaymentRepo;
import com.businessmodel.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepo prepo;
	@Autowired
	private CustomerRepo crepo;
	

	@Override
	public AmountDto getTotalRevenue() {

		List<Payment> allPayments = prepo.findAll();

		BigDecimal totalRevenue = BigDecimal.ZERO;

		for (Payment payment : allPayments) {
			if (payment.getAmount() != null) {
				totalRevenue = totalRevenue.add(payment.getAmount());
			}
		}

		return AmountMapper.toRevenueDTO(totalRevenue);

	}

	@Override
	public AmountDto getTotalPaymentAmount(Integer customerId) {
		List<Payment> payments = prepo.findByCustomerCustomerNumber(customerId);
		BigDecimal total = BigDecimal.ZERO;

		for (Payment payment : payments) {
			if (payment.getAmount() != null) {
				total = total.add(payment.getAmount());
			}
		}

		return AmountMapper.toCustomerSpendingDto(customerId, total);
	}
}
