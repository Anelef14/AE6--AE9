package com.metafprestaurantexample.metafpreastaurant.domain;

public class CreateRestaurantRequest {
    private String name;
    private Integer capacity;
    private String foodType;

    public CreateRestaurantRequest(String name, Integer capacity, String foodType) {
        this.name = name;
        this.capacity = capacity;
        this.foodType = foodType;
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
    
}
