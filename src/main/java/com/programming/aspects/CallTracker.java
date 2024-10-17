package com.programming.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // To identify the class by spring container
@Aspect  // Enables spring AOP functionality in an application.
public class CallTracker {

 // We use this annotation to tell spring, before which service method this method will execute
 // which is annotated with @Around
    @Pointcut("within(com..service.*)")
    public void logMethodPointCut(){

    }


 // We can advice to the spring framework that this method will execute before and after of method.
    @Around("logMethodPointCut()")
    public Object logMethodCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String name = proceedingJoinPoint.getSignature().getName();
        System.out.println("Method Start : "+ name);
        Object returnValue = proceedingJoinPoint.proceed();
        System.out.println(returnValue);
        System.out.println("Method End : "+ name);
        return returnValue;
    }

 /*
    ProceedingJoinPoint :- Using this we are capturing the method, which is going to be execute now.
    proceed() :- By saying proceed(), we are invoking the method .
  */

}
