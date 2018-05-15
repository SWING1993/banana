package com.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {


        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

        Car car = ctx.getBean(Car.class);
        System.out.println(car);


        Person person = ctx.getBean(Person.class);
        System.out.println(person);
    }
}
