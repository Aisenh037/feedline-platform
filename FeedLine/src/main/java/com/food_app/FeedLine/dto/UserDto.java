package com.food_app.FeedLine.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String password;

//    private String confirm_password;
//    private String otp;
//
//    private String gender;
//    private String dob;
    private String address;
//
//    private String role;
//
//    private boolean isAvailable;
//
//    private String created_at;
//    private String updated_at;

}
