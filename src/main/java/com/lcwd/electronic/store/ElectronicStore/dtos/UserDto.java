package com.lcwd.electronic.store.ElectronicStore.dtos;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {


    private long userId;

   // @Size(min = 3,max = 15,message = "Invalid name !!")
    private String name;

//    @Email( message = "Invalid User Email !!")
//    @NotBlank(message = "Email is required")
    private String email;

   // @NotBlank(message = "password is required !!")
    private String password;

    //@Size(min =4,max = 6,message = "Invalid gender !!")
    private String gender;

    //@NotBlank(message = "write something about yourself")
    private String about;

    private String imageName;



}

