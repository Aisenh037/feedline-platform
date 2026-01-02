package com.food_app.FeedLine.controller;

import com.food_app.FeedLine.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/signup")
    public String signup(@RequestBody User user) {
        logger.info("User: {}", user.getName());
        logger.info("User: {}", user.getEmail());
        logger.info("User: {}", user.getPassword());
        return  "signup successfull!";
    }


}
