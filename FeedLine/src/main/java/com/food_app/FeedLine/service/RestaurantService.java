package com.food_app.FeedLine.service;

import com.food_app.FeedLine.dto.RestaurantDTO;
import com.food_app.FeedLine.entity.Restuarant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RestaurantService {
    Restuarant addRestuarant(Restuarant restuarant);

    public RestaurantDTO addRestuarant(RestaurantDTO restaurantDTO);

    public Page<RestaurantDTO> getAllRestaurants(Pageable pageable);
    public RestaurantDTO getRestaurantById(String id);
    public List<RestaurantDTO> searchRestaurantByName(String name);

    //Extra Functions
    Page<RestaurantDTO> getOpenRestaurants(Pageable pageable);

    public RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO, String id);

    public void deleteRestaurant(String id);
}
