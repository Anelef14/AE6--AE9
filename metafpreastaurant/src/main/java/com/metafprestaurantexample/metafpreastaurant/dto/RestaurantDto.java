package com.metafprestaurantexample.metafpreastaurant.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class RestaurantDto {
    private UUID id;
    @NotBlank(message = "Restaurant Name is required")
    private String name;
    @NotNull(message = "Capacity is required")
    @Min(value = 1, message = "Capacity has to be at least one")
    private Integer capacity;
    @NotBlank(message = "Food type is required")
    private String foodType;
    private Integer currentDiners;

    public RestaurantDto(UUID id, String name, Integer capacity, String foodType, Integer currentDiners) {
        this.id= id;
        this.name = name;
        this.capacity = capacity;
        this.foodType = foodType;
        this.currentDiners=currentDiners;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getCurrentDiners() {
        return currentDiners;
    }

    public void setCurrentDiners(Integer currentDiners) {
        this.currentDiners = currentDiners;
    }
}
