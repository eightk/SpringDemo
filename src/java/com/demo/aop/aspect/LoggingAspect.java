/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.aop.aspect;

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
    public void squareAdvice() {
        System.out.println("All Square methods Advice run.");
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
    @Pointcut("args(com.demo.aop.model.Square)")
    public void allMethodsWithString() {
        //dummy method only for holding pointcut
    }
}
