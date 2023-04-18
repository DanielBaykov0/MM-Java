package com.AdvancedLevel.io;

import java.util.Scanner;

public class CharacterApp {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome to World of Warlords");
        System.out.println("Here you can create your character: ");

        System.out.print("Name: ");
        String name = userInput.nextLine();

        System.out.println("Race (human or orc): ");
        while (!userInput.hasNext("human") && !userInput.hasNext("orc")) {
            System.err.println("Invalid input, you need to type in human or orc");
            userInput.nextLine();
        }

        String race = userInput.nextLine();

        System.out.println("Difficulty (0 - easy, 1 - medium, 2- hard): ");
        while (!userInput.hasNextByte(3)) {
            System.err.println("Invalid input, you need to type in 0 or 1 or 2");
            userInput.nextLine();
        }

        byte difficulty = userInput.nextByte();

        System.out.println("Nightmare mode is on (true or false): ");
        while (!userInput.hasNextBoolean()) {
            System.err.println("Invalid input, you need to type in true or false");
            userInput.nextLine();
        }

        boolean isNightmareModeOn = userInput.nextBoolean();

        System.out.println("----------------------------------------------------------");
        System.out.println("Your character is created: ");
        System.out.printf("Name: %s%n", name);
        System.out.printf("Race: %s%n", race);
        System.out.printf("Difficulty: %d%n", difficulty);
        System.out.printf("Nightmare mode is on: %b%n", isNightmareModeOn);
    }
}
