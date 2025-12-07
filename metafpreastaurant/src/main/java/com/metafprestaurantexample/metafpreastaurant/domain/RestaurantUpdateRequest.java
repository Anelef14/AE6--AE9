package com.metafprestaurantexample.metafpreastaurant.domain;

public class RestaurantUpdateRequest {
    private Integer capacity;
    private String foodType;

    public RestaurantUpdateRequest () {}

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
