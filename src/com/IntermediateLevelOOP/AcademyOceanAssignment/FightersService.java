package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.*;

public class FightersService {

    private static final Random RANDOM_NUMBER_GENERATOR = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);

    private static int INPUT_NUMBER;
    private static int ROUNDS;

    protected static String location;

    public static void gameLoop() {
        getInput();
    }

    private static void getInput() {
        int input = 0;

        printMenu();
        while (true) {
            System.out.println("(Number must be even and between 4 and 256)");
            System.out.println("Please enter a number for the participants:");
            try {
                input = SCANNER.nextInt();
                INPUT_NUMBER = input;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input");
            }
            SCANNER.nextLine();

            if (input >= 4 && input <= 256 && input % 2 == 0) {
                printMenu();
                battle();
                break;
            } else {
                System.out.println("Wrong number");
                printMenu();
            }
        }
    }

    private static void battle() {

        List<Hero> heroes = generateHeroes();
        printStartingHeroes(heroes);

        while (heroes.size() > 1) {

            List<Hero> lastTwoStanding = new ArrayList<>();

            for (int i = 0; i < heroes.size(); i += 2) {
                isFinal(heroes);
                Hero firstHero = heroes.get(i);
                Hero secondHero = heroes.get(i + 1);
                Hero winner = getHeroWinner(firstHero, secondHero);
                lastTwoStanding.add(winner);
            }

            resetHeroStats(lastTwoStanding);
            heroes = lastTwoStanding;
        }

        System.out.println("THE LAST HERO REMAINING IS THE " + "'" + heroes.get(0).getClassName() + "'");

    }

    private static void printMenu() {
        printSeparator();
        System.out.println("\tWelcome to Heroes Fighting App");
        printSeparator();
    }

    private static void printSeparator() {
        for (int i = 0; i < 37; i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    private static void printStartingHeroes(List<Hero> heroes) {
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }

    private static Hero getHeroWinner(Hero firstHero, Hero secondHero) {
        location = getRandomLocation();
        isKnightLocation(location, firstHero, secondHero);

        while (true) {

            if (firstHero.healthPoints <= 0) {
                isHeroDead(firstHero);
                return secondHero;
            } else if (secondHero.healthPoints <= 0) {
                isHeroDead(secondHero);
                return firstHero;
            }

            int damage = firstHero.attack() - secondHero.defend();
            int damageTook = secondHero.attack() - firstHero.defend();
            isWarriorHealed(location, firstHero, secondHero, damage, damageTook);

            if (damage < 0) {
                damage = 0;
            }

            if (damageTook < 0) {
                damageTook = 0;
            }

            firstHero.healthPoints -= damageTook;
            secondHero.healthPoints -= damage;

            if (firstHero.healthPoints <= 0) {
                firstHero.healthPoints = 0;
            }

            if (secondHero.healthPoints <= 0) {
                secondHero.healthPoints = 0;
            }

            printSeparator();
            System.out.println("The heroes fighting location: " + location);

            printSeparator();
            System.out.println("\t\t\t\tBATTLE");
            printSeparator();
            System.out.println(firstHero.getClassName() + " dealt " + damage + " damage to the " + secondHero.getClassName());
            System.out.println(firstHero.getClassName() + " has " + firstHero.healthPoints + " health points left");

            System.out.println(secondHero.getClassName() + " dealt " + damageTook + " damage to the " + firstHero.getClassName());
            System.out.println(secondHero.getClassName() + " has " + secondHero.healthPoints + " health points left");
        }
    }

    private static void isKnightLocation(String location, Hero firstHero, Hero secondHero) {
        if ("Castle".equals(location) && "Knight".equals(firstHero.getClassName())) {
            firstHero.setHealthPoints(firstHero.getMaxHealthPoints() + firstHero.getMaxHealthPoints() / 10);
            firstHero.setArmorPoints(firstHero.getMaxArmorPoints() + firstHero.getMaxArmorPoints() / 10);
        }
        if ("Castle".equals(location) && "Knight".equals(secondHero.getClassName())) {
            secondHero.setHealthPoints(secondHero.getMaxHealthPoints() + secondHero.getMaxHealthPoints() / 10);
            secondHero.setArmorPoints(secondHero.getMaxArmorPoints() + secondHero.getMaxArmorPoints() / 10);
        }
    }

    private static void isWarriorHealed(String location, Hero firstHero, Hero secondHero, int damage, int damageTook) {
        if ((Warrior.isBattlefieldLocation(location) && "Warrior".equals(firstHero.getClassName()))) {
            firstHero.setHealthPoints(firstHero.getHealthPoints() + (int) (damage * 0.05));
        }

        if ((Warrior.isBattlefieldLocation(location) && "Warrior".equals(secondHero.getClassName()))) {
            secondHero.setHealthPoints(secondHero.getHealthPoints() + (int) (damageTook * 0.05));
        }
    }

    private static void isFinal(List<Hero> heroes) {
        if (heroes.size() == 2) {
            System.out.println("\t\t\t   LAST MATCH");
        }
    }

    private static void resetHeroStats(List<Hero> heroes) {
        for (Hero hero : heroes) {
            hero.healthPoints = hero.getMaxHealthPoints();
            hero.attackPoints = hero.getMaxAttackPoints();
            hero.armorPoints = hero.getMaxArmorPoints();
        }
    }

    private static void isHeroDead(Hero hero) {
        System.out.println();
        System.out.println(hero.getClassName() + " died...");
        System.out.println();
    }

    private static List<Hero> generateHeroes() {
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < INPUT_NUMBER; i++) {
            heroes.add(getRandomHero());
        }

        return heroes;
    }

    private static Hero getRandomHero() {
        return getHeroes().get(RANDOM_NUMBER_GENERATOR.nextInt(getHeroes().size()));
    }

    private static List<Hero> getHeroes() {
        return new ArrayList<>(List.of(new Warrior(), new Knight(), new Assassin()
                , new Monk()));
    }

    protected static String getRandomLocation() {
        return getLocations().get(RANDOM_NUMBER_GENERATOR.nextInt(getLocations().size()));
    }

    private static ArrayList<String> getLocations() {
        return new ArrayList<>(Locations.getLocations());
    }
}
