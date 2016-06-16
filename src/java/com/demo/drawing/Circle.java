/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.drawing;

import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 *
 * @author huico
 */
@Component
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Draw a " + this.messageSource.getMessage("circleType", null, "Default Circle", null) + ":");
        System.out.println("Circle center " + this.messageSource.getMessage("drawing.point", new Object[] {center.getXaxis(), center.getYaxis()}, "Default Point Message", null) + " and radius is " + radius);
    }
    
    @PostConstruct
    public void initCircle() {
        System.out.println("init the circle.");
    }
    
    @PreDestroy
    public void destroyCircle() {
        System.out.println("destroy the circle.");
    }
    
    public Point getCenter() {
        return center;
    }

    //@Required
    //@Autowired/*first looks for type then looks for name*/
    //@Qualifier("circleRelated")
    @Resource(name="pd")/*if not defining the name attribute it will find the bean by name*/
    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    
    private Point center;
    private int radius;
    @Autowired
    private MessageSource messageSource;   
    
}
