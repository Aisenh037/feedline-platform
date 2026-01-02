package com.food_app.FeedLine.exception;

public class ResourceNotFoundException extends  RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }

}
