package com.businessmodel.repository;

import com.businessmodel.entity.OrderDetail;
import com.businessmodel.entity.OrderDetailId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail, OrderDetailId> {
    List<OrderDetail> findByOrder_OrderNumber(int orderNumber);
}