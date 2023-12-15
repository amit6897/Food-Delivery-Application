package com.example.restaurantlisting.service;

import com.example.restaurantlisting.dto.RestaurantDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RestaurantService {
    public List<RestaurantDto> findAllRestaurants();

    public RestaurantDto addRestaurantInDB(RestaurantDto restaurantDto);

    public ResponseEntity<RestaurantDto> fetchRestaurantById(Integer id);
}
