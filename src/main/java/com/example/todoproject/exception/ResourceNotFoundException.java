package com.example.todoproject.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ResourceNotFoundException extends RuntimeException {
    private final String message;

    public ResourceNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
