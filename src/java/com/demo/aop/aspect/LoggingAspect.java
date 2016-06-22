/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author huico
 */
public class LoggingAspect {

    public void loggingAdvice() {
        System.out.println("All square getters advices.");
    }

    public void secondAdvice() {
        System.out.println("Second advice run.");
    }

    public void squareAdvice(JoinPoint joinPoint) {
        System.out.println(joinPoint.getTarget()+ " method " + joinPoint.toShortString() + " Advice run.");
    }
    
    public void afterReturningAdvice(String returnString) {
        System.out.println("After Returning Advice, return string is: " + returnString);
    }
    
    public void afterThrowingAdvice(Exception ex) {
        System.out.println("After throwing Advice, an exception has beenthrown: " + ex.getMessage());
    }
    
    //@Around will need to use pjp.proceed() to execute the method and we can add the advice before or after the method execution.
    //@Around("@annotation(com.demo.aop.aspect.Loggable)")    
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
}
