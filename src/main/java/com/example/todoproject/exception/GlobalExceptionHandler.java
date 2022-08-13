package com.example.todoproject.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse(ex.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ExceptionResponse response = new ExceptionResponse(ex.getAllErrors().get(0).getDefaultMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }
}
