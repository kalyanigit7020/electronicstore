package com.lcwd.electronic.store.ElectronicStore.repositories;

import com.lcwd.electronic.store.ElectronicStore.entities.User;
import com.lcwd.electronic.store.ElectronicStore.services.UserService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository <User,Integer>{

    List<User> findByNameContaining (String keyword);

   Optional<User> findByEmailAndPassword(String Email, String password);

    Optional<User> findByEmail(String email);
}

