package com.businessmodel.mapper;

import com.businessmodel.dto.OrderDto;
import com.businessmodel.entity.Order;

public class OrderMapper {
    public static OrderDto toOrderDto(Order o) {
        return new OrderDto(o.getOrderNumber(),o.getOrderDate(),o.getRequiredDate(),o.getShippedDate(),o.getStatus(),o.getCustomer().getCustomerName());
    }
}
