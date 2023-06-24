package com.lcwd.electronic.store.ElectronicStore.controller;

import com.lcwd.electronic.store.ElectronicStore.dtos.UserDto;
import com.lcwd.electronic.store.ElectronicStore.payloads.ApiResponse;
import com.lcwd.electronic.store.ElectronicStore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto user = userService.createUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer userId) {

        UserDto updateuser = userService.updateuser(userDto, userId);
        return new ResponseEntity<>(updateuser, HttpStatus.OK);

    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        ApiResponse message = ApiResponse.builder().message("User deleted").success("true").build();
        return  new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> allUser = userService.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer userId) {

        UserDto user = userService.getUser(userId);

        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping("/email/{emailId}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String emailId){

        UserDto userByEmail = userService.getUserByEmail(emailId);

        return new ResponseEntity<>(userByEmail, HttpStatus.OK);
    }



}