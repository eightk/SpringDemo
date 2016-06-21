/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.service;

import com.demo.aop.model.Rectangle;
import com.demo.aop.model.Square;

/**
 *
 * @author huico
 */
public class ShapeService {

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
    
    private Square square;
    private Rectangle rectangle;   
}
