/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.drawing;

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
