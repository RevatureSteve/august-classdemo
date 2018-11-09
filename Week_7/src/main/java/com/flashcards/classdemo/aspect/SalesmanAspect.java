package com.flashcards.classdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SalesmanAspect {

    @Before("execution(* com.flashcards.classdemo.controller.SalesmanController.*(..))")
    public void highjackController(JoinPoint jp){
        System.out.println("Hijacking Salesman Controller");
        for (Object e: jp.getArgs())
        {
            System.out.println(e);
        }
        System.out.println("Method Name:" +jp.getSignature());
    }
    @Before("execution(* com.flashcards.classdemo.service.SalesmanService.*(..))")
    public void highjackService(JoinPoint jp){
        System.out.println("Hijacking Salesman Service");
        for (Object e: jp.getArgs())
        {
            System.out.println(e);
        }
        System.out.println("Method Name:" +jp.getSignature());
    }
}
