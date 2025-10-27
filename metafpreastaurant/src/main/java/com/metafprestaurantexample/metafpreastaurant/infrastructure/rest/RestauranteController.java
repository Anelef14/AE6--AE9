package com.metafprestaurantexample.metafpreastaurant.infrastructure.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.metafprestaurantexample.metafpreastaurant.application.RestaurantService;
import com.metafprestaurantexample.metafpreastaurant.domain.APIResponse;
import com.metafprestaurantexample.metafpreastaurant.domain.CreateRestaurantRequest;
import com.metafprestaurantexample.metafpreastaurant.domain.RestaurantUpdateRequest;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping ("/restaurant")
public class RestauranteController {

    @Autowired
    private RestaurantService restaurantService;
    
    @PostMapping("/createRestaurant")
    @ResponseStatus(HttpStatus.CREATED)//201 instaed 200
    public CreateRestaurantRequest createRestaurant(@RequestBody CreateRestaurantRequest restaurant){
        return restaurantService.createRestaurant(restaurant);
    }

    @GetMapping("/{resId}")
    @ResponseStatus(HttpStatus.OK)
    public CreateRestaurantRequest getRestaurant(@PathVariable String resId){
        return restaurantService.getRestaurant(resId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CreateRestaurantRequest> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @PutMapping("/{resId}")
    @ResponseStatus(HttpStatus.OK)
    public CreateRestaurantRequest updateRestaurant(
            @PathVariable UUID resId,
            @RequestBody RestaurantUpdateRequest updatedData) {
        return restaurantService.updateRestaurant(resId, updatedData);
    }

    @DeleteMapping("/{resId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<APIResponse> deleteRestaurant(@PathVariable String resId){
        APIResponse response = new APIResponse();
        response.setMessage("Restaurant deleted succesfully with Restaurant ID " + resId);
        restaurantService.deleteRestaurant(resId);
        return ResponseEntity.ok(response);
    }
}
