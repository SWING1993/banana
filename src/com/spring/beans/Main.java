package com.spring.beans;

import com.spring.annotation.TestObject;
import com.spring.annotation.controller.UserController;
import com.spring.annotation.repository.UserRepositoryImpl;
import com.spring.annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        /*

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

        Car car = ctx.getBean(Car.class);
        System.out.println(car);


        Person person = ctx.getBean(Person.class);
        System.out.println(person);


        ApplicationContext factoryCtx = new ClassPathXmlApplicationContext("factorybeans.xml");
        Car factoryCar1 = (Car) factoryCtx.getBean("car1");
        System.out.println(factoryCar1);

        Car factoryCar2 = (Car) factoryCtx.getBean("car2");
        System.out.println(factoryCar2);
        */

        ApplicationContext annotationCtx = new ClassPathXmlApplicationContext("spring-annotation.xml");

//        TestObject testObject = (TestObject) annotationCtx.getBean("testObject");
//        System.out.println(testObject);
//
//        UserRepositoryImpl userRepository = (UserRepositoryImpl) annotationCtx.getBean("userRepositoryImpl");
//        System.out.println(userRepository);

        UserController userController = (UserController) annotationCtx.getBean("userController");
        System.out.println(userController);
        userController.execute();

//        UserService userService = (UserService) annotationCtx.getBean("userService");
//        System.out.println(userService);

    }
}
