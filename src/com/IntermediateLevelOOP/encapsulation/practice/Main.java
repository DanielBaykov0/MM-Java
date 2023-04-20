package com.IntermediateLevelOOP.encapsulation.practice;

public class Main {

    public static void main(String[] args) {

        Cat matt = new Cat("Matt", 7, "male");
        matt.getDescription();

        System.out.println("-------------------------");

        matt.setAge(3);
        matt.getDescription();
        System.out.println("Cat's gender is " + matt.getGender());
        matt.produceSound();

        System.out.println("-------------------------");

        Dog rex = new Dog("Rex", 4, "male");
        rex.getDescription();
        rex.produceSound();
    }
}
