package com.foodhub.foodhub_backend.dao;

import com.foodhub.foodhub_backend.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDao extends JpaRepository<Restaurant, Integer> {
}
