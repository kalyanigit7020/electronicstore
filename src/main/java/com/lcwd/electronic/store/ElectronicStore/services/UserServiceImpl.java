  package com.lcwd.electronic.store.ElectronicStore.services;

import com.lcwd.electronic.store.ElectronicStore.dtos.UserDto;
import com.lcwd.electronic.store.ElectronicStore.entities.User;
import com.lcwd.electronic.store.ElectronicStore.exception.ResourceNotFoundException;
import com.lcwd.electronic.store.ElectronicStore.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDto createUser(UserDto userDto) {

        User user = dtoToEntity(userDto);
        User save = userRepository.save(user);
        UserDto userDto1 = entityToDto(save);
        return userDto1;
    }

    @Override
    public UserDto updateuser(UserDto userDto, Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user not found with given userId"));

        user.setName(userDto.getName());
        user.setAbout(userDto.getAbout());
        user.setGender(userDto.getGender());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setImageName(userDto.getImageName());

        User save = userRepository.save(user);
        UserDto updateDto = entityToDto(user);

        return updateDto;
    }

    @Override
    public void deleteUser(Integer userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found with given userId"));

        userRepository.delete(user);
    }

    @Override
    public List<UserDto> getAllUser() {



            List<User> allusers = userRepository.findAll();

            List<UserDto>dtos = allusers.stream().map(user -> entityToDto(user)).collect(Collectors.toList());


            return dtos;

    }


    @Override
    public UserDto getUser(Integer userId) {
        User usersid = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found with given userId"));
        User save = userRepository.save(usersid);
        UserDto userDto = entityToDto(save);

        return userDto ;
    }

    @Override
    public List<UserDto> searchUser(String keyword) {

        List<User> users = userRepository.findByNameContaining(keyword);
        List<UserDto> collect = users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());

        return  collect ;
    }


    @Override
    public UserDto getUserByEmail(String email) {

        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("users not found "));
        UserDto userDto = entityToDto(user);

        return userDto;

    }


    private User dtoToEntity(UserDto userDto) {

        return modelMapper.map(userDto, User.class);
    }

    private UserDto entityToDto(User savedUser) {

        return modelMapper.map(savedUser, UserDto.class);
    }


}


