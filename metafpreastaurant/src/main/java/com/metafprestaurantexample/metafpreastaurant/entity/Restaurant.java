package com.metafprestaurantexample.metafpreastaurant.entity;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "restaurant", schema = "restaurants" )
public class Restaurant {
    @Id
    @Column(name = "res_id")
    private UUID resId;

    @NotBlank(message = "Restaurant name is required")
    @Column(nullable = false )
    private String name;

    @NotNull(message = "Capacity is required")
    @Min(value = 1, message = "Capacity has to be at least one")
    @Column(nullable = false )
    private int capacity;

    @NotNull(message = "Food type is required")
    @Column(name = "food_type", nullable = false)
    private String foodType;

    @Column(nullable = false)
    private int currentDiner=0;

    public Restaurant (){}

    public Restaurant (String name , int capacity, String foodType, int currentDiner){
        this.resId = UUID.randomUUID();
        this.name = name;
        this.capacity = capacity;
        this.foodType = foodType;
        this.currentDiner = currentDiner;
    }

public int getCapacity() {
    return capacity;
}

public void setCapacity(int capacity) {
    this.capacity = capacity;
}

public String getFoodType() {
    return foodType;
}

public void setFoodType(String foodType){
    this.foodType = foodType;
}

public String getName() {
    return name;
}

@JsonProperty(access = JsonProperty.Access.READ_ONLY)
public UUID getResId() {
    return resId;
}

public void setResId(UUID resId) {
    this.resId = resId;
}

public void setName(String name) {
    this.name = name;
}

    public int getCurrentDiner() {
        return currentDiner;
    }

    public void setCurrentDiner(int currentDiner) {
        this.currentDiner = currentDiner;
    }
}
