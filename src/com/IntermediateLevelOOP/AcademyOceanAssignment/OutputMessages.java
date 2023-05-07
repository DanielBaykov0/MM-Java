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

    public void printSeparator() {
        for (int i = 0; i < 45; i++) {
            System.out.print("-");
        }

        System.out.println();
    }
}
