package com.BeginnerLevelFundamentals.datatypes.primitives;

public class Primitives {

    public static void main(String[] args) {
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

        System.out.println("2018 Dodge Challenger SRT 392");
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

        System.out.println("Conversion");
        short newNumberOfSeats = numberOfSeats;
        System.out.println("The value of newNumberOfSeats = " + newNumberOfSeats);

        double newFuelConsumptionCombined = fuelConsumptionCombined;
        System.out.println("The value of newFuelConsumptionCombined = " + newFuelConsumptionCombined + "l/100km");

        byte newPower = (byte) power;
        System.out.println("The value of newPower = " + newPower + "kW");
    }
}
