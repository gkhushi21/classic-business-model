package com.businessmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.businessmodel.entity.OrderDetail;
import com.businessmodel.entity.OrderDetailId;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, OrderDetailId> {

}
