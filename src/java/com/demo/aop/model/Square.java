/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.aop.model;
import com.demo.aop.aspect.Loggable;

/**
 *
 * @author huico
 */
public class Square {

    public String getName() {
        System.out.println(name);
        return name;
    }

    public void setName(String name) {
        System.out.println("Setting name...");
        this.name = name;
        /*if (StringUtils.startsWithIgnoreCase(name, "Dummy"));
        {
            throw (new RuntimeException());
        }*/
    }

    @Loggable
    public String setDummy(String val) {
        return "The value passed into this method is:" + val;
    }

    private String name;
}
