package com.IntermediateLevelOOP.abstraction.practice;

public class Dog extends Animal implements AnimalActions {

    public Dog(String name, int age, String gender, int weight) {
        super(name, age, gender, weight);
    }

    @Override
    public void produceSound() {
        System.out.println("Woof, woof");
    }

    @Override
    public void lick() {
        System.out.println("The dog is licking me");
    }

    @Override
    public void chew() {
        System.out.println("The dog is chewing his toy bone");
    }
}
