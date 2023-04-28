package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.*;

public class FightersService {

    protected static final Random RANDOM_NUMBER_GENERATOR = new Random();
    protected static final Scanner SCANNER = new Scanner(System.in);
    private static boolean IS_RUNNING = true;

    private static final Warrior WARRIOR = new Warrior();
    private static final Knight KNIGHT = new Knight();
    private static final Assassin ASSASSIN = new Assassin();
    private static final Monk MONK = new Monk();

    private static Hero FIRST_HERO = getRandomHero();
    private static Hero SECOND_HERO = getRandomHero();

    public static void gameLoop() {

        int input = 0;

        printMenu();
        while (IS_RUNNING) {
            System.out.println("Please make your choice");
            try {
                input = 0;
                input = SCANNER.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input");
            }
            SCANNER.nextLine();

            if (input == 0) {
                printMenu();
            } else if (input == 1) {
                printHeroesInfo();
            } else if (input == 2) {
                battle();
            } else if (input == 3) {
                IS_RUNNING = false;
            }
        }
    }

    private static void battle() {

        while (true) {

            if (FIRST_HERO.HEALTH_POINTS <= 0) {
                System.out.println();
                System.out.println(FIRST_HERO.getClassName() + " died...");
                System.out.println();
                FIRST_HERO = getRandomHero();
                printMenu();
                break;
            } else if (SECOND_HERO.HEALTH_POINTS <= 0) {
                System.out.println();
                System.out.println(SECOND_HERO.getClassName() + " died...");
                System.out.println();
                SECOND_HERO = getRandomHero();
                printMenu();
                break;
            }

            int damage = FIRST_HERO.attack() - SECOND_HERO.defend();
            int damageTook = SECOND_HERO.attack() - FIRST_HERO.defend();

            if (damage < 0) {
                damage = 0;
            }

            if (damageTook < 0) {
                damageTook = 0;
            }

            FIRST_HERO.HEALTH_POINTS -= damageTook;
            SECOND_HERO.HEALTH_POINTS -= damage;

            if (FIRST_HERO.HEALTH_POINTS <= 0) {
                FIRST_HERO.HEALTH_POINTS = 0;
            }

            if (SECOND_HERO.HEALTH_POINTS <= 0) {
                SECOND_HERO.HEALTH_POINTS = 0;
            }

            printSeparator();
            System.out.println("\t\t\t\tBATTLE");
            printSeparator();
            System.out.println(FIRST_HERO.getClassName() + " dealt " + damage + " damage to the " + SECOND_HERO.getClassName());
            System.out.println(FIRST_HERO.getClassName() + " has " + FIRST_HERO.HEALTH_POINTS + " health points left");

            System.out.println(SECOND_HERO.getClassName() + " dealt " + damageTook + " damage to the " + FIRST_HERO.getClassName());
            System.out.println(SECOND_HERO.getClassName() + " has " + SECOND_HERO.HEALTH_POINTS + " health points left");
        }
    }

    private static void printMenu() {
        printSeparator();
        System.out.println("\tWelcome to Heroes Fighting App");
        printSeparator();
        System.out.println("\t0 - Print menu");
        System.out.println("\t1 - Print Fight Heroes info");
        System.out.println("\t2 - To attack each other");
        System.out.println("\t3 - To quit the game");
    }

    private static void randomHeroValidation() {
        if (FIRST_HERO.getClassName().equals(SECOND_HERO.getClassName())) {
            FIRST_HERO = getRandomHero();
            SECOND_HERO = getRandomHero();
        }
    }


    private static void printHeroesInfo() {
        randomHeroValidation();
        System.out.println(FIRST_HERO.toString());
        System.out.println(FIRST_HERO.getQuote());
        printSeparator();
        System.out.println(SECOND_HERO.toString());
        System.out.println(SECOND_HERO.getQuote());
        System.out.println();
    }

    private static void printSeparator() {
        for (int i = 0; i < 37; i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    private static Hero getRandomHero() {
        return getHeroes().get(RANDOM_NUMBER_GENERATOR.nextInt(getHeroes().size()));
    }

    private static List<Hero> getHeroes() {
        return new ArrayList<>(List.of(WARRIOR, KNIGHT, ASSASSIN, MONK));
    }
}
