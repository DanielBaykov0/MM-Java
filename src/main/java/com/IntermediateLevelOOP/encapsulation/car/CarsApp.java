package com.IntermediateLevelOOP.encapsulation.car;

public class CarsApp {

    public static void main(String[] args) {

        DodgeChallenger reddodgeChallenger =
                new DodgeChallenger("red", (byte) 3, (short) 450, (short) 717, (short) 7700, 40000, 15000, true);
        System.out.println(reddodgeChallenger.getCarName() + "'s price is $" + reddodgeChallenger.getPrice());
        reddodgeChallenger.setPrice(-35000);
        System.out.println(reddodgeChallenger.getCarName() + "'s price is $" + reddodgeChallenger.getPrice());
        reddodgeChallenger.startTheEngine();
        System.out.println("The car has " + reddodgeChallenger.getMileage() + " miles");
        reddodgeChallenger.drive(0);
        System.out.println("After driving the car has " + reddodgeChallenger.getMileage() + " miles");

        System.out.println("----------------------------------------------------------");

        ToyotaSupra blackToyotaSupra =
                new ToyotaSupra("black", (byte) 1, (short) 225, (short) 717, (short) 3500, 40000, 15000, true);
        System.out.println(blackToyotaSupra.getCarName() + "'s price is $" + blackToyotaSupra.getPrice());
        blackToyotaSupra.setPrice(32000);
        System.out.println(blackToyotaSupra.getCarName() + "'s price is $" + blackToyotaSupra.getPrice());
        blackToyotaSupra.startTheEngine();
        System.out.println("The car has " + blackToyotaSupra.getMileage() + " miles");
        blackToyotaSupra.drive(200);
        System.out.println("After driving the car has " + blackToyotaSupra.getMileage() + " miles");
    }
}
