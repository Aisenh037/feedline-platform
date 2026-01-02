package com.food_app.FeedLine.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDuplicateKey(DataIntegrityViolationException ex) {
        if (ex.getMessage().contains("uk_users_email")) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Email already exists");
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Data integrity violation");
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
//        ErrorResponse errorResponse =  ErrorResponse.builder()
//                .message(ex.getMessage())
//                .status(HttpStatus.NOT_FOUND)
//                .build();
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ProblemDetail> handle(ResourceNotFoundException ex) {

        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        pd.setTitle("Resource Not Found");
        pd.setDetail(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(pd);
    }

}
