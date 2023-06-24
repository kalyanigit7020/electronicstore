package com.lcwd.electronic.store.ElectronicStore.services;

import com.lcwd.electronic.store.ElectronicStore.dtos.UserDto;

import java.util.List;

public interface UserService {
    //create user
    UserDto createUser(UserDto userDto);

    //update user
    UserDto updateuser(UserDto userDto, Integer userId);

    //delete user

    void deleteUser(Integer userId);

    //get all user
    List<UserDto> getAllUser();

    //get user by Id
    UserDto getUser(Integer userId);

    //search user
    List<UserDto>searchUser(String keyword);

    //get user by email
    UserDto getUserByEmail(String email);


}
