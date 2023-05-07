package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.*;

public class FightersService {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static int INPUT_NUMBER;
    protected static Locations location;

    private static final FinalStatistics finalStatistics = new FinalStatistics();
    private static final HeroesService heroesService = new HeroesService();
    private static List<Hero> heroes = new ArrayList<>();
    private static final OutputMessages outputMessages = new OutputMessages();

    public static void gameLoop() {
        int input = 0;

        outputMessages.printMenu();
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
                outputMessages.printMenu();
                battle();
                break;
            } else {
                System.out.println("Wrong number");
                outputMessages.printMenu();
            }
        }
    }

    private static void battle() {

        heroes = heroesService.generateHeroes(INPUT_NUMBER);
        heroesService.generateHeroStoreMap(heroes);

        outputMessages.printStartingHeroes(heroes);

        while (heroes.size() > 1) {

            List<Hero> lastOneStanding = new ArrayList<>();

            for (int i = 0; i < heroes.size(); i += 2) {
                heroesService.isFinal(heroes);
                finalStatistics.setRounds(finalStatistics.getRounds() + 1);
                Hero firstHero = heroes.get(i);
                Hero secondHero = heroes.get(i + 1);
                Hero winner = getHeroWinner(firstHero, secondHero);
                heroesService.putFirstHeroIDFightsMap(firstHero, heroes);
                heroesService.putSecondHeroIDFightsMap(secondHero, heroes);
                lastOneStanding.add(winner);
            }

            heroesService.resetHeroStats(lastOneStanding);
            heroes = lastOneStanding;
        }

        heroesService.generateLosers();
        System.out.println("THE LAST HERO REMAINING IS THE " + "'" + heroes.get(0).getClassName() + "'");
        outputMessages.printSeparator();
        printFinalInfo();
    }

    private static Hero getHeroWinner(Hero firstHero, Hero secondHero) {

        location = Locations.getRandomLocation();
        Knight.isKnightLocation(location, firstHero, secondHero);

        finalStatistics.setFirstHeroDamageValue(0);
        heroesService.checkFirstHeroDamageValue(firstHero);

        finalStatistics.setFirstHeroBattle(0);
        heroesService.checkFirstHeroBattles(firstHero);

        finalStatistics.setFirstHeroFights(0);
        heroesService.checkFirstHeroFights(firstHero);

        finalStatistics.setFirstHeroHighestDamageValue(0);
        heroesService.checkFirstHeroHighestDamageValue(firstHero);

        finalStatistics.setFirstHeroHighestNumberOfSuccessfulAttackDodges(0);
        heroesService.checkFirstHeroHighestNumberOfSuccessfulAttackDodges(firstHero);

        finalStatistics.setSecondHeroDamageValue(0);
        heroesService.checkSecondHeroDamageValue(secondHero);

        finalStatistics.setSecondHeroBattle(0);
        heroesService.checkSecondHeroBattles(secondHero);

        finalStatistics.setSecondHeroFights(0);
        heroesService.checkSecondHeroFights(secondHero);

        finalStatistics.setSecondHeroHighestDamageValue(0);
        heroesService.checkSecondHeroHighestDamageValue(secondHero);

        finalStatistics.setSecondHeroHighestNumberOfSuccessfulAttackDodges(0);
        heroesService.checkSecondHeroHighestNumberOfSuccessfulAttackDodges(secondHero);

        while (true) {

            if (secondHero.getHealthPoints() <= 0) {
                secondHero.isHeroDead();
                return firstHero;
            } else if (firstHero.getHealthPoints() <= 0) {
                firstHero.isHeroDead();
                return secondHero;
            }

            int damage = firstHero.getHeroDamage();
            heroesService.putFirstHeroIDDamageBattlesMap(firstHero, heroes, damage);
            heroesService.putFirstHeroIDHighestDamageMap(firstHero, heroes, damage);
            heroesService.putFirstHeroHighestNumberOfSuccessfulAttackDodges(secondHero, heroes, damage);

            int damageTook = secondHero.getHeroDamage();
            heroesService.putSecondHeroIDDamageBattleMap(secondHero, heroes, damageTook);
            heroesService.putSecondHeroIDHighestDamageMap(secondHero, heroes, damageTook);
            heroesService.putSecondHeroHighestNumberOfSuccessfulAttackDodges(firstHero, heroes, damageTook);

            Warrior.isWarriorHealed(location, firstHero, secondHero, damage, damageTook);

            firstHero.setHealthPoints(firstHero.getHealthPoints() - damageTook);
            secondHero.setHealthPoints(secondHero.getHealthPoints() - damage);

            firstHero.checkHeroHealthPoints();
            secondHero.checkHeroHealthPoints();
            printBattleInfo(firstHero, secondHero, damage, damageTook);
        }
    }

    // PRINT BATTLE INFO
    private static void printBattleInfo(Hero firstHero, Hero secondHero, int damage, int damageTook) {
        outputMessages.printSeparator();
        System.out.println("The heroes fighting location: " + location);
        outputMessages.printSeparator();

        System.out.println("\t\t\t\tBATTLE");
        outputMessages.printSeparator();
        System.out.println("ID = " + firstHero.getId() + " " + firstHero.getClassName() + " dealt " + damage + " damage to the " + secondHero.getClassName());
        System.out.println("ID = " + firstHero.getId() + " " + firstHero.getClassName() + " has " + firstHero.getHealthPoints() + " health points left");

        System.out.println("ID = " + secondHero.getId() + " " + secondHero.getClassName() + " dealt " + damageTook + " damage to the " + firstHero.getClassName());
        System.out.println("ID = " + secondHero.getId() + " " + secondHero.getClassName() + " has " + secondHero.getHealthPoints() + " health points left");
    }

    private static void printFinalInfo() {
        heroesService.printTwoFinalistsStats();
        outputMessages.printSeparator();
        System.out.println("\t\t\t\t\t\tROUNDS = " + finalStatistics.getRounds());
        heroesService.printFinalistsIDBattleInfo();
        System.out.println();
        heroesService.printFinalistsIDFightsInfo();
        System.out.println();
        heroesService.printFinalistsIDDamageInfo();
        System.out.println();
        outputMessages.printSeparator();
        System.out.println("\t\t\t\t\tHONORABLE MENTIONS");
        heroesService.printTopTwoLosersHighestDamageValueInfo();
        heroesService.printTopTwoLosersHighestNumberOfSuccessfulAttackDodgesInfo();
    }
}