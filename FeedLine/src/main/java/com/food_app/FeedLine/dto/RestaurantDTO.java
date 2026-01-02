package com.food_app.FeedLine.dto;

import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantDTO {
    private String id;
    private String name;
    private String description;

    private String address;
    private String phone;
    private String email;

    private LocalTime openTime;
    private LocalTime closeTime;

    private Boolean isOpen=true;

    private String banner;

}
