package com.IntermediateLevelOOP.AcademyOceanAssignment;

public class Warrior extends Hero {

    public Warrior() {
        super("Warrior");
    }

    @Override
    public String getQuote() {
        return "If you're a true warrior, competition doesn't scare you.\n" +
                "It makes you better.";
    }

    @Override
    public int attack() {
        return super.attack();
    }

    @Override
    public int defend() {
        return super.defend();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
