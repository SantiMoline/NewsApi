package com.smdevelopment.egg_news;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.smdevelopment.egg_news.exception.EntityNotFoundException;
import com.smdevelopment.egg_news.exception.ErrorResponse;

@ControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e) {
        ErrorResponse error = new ErrorResponse(Arrays.asList(e.getMessage()));
        return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
    }
}
