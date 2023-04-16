package com.IntermediateLevelOOP.defaultvalues;

public class Car {

    private byte numberOfSeats;
    private short horsePower;
    private int price;
    private long registrationNumber;

    private float fuelConsumption;
    private double preciseFuelConsumption;

    private boolean isDamaged;
    private char energyEfficiencyCategory;
    private String color;

    private Boolean hasElectricEngine;
    private Engine engine;

    public void getDetails() {
        System.out.println("Number of seats: " + numberOfSeats);
        System.out.println("Horsepower: " + horsePower);
        System.out.println("Price: €" + price);
        System.out.println("Registration number: " + registrationNumber);
        System.out.println("Fuel consumption: " + fuelConsumption);
        System.out.println("Precise fuel consumption: " + preciseFuelConsumption);
        System.out.println("The car is Damaged: " + isDamaged);
        System.out.println("Energy Efficiency Category: " + energyEfficiencyCategory);
        System.out.println("Car's color: " + color);
        System.out.println("This car has electric engine: " + hasElectricEngine);
        System.out.println("This engine this car has is: " + engine);
    }
}
