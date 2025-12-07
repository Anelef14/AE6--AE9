package com.metafprestaurantexample.metafpreastaurant.domain;

import java.util.UUID;

public class ReservationRequest {

    private UUID userId;

    private UUID restaurantId;

    private int diners;

    public ReservationRequest() {}

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(UUID restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getDiners() {
        return diners;
    }

    public void setDiners(int diners) {
        this.diners = diners;
    }
}
