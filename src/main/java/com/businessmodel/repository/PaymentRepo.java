
package com.businessmodel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.businessmodel.entity.Payment;
import com.businessmodel.entity.PaymentId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo  extends JpaRepository<Payment, PaymentId> {
    @Query("select sum(p.amount) from Payment p where p.customer.customerNumber=:customerId")
    Double sumPaymentByCustomer(@Param("customerId") Integer customerId);
    
    List<Payment> findByCustomerCustomerNumber(Integer customerNumber);

	
   }
