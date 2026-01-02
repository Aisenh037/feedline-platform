package com.food_app.FeedLine.service;

import com.food_app.FeedLine.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDto createUser(UserDto userDto);


    public Page<UserDto> getAllUsers(Pageable pageable);
    public  UserDto getUserById(String id);
    public UserDto getUserByEmail(String email);

    //Extra Functions
    public List<UserDto> searchUserName(String name);


    public UserDto updateUser(UserDto userDto, String id);


    public void deleteUser(String id);
}
