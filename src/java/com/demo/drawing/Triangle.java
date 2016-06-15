/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.drawing;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 *
 * @author huico
 */
public class Triangle implements InitializingBean, DisposableBean, Shape {

    public Triangle() {
        this.type = "equalient";
        this.height = 1;
    }

    public Triangle(String type) {
        this.type = type;
        this.height = 2;
    }

    public Triangle(int height) {
        this.type = "int";
        this.height = height;
    }

    public Triangle(String type, int height) {
        this.type = type;
        this.height = height;
    }

    public Triangle(Point pa, Point pb, Point pc) {
        this.pa = pa;
        this.pb = pb;
        this.pc = pc;
        this.type = "Test assign points";
        this.height = pa.getYaxis() - pc.getYaxis();
    }

    @Override
    public void draw() {
        System.out.println(getHeight() + " cm height " + getType() + " Triangle!");
        System.out.println("Point A: (" + pa.getXaxis() + "," + pa.getYaxis() + ")");
        System.out.println("Point B: (" + pb.getXaxis() + "," + pb.getYaxis() + ")");
        System.out.println("Point C: (" + pc.getXaxis() + "," + pc.getYaxis() + ")");
    }

    public void myInit() {
        System.out.println("Triangle init");
    }
    
    public void cleanUp() {
        System.out.println("Triangle Clean up");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Point getPa() {
        return pa;
    }

    public void setPa(Point pa) {
        this.pa = pa;
    }

    public Point getPb() {
        return pb;
    }

    public void setPb(Point pb) {
        this.pb = pb;
    }

    public Point getPc() {
        return pc;
    }

    public void setPc(Point pc) {
        this.pc = pc;
    }

    private String type;
    private int height;
    private Point pa;
    private Point pb;
    private Point pc;
    
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean interface init");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean interface clean up");
    }
}
