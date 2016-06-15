/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.drawing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author huico
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Draw a circle:");
        System.out.println("Circle center is: (" + center.getXaxis() + "," + center.getYaxis() + ") and radius is " + radius);
    }
    
    public Point getCenter() {
        return center;
    }

    //@Required
    @Autowired/*first looks for type then looks for name*/
    @Qualifier("circleRelated")
    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    private Point center;
    private int radius;

    
    
}
