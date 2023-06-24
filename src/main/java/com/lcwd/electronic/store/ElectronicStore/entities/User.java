package com.lcwd.electronic.store.ElectronicStore.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Table(name="users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "user_name")
    private String name;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password",length = 10)
    private String password;

    private String gender;
    @Column(name = "about")
    private String about;
    @Column(name = "user_image_name")
    private String imageName;






}
