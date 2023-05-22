package com.IntermediateLevelOOP.inheritance.practice;

public class Animal {

    private final String name;
    private final int age;
    private final String gender;

    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void produceSound() {
    }

    public void getDescription() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
    }
}
