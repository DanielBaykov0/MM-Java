package com.IntermediateLevelOOP.classesandobjects;

import java.util.Random;

public class DodgeChallenger {

    byte numberOfSeats = 5;
    byte numberOfDoors = 3;
    byte numberOfVehicleOwners = 1;
    byte emissionSticker = 4;

    short power = 362;
    short horsePower = 492;
    short co2Emission = 333;
    short cubicCapacity = 6417;

    int price = 29999;
    int mileage = 14999;

    long registrationNumber = 234356468443164L;

    float fuelConsumptionCombined = 15.5F;
    float fuelConsumptionUrban = 21.4F;
    float fuelConsumptionExtraUrban = 13.6F;

    double fuelConsumptionPreciseAverage = 153.214654568748612e-1;

    boolean isDamaged = true;

    char energyEfficiencyCategory = 'G';

    String color;

    DodgeChallenger(String color, byte numberOfVehicleOwners, short power, short horsePower, short cubicCapacity,
                    int price, int mileage, boolean isDamaged) {
        this.color = color;
        this.numberOfVehicleOwners = numberOfVehicleOwners;
        this.power = power;
        this.horsePower = horsePower;
        this.cubicCapacity = cubicCapacity;
        this.price = price;
        this.mileage = mileage;
        this.isDamaged = isDamaged;
        Random randomNumberGenerator = new Random();
        this.registrationNumber = randomNumberGenerator.nextLong();
    }

    public void startTheEngine() {
        System.out.println("The engine is started");
    }

    public void getDescription() {
        System.out.println("A(n) " + color + " Dodge Challenger is created");
        System.out.println("Price: €" + price);
        System.out.println("Mileage: " + mileage + "km");
        System.out.println("The car is Damaged: " + isDamaged);
        System.out.println("Registration number: " + registrationNumber);
        System.out.println("Cubic capacity: " + cubicCapacity + "ccm");
        System.out.println("Power: " + power + "kW(" + horsePower + "hp)");
        System.out.println("CO2 emission: " + co2Emission + "g/km");
        System.out.println("Emission sticker: " + emissionSticker + " (Energy Efficiency Category: " + energyEfficiencyCategory + ")");
        System.out.println("Combined Fuel Consumption: " + fuelConsumptionCombined + "l/100km");
        System.out.println("Urban Fuel Consumption: " + fuelConsumptionUrban + "l/100km");
        System.out.println("Extra Urban Fuel Consumption: " + fuelConsumptionExtraUrban + "l/100km");
        System.out.println("Precise Average Fuel Consumption: " + fuelConsumptionPreciseAverage + "l/100km");
        System.out.println("Number of previous owners: " + numberOfVehicleOwners);
        System.out.println("Number of doors: " + numberOfDoors);
        System.out.println("Number of seats: " + numberOfSeats);
    }
}
