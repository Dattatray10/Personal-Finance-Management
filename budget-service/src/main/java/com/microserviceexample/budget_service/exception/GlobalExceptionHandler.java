package com.microserviceexample.budget_service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<?> handleException(MethodArgumentNotValidException exception){

        Map<String,String> erros = new HashMap<>();
          exception.getBindingResult().getFieldErrors().forEach(ex->
                erros.put(ex.getField(),ex.getDefaultMessage()));

          return ResponseEntity.badRequest().body(erros);
    }
}
