package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.dto.OrderDtoFromFE;

public interface OrderService {
    public OrderDto saveOrderInDb(OrderDtoFromFE orderDetails);
}
