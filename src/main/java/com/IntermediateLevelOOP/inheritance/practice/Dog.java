package com.IntermediateLevelOOP.inheritance.practice;

public class Dog extends Animal {

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void produceSound() {
        System.out.println("Woof, woof");
    }
}
