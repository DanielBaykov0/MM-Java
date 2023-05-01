package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.*;

public class FightersService {

    private static final Random RANDOM_NUMBER_GENERATOR = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);

    private static int INPUT_NUMBER;
    protected static String location;

    private static final FinalStatistics finalStatistics = new FinalStatistics();

    private static HashMap<Integer, Hero> heroHashMap = new HashMap<>();
    private static HashMap<Integer, Integer> hashMap = new HashMap<>();

    private static Map<String, Integer> map = new HashMap<>();


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

            int n = input;
            while (n % 2 != 1) {
                n /= 2;
            }

            if (input >= 4 && input <= 256 && n == 1) {
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
        for (Hero hero : heroes) {
            heroHashMap.put(hero.getId(), hero);
        }

        printStartingHeroes(heroes);

        while (heroes.size() > 1) {

            List<Hero> lastTwoStanding = new ArrayList<>();

            for (int i = 0; i < heroes.size(); i += 2) {
                isFinal(heroes);
                finalStatistics.setRounds(finalStatistics.getRounds() + 1);
                Hero firstHero = heroes.get(i);
                System.out.println("First hero id = " + firstHero.getId() + " hero: " + firstHero.getClassName());
                Hero secondHero = heroes.get(i + 1);
                System.out.println("Second hero id = " + secondHero.getId() + " hero: " + secondHero.getClassName());
                Hero winner = getHeroWinner(firstHero, secondHero);
                lastTwoStanding.add(winner);
            }

            resetHeroStats(lastTwoStanding);
            heroes = lastTwoStanding;
        }

        System.out.println("THE LAST HERO REMAINING IS THE " + "'" + heroes.get(0).getClassName() + "'");
        System.out.println("ROUNDS = " + finalStatistics.getRounds());
        System.out.println("Number of all battles = " + finalStatistics.getNumberOfAllBattles());
        printSeparator();
        System.out.println("First hero fights = " + finalStatistics.getFirstHeroFights());
        System.out.println("Second hero fights = " + finalStatistics.getSecondHeroFights());
        printSeparator();
        finalStatistics.printHighestDamageOutput(map);
        printSeparator();
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

            if (secondHero.healthPoints <= 0) {
                isHeroDead(secondHero);
                finalStatistics.setSecondHeroFights(finalStatistics.getSecondHeroFights() + 1);
                return firstHero;
            } else if (firstHero.healthPoints <= 0) {
                isHeroDead(firstHero);
                finalStatistics.setFirstHeroFights(finalStatistics.getFirstHeroFights() + 1);
                return secondHero;
            }

            int damage = firstHeroDamage(firstHero, secondHero);
            int damageTook = secondHeroDamage(firstHero, secondHero);
            isWarriorHealed(location, firstHero, secondHero, damage, damageTook);

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
            System.out.println("\t\t" + firstHero.getClassName() + " dealt " + damage + " damage to the " + secondHero.getClassName());
            System.out.println(firstHero.getClassName() + " has " + firstHero.healthPoints + " health points left");
            System.out.println("\t\tFirst Hero ID = " + firstHero.getId() + " " + firstHero.getClassName());
            System.out.println("\t\tFirst hero damage sum = " + finalStatistics.getFirstHeroDamageSum());
            finalStatistics.setNumberOfAllBattles(finalStatistics.getNumberOfAllBattles() + 1);

            System.out.println(secondHero.getClassName() + " dealt " + damageTook + " damage to the " + firstHero.getClassName());
            System.out.println(secondHero.getClassName() + " has " + secondHero.healthPoints + " health points left");
            System.out.println("\t\tSecond Hero ID = " + secondHero.getId() + " " + secondHero.getClassName());
            System.out.println("\t\tSecond hero damage sum = " + finalStatistics.getSecondHeroDamageSum());
        }
    }

    private static int firstHeroDamage(Hero firstHero, Hero secondHero) {
        int damage = firstHero.attack() - secondHero.defend();
        if (damage < 0) {
            damage = 0;
        }

        return damage;
    }

    private static int secondHeroDamage(Hero firstHero, Hero secondHero) {
        int damageTook = secondHero.attack() - firstHero.defend();
        if (damageTook < 0) {
            damageTook = 0;
        }

        return damageTook;
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
            heroes.add(getRandomHero(i));
        }

        return heroes;
    }

    private static Hero getRandomHero(int id) {
        return getHeroes(id).get(RANDOM_NUMBER_GENERATOR.nextInt(getHeroes(id).size()));
    }

    private static List<Hero> getHeroes(int id) {
        return new ArrayList<>(List.of(new Warrior(id), new Knight(id), new Assassin(id)
                , new Monk(id)));
    }

    protected static String getRandomLocation() {
        return getLocations().get(RANDOM_NUMBER_GENERATOR.nextInt(getLocations().size()));
    }

    private static ArrayList<String> getLocations() {
        return new ArrayList<>(Locations.getLocations());
    }
}
