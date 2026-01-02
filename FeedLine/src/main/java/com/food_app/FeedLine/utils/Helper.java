package com.food_app.FeedLine.utils;

import java.util.UUID;

public class Helper {

    public static String generateRandomId(){
        return UUID.randomUUID().toString();
    }
}
