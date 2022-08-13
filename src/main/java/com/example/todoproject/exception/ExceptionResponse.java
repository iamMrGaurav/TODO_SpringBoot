package com.example.todoproject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ExceptionResponse {
    private String message;
    private HttpStatus status;
    private ZonedDateTime dateTime;
}
