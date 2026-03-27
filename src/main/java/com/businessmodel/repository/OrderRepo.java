package com.businessmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.businessmodel.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
