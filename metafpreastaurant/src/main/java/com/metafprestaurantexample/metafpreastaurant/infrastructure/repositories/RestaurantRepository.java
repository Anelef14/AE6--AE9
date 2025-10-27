package com.metafprestaurantexample.metafpreastaurant.infrastructure.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metafprestaurantexample.metafpreastaurant.domain.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository <Restaurant, UUID>{
    Optional<Restaurant> findByResId(UUID resId);
}
