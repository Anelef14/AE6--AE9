package com.metafprestaurantexample.metafpreastaurant.domain;

public class RestaurantCreateRequest {

    private String name;

    private Integer capacity;

    private String foodType;

    private Integer currentDiners;

    public RestaurantCreateRequest () {}

    public Integer getCurrentDiners() {
        return currentDiners;
    }

    public void setCurrentDiners(Integer currentDiners) {
        this.currentDiners = currentDiners;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
