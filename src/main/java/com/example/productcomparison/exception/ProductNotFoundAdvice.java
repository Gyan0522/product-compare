package com.example.productcomparison.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ProductComparison {

    @ResponseBody
    @ExceptionHandler(ProductEcommNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String InstrumentNotFoundHandler(ProductEcommNotFoundException ex) {
        return ex.getMessage();
    }
    
    @ResponseBody
    @ExceptionHandler(ProductRetailNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String InstrumentNotFoundHandler(ProductRetailNotFoundException ex) {
        return ex.getMessage();
    }
}