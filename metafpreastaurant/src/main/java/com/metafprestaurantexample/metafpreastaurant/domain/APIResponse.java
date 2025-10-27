package com.metafprestaurantexample.metafpreastaurant.domain;

import java.util.UUID;

public class APIResponse {
    
    private UUID resId;

    private String name;

    private int capacity;

    private String foodType;

    private String message;

    public APIResponse(UUID resId, String name, int capacity, String foodType, String message) {
        this.resId = resId;
        this.name = name;
        this.capacity = capacity;
        this.foodType = foodType;
        this.message = message;

    }

    public UUID getResId() {
        return resId;
    }

    public void setResId(UUID resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public APIResponse() {
    }
}
