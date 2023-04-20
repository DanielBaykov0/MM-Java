package com.IntermediateLevelOOP.polymorphism.practice;

public abstract class Animal {

    private String name;
    private int age;
    private String gender;
    private int weight;

    public Animal(String name, int age, String gender, int weight) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
    }

    public abstract void produceSound();

    public void getDescription() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Weight: " + weight);
    }

    public void eat(int foodInKg) {
        this.weight += Math.abs(foodInKg);
        System.out.println("int function is called");
    }

    public void eat(double foodInKg) {
        int wholeNumber = (int) Math.round(foodInKg);
        this.weight += wholeNumber;
        System.out.println("double function is called");
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
