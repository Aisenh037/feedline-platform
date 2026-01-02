package com.food_app.FeedLine.controller;

import com.food_app.FeedLine.dto.UserDto;
import com.food_app.FeedLine.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Create User
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto user = userService.createUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //Get all users
    @GetMapping
    public ResponseEntity<Page<UserDto>> getAllUsers(
            @RequestParam(value = "page", required = false, defaultValue = "0")
            int page,
            @RequestParam(value = "size", required = false, defaultValue = "10")
            int size,
            @RequestParam(value = "sort", required = false, defaultValue = "createdAt")
            String sortBy,
            @RequestParam(value = "direction", required = false, defaultValue = "desc")
            String sortDir
    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<UserDto> users = userService.getAllUsers(pageable);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Get user by id
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String userId) {
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


//    @RequestMapping("/")
//    public String getUser() {
//        System.out.println("User Controller");
//        return "user_list";
//    }
//
//    @RequestMapping("/all")
//    public List<String> getAllUsers() {
//        return List.of("User 1", "User 2", "User 3");
//    }
}
