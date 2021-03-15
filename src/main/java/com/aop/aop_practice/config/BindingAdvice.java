package com.aop.aop_practice.config;

import com.aop.aop_practice.domain.CommonDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

//@Controller, @RestController, @Component, @Configuration -> 메모리에 띄우기
@Component
@Aspect
public class BindingAdvice {
 @Around("execution(* com.aop.aop_practice.web..*Controller.*(..))")
 public Object validCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
  String type= proceedingJoinPoint.getSignature().getDeclaringTypeName();
  String method=proceedingJoinPoint.getSignature().getName();

  System.out.println("type: "+type);
  System.out.println("name: "+method);
  Object[] args=proceedingJoinPoint.getArgs();
  for(Object arg : args){
   if(arg instanceof BindingResult){
    BindingResult bindingResult = (BindingResult) arg;
    if(bindingResult.hasErrors()){
     Map<String, String> errorMap=new HashMap<>();
     for(FieldError error : bindingResult.getFieldErrors()){
      errorMap.put(error.getField(), error.getDefaultMessage());
     }
     return new CommonDto<>(HttpStatus.BAD_REQUEST.value(), errorMap);
    }
   }
  }
  return proceedingJoinPoint.proceed();
 }
 //함수 매개변수로 들어오는 애들 다 가져와야댐
}
