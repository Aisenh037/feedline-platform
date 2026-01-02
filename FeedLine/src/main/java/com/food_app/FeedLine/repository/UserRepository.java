package com.food_app.FeedLine.repository;

import com.food_app.FeedLine.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findById(String id);
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);

}
