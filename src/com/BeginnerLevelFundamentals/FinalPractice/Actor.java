package com.BeginnerLevelFundamentals.FinalPractice;

import java.time.Year;

public class Actor {

    private final String actressName;
    private final int yearOfBirth;

    public Actor() {
        this.actressName = "Margot Robbie";
        this.yearOfBirth = 1990;
    }

    public void printBio() {
        System.out.println("My favourite actress name is " + actressName);
        System.out.println("She is born in " + yearOfBirth + " and she is " + (Year.now().getValue() - yearOfBirth) + " years old");
    }
}
