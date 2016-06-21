/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.aop.aspect;

import java.lang.annotation.Annotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author huico
 */
@Aspect
public class LoggingAspect {

    //add wildcard to the aspect, apply the aspect to all method starts with get and return any type, apply this aspect method to multiple methods
    //in the get*() .. means >=0 args * means >1 args
    @Before("allGetters() && allSquareMethods()")
    public void loggingAdvice() {
        System.out.println("All square getters advices.");
    }

    //pointcut demo
    @Before("allGetters()")
    public void secondAdvice() {
        System.out.println("All getters advice run.");
    }

    @Before("allSquareMethods()")
    public void squareAdvice(JoinPoint joinPoint) {
        System.out.println(joinPoint.getTarget()+ " method " + joinPoint.toShortString() + " Advice run.");
    }
    
    //@After Will execute even the method fails to complete
    //@AfterReturning will only execute when the method succeed
    //@AfterThrowing will execute when the method throws an exception
    //getting the return result from the method and pass it into the aspect method
    @AfterReturning(pointcut="args(name)", returning="returnString")
    public void stringArgMethodAdvice(String name, String returnString) {
        System.out.println("Args Advice run after setting value: " + name + ", return string is: " + returnString);
    }
    
    //dealing with exception
    @AfterThrowing(pointcut="args(name)", throwing="ex")
    public void stringArgMethodAdvice(String name, Exception ex) {
        System.out.println("Args Advice run after setting value: " + name + ", an exception has beenthrown: " + ex.getMessage());
    }
    
    //@Around will need to use pjp.proceed() to execute the method and we can add the advice before or after the method execution.
    @Around("@annotation(com.demo.aop.aspect.Loggable)")    
    public Object myAroundAdvice(ProceedingJoinPoint pjp) {        
        Object returnValue = null;
        try {
            System.out.println("@Before Process the method: " + pjp.toShortString());
            returnValue = pjp.proceed();
            System.out.println("@AfterReturning the method: " + pjp.toShortString() + " return value is: " + returnValue.toString());
        } catch (Throwable ex) {
            System.out.println("@AfterThrowing the method: " + pjp.toShortString());
        }
        System.out.println("@After finally Process the method: " + pjp.toShortString());
        //can get the return object as well
        return returnValue;
    }

    //execution takes parameter about method names
    @Pointcut("execution(public * get*(..))")
    public void allGetters() {
        //dummy method only for holding pointcut
        //it will not be executed, so "All getters" will not be printed
        System.out.println("All getters");
    }

    //within takes parameter about classes
    @Pointcut("within(com.demo.aop.model.Square)")
    public void allSquareMethods() {
        //dummy method only for holding pointcut
    }

    //args takes parameter about args type
    @Pointcut("args(String)")
    public void allMethodsWithStringArg() {
        //dummy method only for holding pointcut
    }
}
