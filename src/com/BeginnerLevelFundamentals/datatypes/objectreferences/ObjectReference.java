package com.BeginnerLevelFundamentals.datatypes.objectreferences;

public class ObjectReference {

    public static void main(String[] args) {
        Byte numberOfSeats = 5;
        Short horsePower = 392;
        Integer price = 14999;
        Long registrationNumber = 323455445421454L;

        Float fuelConsumptionCombined = 15.5F;
        Double fuelConsumptionPrecise = 15.2346354343432;

        Boolean isDamaged = true;
        Character energyEfficiencyCategory = 'G';

        String carModel = "Dodge Challenger SRT 392";
        String carModelNew = new String("Dodge Challenger SRT 392");

        System.out.println("Number of seats: " + numberOfSeats);
        System.out.println("Horse power: " + horsePower);
        System.out.println("Price: $" + price.floatValue());
        System.out.println("Registration number: " + registrationNumber);
        System.out.println("Combined fuel consumption: " + fuelConsumptionCombined);
        System.out.println("Precise fuel consumption: " + fuelConsumptionPrecise.intValue());
        System.out.println("This car is damaged: " + isDamaged);
        System.out.println("Energy efficiency category: " + energyEfficiencyCategory);

        System.out.println("The car model: " + carModel);
        System.out.println("The car model with uppercase: " + carModel.toUpperCase());
        System.out.println("The car model with lowercase: " + carModel.toLowerCase());
        System.out.println("Car model and car model with new keyword are equal: " + carModel.equals(carModelNew));
        System.out.println("The car model with new keyword: " + carModelNew);
    }
}
