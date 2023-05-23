package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.List;

public class OutputMessages {

    public OutputMessages() {
    }

    public void printStartingHeroes(List<Hero> heroes) {
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }

    public void printMenu() {
        printSeparator();
        System.out.println("\tWelcome to Heroes Fighting App");
        printSeparator();
    }

    public void printStartingText() {
        System.out.println("(Number must be even and between 4 and 256)");
        System.out.println("Please enter a number for the participants:");
    }

    public void printSeparator() {
        for (int i = 0; i < 45; i++) {
            System.out.print("-");
        }

        System.out.println();
    }
}
