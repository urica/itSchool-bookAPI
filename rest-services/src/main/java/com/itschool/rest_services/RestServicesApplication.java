package com.itschool.rest_services;

import com.itschool.rest_services.annotation.Cat;
import com.itschool.rest_services.annotation.Dog;
import com.itschool.rest_services.annotation.RunImideatley;
import com.itschool.rest_services.annotation.VeryImportant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpringBootApplication
public class RestServicesApplication {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        SpringApplication.run(RestServicesApplication.class, args);

//        Cat cat = new Cat("Stela");
//        Dog dog = new Dog();
//
//        if (cat.getClass().isAnnotationPresent(VeryImportant.class)) {
//            System.out.println("this thing is very important!");
//        } else
//            System.out.println("This thing is not important :(");
//
//        //Using reflection
//
//        for (Method method : cat.getClass().getDeclaredMethods()) {
////            if(method.isAnnotationPresent(RunImideatley.class)){
////                method.invoke(cat);
////            }
//
//            if (method.isAnnotationPresent(RunImideatley.class)) {
//                RunImideatley runImideatley = method.getAnnotation(RunImideatley.class);
//
//                for (int i = 0; i < runImideatley.times(); i++) {
//                    method.invoke(cat);
//                }
//
//            }
//        }


    }
}
