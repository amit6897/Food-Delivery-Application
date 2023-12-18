package com.example.orderservice.entity;

import com.example.orderservice.dto.FoodItemDto;
import com.example.orderservice.dto.Restaurant;
import com.example.orderservice.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer orderId;
    private List<FoodItemDto> foodItemList;
    private Restaurant restaurant;
    private UserDto userDto;
}