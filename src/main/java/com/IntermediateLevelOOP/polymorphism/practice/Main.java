package com.IntermediateLevelOOP.polymorphism.practice;

public class Main {

    public static void main(String[] args) {

        Cat matt = new Cat("Matt", 7, "male", 2);
        matt.getDescription();

        System.out.println("-------------------------");

        matt.setAge(3);
        matt.getDescription();
        System.out.println("Cat's gender is " + matt.getGender());
        matt.produceSound();
        matt.lick();

        System.out.println("-------------------------");

        Dog rex = new Dog("Rex", 4, "male", 14);
        rex.getDescription();

        System.out.println("-------------------------");

        rex.eat(1);
        rex.setWeight(15);
        rex.getDescription();
        rex.produceSound();
        rex.lick();
    }
}
