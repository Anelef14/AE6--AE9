package com.metafprestaurantexample.metafpreastaurant.domain;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurant", schema = "restaurants" )
public class Restaurant {
    @Id
    @Column(name = "res_id")
    @GeneratedValue
    private UUID resId;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "food_type")
    private String foodType;

    public Restaurant (String name , int capacity, String foodType){
        this.name = name;
        this.capacity = capacity;
        this.foodType = foodType;
    }

    public Restaurant() {}



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
}
