/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.aop;

import com.demo.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author huico
 */
public class AopMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
        System.out.println();  
        shapeService.getSquare().setDummy("Dummy Square name");
        System.out.println();        
        shapeService.getSquare().getName();
        System.out.println();   
        shapeService.getRectangle().getName();
    }
}
