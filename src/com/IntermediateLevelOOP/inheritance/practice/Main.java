package com.IntermediateLevelOOP.inheritance.practice;

public class Main {

    public static void main(String[] args) {

        Cat matt = new Cat("Matt", 7, "male");
        matt.getDescription();
        matt.produceSound();

        System.out.println("-------------------------");

        Dog rex = new Dog("Rex", 4, "male");
        rex.getDescription();
        rex.produceSound();
    }
}
