package com.IntermediateLevelOOP.classesandobjects;

public class CarsApp {

    public static void main(String[] args) {

        DodgeChallenger reddodgeChallenger =
                new DodgeChallenger("red", (byte) 3, (short) 450, (short) 717, (short) 7700, 40000, 15000, true);
        reddodgeChallenger.getDescription();
        reddodgeChallenger.startTheEngine();

        System.out.println("----------------------------------------------------------");

        DodgeChallenger orangeDodgeChallenger =
                new DodgeChallenger("orange", (byte) 1, (short) 392, (short) 492, (short) 6700, 30000, 10000, false);
        orangeDodgeChallenger.getDescription();
        orangeDodgeChallenger.startTheEngine();
    }
}
