package com.IntermediateLevelOOP.polymorphism.practice;

public class Cat extends Animal implements AnimalActions {

    public Cat(String name, int age, String gender, int weight) {
        super(name, age, gender, weight);
    }

    @Override
    public void produceSound() {
        System.out.println("Meow, meow");
    }

    @Override
    public void lick() {
        System.out.println("The cat licked me");
    }

    @Override
    public void chew() {
        System.out.println("The cat is chewing her lunch");
    }
}
