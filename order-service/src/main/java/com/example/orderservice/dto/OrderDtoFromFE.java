package com.example.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDtoFromFE {
    private List<FoodItemDto> foodItemsList;
    private Integer userId;
    private Restaurant restaurant;
}
