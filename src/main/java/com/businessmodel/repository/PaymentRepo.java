package com.businessmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.businessmodel.entity.Payment;
import com.businessmodel.entity.PaymentId;

public interface PaymentRepo  extends JpaRepository<Payment, PaymentId> {

}
