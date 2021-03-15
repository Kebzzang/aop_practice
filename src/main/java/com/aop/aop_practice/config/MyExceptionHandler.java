package com.aop.aop_practice.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(value=IllegalArgumentException.class)
    public String fault(IllegalArgumentException el){
        return "오류: "+el.getMessage();

    }

}
