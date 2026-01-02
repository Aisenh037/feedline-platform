package com.food_app.FeedLine.service.impl;

import com.food_app.FeedLine.dto.UserDto;
import com.food_app.FeedLine.entity.User;
import com.food_app.FeedLine.exception.ResourceNotFoundException;
import com.food_app.FeedLine.utils.Helper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.food_app.FeedLine.repository.UserRepository;
import com.food_app.FeedLine.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * @param userDto
     * @return
     */
    @Override
    public UserDto createUser(UserDto userDto) {
//        Generate random id using helper class in utils package
        userDto.setId(Helper.generateRandomId());

        //Saving the user in database
        User user = convertUserDtoToUser(userDto);
        User savedUser = userRepository.save(user);
        return convertUserToUserDto(savedUser);
    }


    @Override
    public Page<UserDto> getAllUsers(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage.map(user -> convertUserToUserDto(user));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public UserDto getUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not Found !!"));
        return convertUserToUserDto(user);
    }

    /**
     * @param email
     * @return
     */
    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not Found !!"));
        return convertUserToUserDto(user);
    }

    /**
     * @param name
     * @return
     */
    @Override
    public List<UserDto> searchUserName(String name) {
        Optional<User> users = userRepository.findByName(name);
        List<UserDto> userDtos = users
                .stream().
                map((user)->convertUserToUserDto(user)).toList();
        return userDtos;
    }

    /**
     * @param userDto
     * @param id
     * @return
     */
    @Override
    public UserDto updateUser(UserDto userDto, String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not Found !!"));
        BeanUtils.copyProperties(userDto,user);
        User updatedUser = userRepository.save(user);
        return convertUserToUserDto(updatedUser);
    }

    /**
     * @param id
     */
    @Override
    public void deleteUser(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not Found !!"));
        userRepository.delete(user);
    }

    //Converting UserDTO to User to save in the database
    private User convertUserDtoToUser(UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        return  user;
    }

    //Converting user to userDTO
    private UserDto convertUserToUserDto(User user){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }

}
