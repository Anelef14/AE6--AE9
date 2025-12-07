package com.metafprestaurantexample.metafpreastaurant.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class ReservationDto {

    private UUID id;
    @NotNull(message = "User Id is required")
    private UUID userId;
    @NotNull(message = "Restaurant Id is required")
    private UUID restaurantId;
    @NotNull(message = "Number of diners is required")
    @Min(value = 1, message = "Number of diners should be at least 1")
    private int diners;
    private boolean active;

    public ReservationDto(UUID id, UUID userId, UUID restaurantId, int diners, boolean active) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.diners = diners;
        this.active = active;
    }

    public ReservationDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
