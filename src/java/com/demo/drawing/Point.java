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
public class Point {

    public void myInit() {
        System.out.println("Point (" + this.getXaxis() + "," + this.getYaxis() + ") init");
    }

    public void cleanUp() {
        System.out.println("Point (" + this.getXaxis() + "," + this.getYaxis() + ") Clean up");
    }

    public int getXaxis() {
        return xaxis;
    }

    public void setXaxis(int xaxis) {
        this.xaxis = xaxis;
    }

    public int getYaxis() {
        return yaxis;
    }

    public void setYaxis(int yaxis) {
        this.yaxis = yaxis;
    }

    private int xaxis;
    private int yaxis;
}
