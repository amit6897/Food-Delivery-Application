package com.example.restaurantlisting.mapper;

import com.example.restaurantlisting.dto.RestaurantDto;
import com.example.restaurantlisting.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestaurantDtoToRestaurant(RestaurantDto restaurantDto);

    RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant);
}
