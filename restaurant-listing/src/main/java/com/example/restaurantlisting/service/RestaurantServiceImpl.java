package com.example.restaurantlisting.service;

import com.example.restaurantlisting.dto.RestaurantDto;
import com.example.restaurantlisting.entity.Restaurant;
import com.example.restaurantlisting.mapper.RestaurantMapper;
import com.example.restaurantlisting.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepo restaurantRepo;

    @Override
    public List<RestaurantDto> findAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepo.findAll();
        List<RestaurantDto> restaurantDtoList = restaurants.stream().map(
                RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDto
        ).toList();
        /**
         * List<RestaurantDto> restaurantDtoList = restaurants.stream().map(
         *      restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant)
         * ).collect(Collectors.toList());
         */
        return restaurantDtoList;
    }

    @Override
    public RestaurantDto addRestaurantInDB(RestaurantDto restaurantDto) {
        Restaurant savedRestaurant = restaurantRepo.save
                (RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantDto));
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(savedRestaurant);
    }

    @Override
    public ResponseEntity<RestaurantDto> fetchRestaurantById(Integer id) {
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
        return restaurant.map(value -> new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(
                value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
        /**
         * if(restaurant.isPresent()) {
         *      return new ResponseEntity<>(RestaurantMapper.INSTANCE
         *          .mapRestaurantToRestaurantDto(restaurant.get()), HttpStatus.OK);
         * }
         * return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
         */
    }
}
