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
        Triangle tri = (Triangle)context.getBean("triangle-name");
        tri.draw();
    }
}
