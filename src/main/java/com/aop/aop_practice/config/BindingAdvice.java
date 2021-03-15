package com.aop.aop_practice.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Controller, @RestController, @Component, @Configuration -> 메모리에 띄우기
@Component
@Aspect
public class BindingAdvice {
 @Around("execution(* com.aop.aop_practice.web..*Controller.*(..))")
 public void validCheck(ProceedingJoinPoint proceedingJoinPoint){}
 //함수 매개변수로 들어오는 애들 다 가져와야댐
}
