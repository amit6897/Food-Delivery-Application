package com.example.foodcatalogue.service;

import com.example.foodcatalogue.dto.FoodCataloguePage;
import com.example.foodcatalogue.dto.FoodItemDto;

public interface FoodCatalogueService {
    FoodItemDto addFoodItem(FoodItemDto foodItemDto);

    FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId);
}
