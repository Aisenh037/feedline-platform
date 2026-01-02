package com.food_app.FeedLine.repository;

import com.food_app.FeedLine.entity.Restuarant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restuarant, String> {

}
