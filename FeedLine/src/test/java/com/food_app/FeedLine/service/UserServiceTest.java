package com.food_app.FeedLine.service;

import com.food_app.FeedLine.entity.Restuarant;
import com.food_app.FeedLine.entity.User;
import com.food_app.FeedLine.entity.enums.Role;
import com.food_app.FeedLine.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

//    @Autowired
//    private RestaurantService restaurantService;

    @Test
    public void testUserService() {
        System.out.println("User Service Test");

        User user = new User();
        user.setName("test_user1");
        user.setEmail("test_email1");
        user.setAvailable(true);
        user.setAddress("test_address1");
        user.setPassword("test_password1");
        user.setRole(Role.ADMIN);

        // Restuarant 1
        Restuarant restuarant = new Restuarant();
        restuarant.setId(UUID.randomUUID().toString());
        restuarant.setName("test_restuarant1");
        restuarant.setAddress("test_address1");
        restuarant.setOpen(true);
        restuarant.setUser(user);


        // Restuarant 2
        Restuarant restuarant1 = new Restuarant();
        restuarant1.setId(UUID.randomUUID().toString());
        restuarant1.setName("test_restuarant1");
        restuarant1.setAddress("test_address1");
        restuarant1.setOpen(true);
        restuarant1.setUser(user);

        user.getRestuarant().add(restuarant);
        user.getRestuarant().add(restuarant1);

        // Save and test user operations here
        User savedUser = userService.createUser(user);

    }

    @Test
    public void testUpdateUser() {
        userService.updateUser();
        System.out.println("Test User Updated!");



    }
}
