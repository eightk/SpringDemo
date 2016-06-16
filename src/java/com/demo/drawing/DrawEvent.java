/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.drawing;

import org.springframework.context.ApplicationEvent;

/**
 *
 * @author huico
 */
public class DrawEvent extends ApplicationEvent {
    
    public DrawEvent(Object source) {
        super(source);
    }

    @Override
    public String toString() {
        return "Draw Event:" + super.toString();
    }
    
    
    
}
