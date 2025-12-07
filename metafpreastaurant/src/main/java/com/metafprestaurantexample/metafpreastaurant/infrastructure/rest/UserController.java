package com.metafprestaurantexample.metafpreastaurant.infrastructure.rest;

import com.metafprestaurantexample.metafpreastaurant.application.UserService;
import com.metafprestaurantexample.metafpreastaurant.domain.APIResponse;
import com.metafprestaurantexample.metafpreastaurant.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDto> getUser(@PathVariable String userId){
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserDto>> getAllUser(){
        return new ResponseEntity<> (userService.getAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<APIResponse> deleteUser (@PathVariable String userId){
        APIResponse response = new APIResponse();
        response.setMessage("User deleted succesfully with User ID " + userId);
        userService.deleteUser(userId);
        return ResponseEntity.ok(response);
    }
}
