package com.example.foodcatalogue.dto;

import com.example.foodcatalogue.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
/** This page is the one who will be responsible for showing all the food items, list and restaurant
 *  details on the front end.
 */
public class FoodCataloguePage {
    private List<FoodItem> foodItemList;
    private Restaurant restaurant;
}
