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
import com.metafprestaurantexample.metafpreastaurant.dto.RestaurantDto;
import com.metafprestaurantexample.metafpreastaurant.domain.RestaurantUpdateRequest;
import com.metafprestaurantexample.metafpreastaurant.domain.RestaurantCreateRequest;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping ("/restaurant")
public class RestauranteController {

    @Autowired
    private RestaurantService restaurantService;
    
    @PostMapping("/createRestaurant")
    @ResponseStatus(HttpStatus.CREATED)//201 instaed 200
    public ResponseEntity<RestaurantCreateRequest>  createRestaurant(@RequestBody RestaurantCreateRequest restaurant){
        return new ResponseEntity<>(restaurantService.createRestaurant(restaurant), HttpStatus.CREATED);
    }

    @GetMapping("/{resId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<RestaurantDto> getRestaurant(@PathVariable String resId){
        return new ResponseEntity<>(restaurantService.getRestaurant(resId), HttpStatus.OK);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <List<RestaurantDto>> getAllRestaurants() {
        return new ResponseEntity<> (restaurantService.getAllRestaurants(), HttpStatus.OK);
    }

    @PutMapping("/{resId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <RestaurantDto >updateRestaurant(
            @PathVariable UUID resId,
            @RequestBody RestaurantUpdateRequest updatedData) {
        return new ResponseEntity<> (restaurantService.updateRestaurant(resId, updatedData), HttpStatus.OK);
    }

    @DeleteMapping("/{resId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<APIResponse> deleteRestaurant(@PathVariable String resId){
        APIResponse response = new APIResponse();
        response.setMessage("Restaurant deleted successfully with Restaurant ID " + resId);
        restaurantService.deleteRestaurant(resId);
        return ResponseEntity.ok(response);
    }
}
