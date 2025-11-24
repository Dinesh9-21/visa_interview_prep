package com.example.Employee.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> argumentNotValid(MethodArgumentNotValidException exception){
        HashMap<String,String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().stream().map(err->errors.put(err.getField(),err.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.OK);
    }

}
