package com.metafprestaurantexample.metafpreastaurant.infrastructure.repositories;

import com.metafprestaurantexample.metafpreastaurant.entity.Restaurant;
import com.metafprestaurantexample.metafpreastaurant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository <User, UUID>{
    Optional<User> findByUserId(UUID userId);
}
