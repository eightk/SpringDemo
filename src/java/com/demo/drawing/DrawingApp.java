/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.drawing;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author huico
 */
public class DrawingApp {
    public static void main(String[] args) {
        //The spring.xml will be at project root directory
        //BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
        //The spring.xml will be at src root directory
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        //can use bean id, bean name or alias to get bean.
        context.registerShutdownHook();
        //Adding support for the dependency injection for different shapes.
        Shape cir = (Shape) context.getBean("circle");
        cir.draw();
        Shape tri = (Shape)context.getBean("triangle-name");
        tri.draw();
        
        //To print the message from mymessages.properties file
        System.out.println("This is the message: " + context.getMessage("greeting", null, "Default Greeting", null));
    }
}
