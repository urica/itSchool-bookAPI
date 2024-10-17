package com.itschool.rest_services.annotation;

@VeryImportant
public class Cat {
    String name;

    public Cat(String name) {
        this.name = name;
    }

    @RunImideatley(times = 3)
    public void makeSound() {
        System.out.println("Miau");
    }

    public void eat() {
        System.out.println("Munch");
    }
}
