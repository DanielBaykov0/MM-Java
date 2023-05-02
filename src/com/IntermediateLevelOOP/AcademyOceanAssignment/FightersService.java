package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.*;

public class FightersService {

    private static final Random RANDOM_NUMBER_GENERATOR = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);

    private static int INPUT_NUMBER;
    protected static String location;

    private static final FinalStatistics finalStatistics = new FinalStatistics();
    private static List<Hero> heroes = new ArrayList<>();

    public static void gameLoop() {
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

        heroes = generateHeroes();
        generateHeroStoreMap();

        printStartingHeroes(heroes);

        while (heroes.size() > 1) {

            List<Hero> lastOneStanding = new ArrayList<>();

            for (int i = 0; i < heroes.size(); i += 2) {
                isFinal(heroes);
                finalStatistics.setRounds(finalStatistics.getRounds() + 1);
                Hero firstHero = heroes.get(i);
                Hero secondHero = heroes.get(i + 1);
                Hero winner = getHeroWinner(firstHero, secondHero);
                lastOneStanding.add(winner);
            }

            resetHeroStats(lastOneStanding);
            heroes = lastOneStanding;
        }

        generateLosers();
        System.out.println("THE LAST HERO REMAINING IS THE " + "'" + heroes.get(0).getClassName() + "'");
        printSeparator();
        printFinalInfo();
    }

    private static Hero getHeroWinner(Hero firstHero, Hero secondHero) {
        location = getRandomLocation();
        isKnightLocation(location, firstHero, secondHero);

        finalStatistics.setFirstHeroDamageValue(0);
        checkFirstHeroDamageValue(firstHero);

        finalStatistics.setFirstHeroBattle(0);
        checkFirstHeroBattles(firstHero);

        finalStatistics.setFirstHeroFights(0);
        checkFirstHeroFights(firstHero);

        finalStatistics.setFirstHeroHighestDamageValue(0);
        checkFirstHeroHighestDamageValue(firstHero);

        finalStatistics.setFirstHeroHighestNumberOfSuccessfulAttackDodges(0);
        checkFirstHeroHighestNumberOfSuccessfulAttackDodges(firstHero);

        finalStatistics.setSecondHeroDamageValue(0);
        checkSecondHeroDamageValue(secondHero);

        finalStatistics.setSecondHeroBattle(0);
        checkSecondHeroBattles(secondHero);

        finalStatistics.setSecondHeroFights(0);
        checkSecondHeroFights(secondHero);

        finalStatistics.setSecondHeroHighestDamageValue(0);
        checkSecondHeroHighestDamageValue(secondHero);

        finalStatistics.setSecondHeroHighestNumberOfSuccessfulAttackDodges(0);
        checkSecondHeroHighestNumberOfSuccessfulAttackDodges(secondHero);

        while (true) {

            if (secondHero.healthPoints <= 0) {
                isHeroDead(secondHero);
                putFirstHeroIDFightsMap(firstHero);
                return firstHero;
            } else if (firstHero.healthPoints <= 0) {
                isHeroDead(firstHero);
                putSecondHeroIDFightsMap(secondHero);
                return secondHero;
            }

            int damage = firstHeroDamage(firstHero, secondHero);
            putFirstHeroIDDamageBattlesMap(firstHero, damage);
            putFirstHeroIDHighestDamageMap(firstHero, damage);
            putFirstHeroHighestNumberOfSuccessfulAttackDodges(secondHero, damage);

            int damageTook = secondHeroDamage(firstHero, secondHero);
            putSecondHeroIDDamageBattleMap(secondHero, damageTook);
            putSecondHeroIDHighestDamageMap(secondHero, damageTook);
            putSecondHeroHighestNumberOfSuccessfulAttackDodges(firstHero, damageTook);

            isWarriorHealed(location, firstHero, secondHero, damage, damageTook);

            firstHero.healthPoints -= damageTook;
            secondHero.healthPoints -= damage;

            checkBothHeroesHealthPoints(firstHero, secondHero);
            printBattleInfo(firstHero, secondHero, damage, damageTook);
        }
    }

    private static void checkFirstHeroDamageValue(Hero firstHero) {
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDDamageMap.entrySet()) {
            if (entry.getKey().equals(firstHero.getId())) {
                finalStatistics.setFirstHeroDamageValue(entry.getValue());
            }
        }
    }

    private static void checkFirstHeroHighestDamageValue(Hero firstHero) {
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDHighestDamageMap.entrySet()) {
            if (entry.getKey().equals(firstHero.getId())) {
                finalStatistics.setFirstHeroHighestDamageValue(entry.getValue());
            }
        }
    }

    private static void checkFirstHeroHighestNumberOfSuccessfulAttackDodges(Hero firstHero) {
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDHighestNumberOfSuccessfulAttackDodgesMap.entrySet()) {
            if (entry.getKey().equals(firstHero.getId())) {
                finalStatistics.setFirstHeroHighestNumberOfSuccessfulAttackDodges(entry.getValue());
            }
        }
    }

    private static void checkFirstHeroBattles(Hero firstHero) {
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDBattlesMap.entrySet()) {
            if (entry.getKey().equals(firstHero.getId())) {
                finalStatistics.setFirstHeroBattle(entry.getValue());
            }
        }
    }

    private static void checkFirstHeroFights(Hero firstHero) {
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDFightsMap.entrySet()) {
            if (entry.getKey().equals(firstHero.getId())) {
                finalStatistics.setFirstHeroFights(entry.getValue());
            }
        }
    }

    private static int firstHeroDamage(Hero firstHero, Hero secondHero) {
        int damage = firstHero.attack() - secondHero.defend();
        if (damage < 0) {
            damage = 0;
        }

        return damage;
    }

    private static void checkSecondHeroBattles(Hero secondHero) {
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDBattlesMap.entrySet()) {
            if (entry.getKey().equals(secondHero.getId())) {
                finalStatistics.setSecondHeroBattle(entry.getValue());
            }
        }
    }

    private static void checkSecondHeroHighestDamageValue(Hero secondHero) {
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDHighestDamageMap.entrySet()) {
            if (entry.getKey().equals(secondHero.getId())) {
                finalStatistics.setSecondHeroHighestDamageValue(entry.getValue());
            }
        }
    }

    private static void checkSecondHeroHighestNumberOfSuccessfulAttackDodges(Hero secondHero) {
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDHighestNumberOfSuccessfulAttackDodgesMap.entrySet()) {
            if (entry.getKey().equals(secondHero.getId())) {
                finalStatistics.setSecondHeroHighestNumberOfSuccessfulAttackDodges(entry.getValue());
            }
        }
    }

    private static void checkSecondHeroDamageValue(Hero secondHero) {
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDDamageMap.entrySet()) {
            if (entry.getKey().equals(secondHero.getId())) {
                finalStatistics.setSecondHeroDamageValue(entry.getValue());
            }
        }
    }

    private static void checkSecondHeroFights(Hero secondHero) {
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDFightsMap.entrySet()) {
            if (entry.getKey().equals(secondHero.getId())) {
                finalStatistics.setSecondHeroFights(entry.getValue());
            }
        }
    }

    private static int secondHeroDamage(Hero firstHero, Hero secondHero) {
        int damageTook = secondHero.attack() - firstHero.defend();
        if (damageTook < 0) {
            damageTook = 0;
        }

        return damageTook;
    }

    private static void putFirstHeroIDFightsMap(Hero firstHero) {
        for (Hero hero : heroes) {
            if (hero.getId() == firstHero.getId()) {
                FinalStatistics.heroesIDFightsMap.put(hero.getId(), finalStatistics.setFirstHeroFights(finalStatistics.getFirstHeroFights() + 1));
            }
        }
    }

    private static void putFirstHeroIDHighestDamageMap(Hero firstHero, int damage) {
        for (Hero hero : heroes) {
            if (hero.getId() == firstHero.getId() && damage > finalStatistics.getFirstHeroHighestDamageValue()) {
                FinalStatistics.heroesIDHighestDamageMap.put(hero.getId(), finalStatistics.setFirstHeroHighestDamageValue(damage));
            }
        }
    }

    private static void putFirstHeroHighestNumberOfSuccessfulAttackDodges(Hero secondHero, int damage) {
        for (Hero hero : heroes) {
            if (hero.getId() == secondHero.getId() && damage == 0) {
                FinalStatistics.heroesIDHighestNumberOfSuccessfulAttackDodgesMap
                        .put(hero.getId(),
                                finalStatistics.setSecondHeroHighestNumberOfSuccessfulAttackDodges(1 + finalStatistics.getSecondHeroHighestNumberOfSuccessfulAttackDodges()));
            }
        }
    }

    private static void putFirstHeroIDDamageBattlesMap(Hero firstHero, int damage) {
        for (Hero hero : heroes) {
            if (hero.getId() == firstHero.getId()) {
                FinalStatistics.heroesIDDamageMap.put(hero.getId(), finalStatistics.setFirstHeroDamageValue(finalStatistics.getFirstHeroDamageValue() + damage));
                FinalStatistics.heroesIDBattlesMap.put(hero.getId(), finalStatistics.setFirstHeroBattle(1 + finalStatistics.getFirstHeroBattle()));
            }
        }
    }

    private static void putSecondHeroIDFightsMap(Hero secondHero) {
        for (Hero hero : heroes) {
            if (hero.getId() == secondHero.getId()) {
                FinalStatistics.heroesIDFightsMap.put(hero.getId(), finalStatistics.setSecondHeroFights(finalStatistics.getSecondHeroFights() + 1));
            }
        }
    }

    private static void putSecondHeroIDHighestDamageMap(Hero secondHero, int damageTook) {
        for (Hero hero : heroes) {
            if (hero.getId() == secondHero.getId() && damageTook > finalStatistics.getSecondHeroHighestDamageValue()) {
                FinalStatistics.heroesIDHighestDamageMap.put(hero.getId(), finalStatistics.setSecondHeroHighestDamageValue(damageTook));
            }
        }
    }

    private static void putSecondHeroHighestNumberOfSuccessfulAttackDodges(Hero firstHero, int damageTook) {
        for (Hero hero : heroes) {
            if (hero.getId() == firstHero.getId() && damageTook == 0) {
                FinalStatistics.heroesIDHighestNumberOfSuccessfulAttackDodgesMap
                        .put(hero.getId(),
                                finalStatistics.setFirstHeroHighestNumberOfSuccessfulAttackDodges(1 + finalStatistics.getFirstHeroHighestNumberOfSuccessfulAttackDodges()));
            }
        }
    }

    private static void putSecondHeroIDDamageBattleMap(Hero secondHero, int damageTook) {
        for (Hero hero : heroes) {
            if (hero.getId() == secondHero.getId()) {
                FinalStatistics.heroesIDDamageMap.put(hero.getId(), finalStatistics.setSecondHeroDamageValue(finalStatistics.getSecondHeroDamageValue() + damageTook));
                FinalStatistics.heroesIDBattlesMap.put(hero.getId(), finalStatistics.setSecondHeroBattle(1 + finalStatistics.getSecondHeroBattle()));
            }
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
            FinalStatistics.finalTwoStanding = heroes;
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

    private static void checkBothHeroesHealthPoints(Hero firstHero, Hero secondHero) {
        if (firstHero.healthPoints <= 0) {
            firstHero.healthPoints = 0;
        }

        if (secondHero.healthPoints <= 0) {
            secondHero.healthPoints = 0;
        }
    }

    private static void isHeroDead(Hero hero) {
        System.out.println();
        System.out.println(hero.getClassName() + " died...");
        System.out.println();
    }

    private static void generateLosers() {
        for (Hero hero : FinalStatistics.heroesHashMapStore.values()) {
            if (!FinalStatistics.finalTwoStanding.contains(hero)) {
                FinalStatistics.losers.add(hero);

            }
        }
    }

    private static void generateHeroStoreMap() {
        for (Hero hero : heroes) {
            FinalStatistics.heroesHashMapStore.put(hero.getId(), hero);
        }
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

    private static void printMenu() {
        printSeparator();
        System.out.println("\tWelcome to Heroes Fighting App");
        printSeparator();
    }

    private static void printSeparator() {
        for (int i = 0; i < 45; i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    private static void printStartingHeroes(List<Hero> heroes) {
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }

    private static void printTwoFinalistsStats() {
        System.out.println("\t\t\t\t\t\tTWO FINALISTS INFO");
        for (Hero hero : FinalStatistics.finalTwoStanding) {
            resetHeroStats(FinalStatistics.finalTwoStanding);
            System.out.println(hero);
        }
    }

    // not used at the moment
    private static void printAllHeroesIDDamageInfo() {
        printSeparator();
        System.out.println("\t\tDAMAGE SUMMARY");
        printSeparator();
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDDamageMap.entrySet()) {
            for (Map.Entry<Integer, Hero> heroId : FinalStatistics.heroesHashMapStore.entrySet()) {
                if (heroId.getKey().equals(entry.getKey())) {
                    System.out.print("ID = " + entry.getKey() + " Hero " + heroId.getValue().getClassName() + " Damage = " + entry.getValue());
                }
            }
            System.out.println();
        }
    }

    // not used at the moment
    private static void printAllHeroesIDBattlesInfo() {
        printSeparator();
        System.out.println("\t\tBATTLES SUMMARY");
        printSeparator();
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDBattlesMap.entrySet()) {
            for (Map.Entry<Integer, Hero> heroId : FinalStatistics.heroesHashMapStore.entrySet()) {
                if (heroId.getKey().equals(entry.getKey())) {
                    System.out.print("ID = " + entry.getKey() + " Hero " + heroId.getValue().getClassName() + " Battles = " + entry.getValue());
                }
            }
            System.out.println();
        }
    }

    // not used at the moment
    private static void printAllHeroesIDHighestDamageValueInfo() {
        printSeparator();
        System.out.println("\t\tHIGHEST DAMAGE VALUE SUMMARY");
        printSeparator();
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDHighestDamageMap.entrySet()) {
            for (Map.Entry<Integer, Hero> heroId : FinalStatistics.heroesHashMapStore.entrySet()) {
                if (heroId.getKey().equals(entry.getKey())) {
                    System.out.print("ID = " + entry.getKey() + " Hero " + heroId.getValue().getClassName() + " Battles = " + entry.getValue());
                }
            }
            System.out.println();
        }
    }

    // not used at the moment
    private static void printAllHeroesIDHighestNumberOfSuccessfulAttackDodgesInfo() {
        printSeparator();
        System.out.println("\t\tHIGHEST DAMAGE VALUE SUMMARY");
        printSeparator();
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDHighestNumberOfSuccessfulAttackDodgesMap.entrySet()) {
            for (Map.Entry<Integer, Hero> heroId : FinalStatistics.heroesHashMapStore.entrySet()) {
                if (heroId.getKey().equals(entry.getKey())) {
                    System.out.print("ID = " + entry.getKey() + " Hero " + heroId.getValue().getClassName() + " Highest Number of Successful Dodges = " + entry.getValue());
                }
            }
            System.out.println();
        }
    }

    private static void printFinalistsIDDamageInfo() {
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDDamageMap.entrySet()) {
            for (Hero hero : FinalStatistics.finalTwoStanding) {
                if (entry.getKey().equals(hero.getId())) {
                    FinalStatistics.finalistsIDDamageMap.put(entry.getKey(), entry.getValue());
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : FinalStatistics.finalistsIDDamageMap.entrySet()) {
            System.out.print("\t\tID = " + entry.getKey() + " Damage = " + entry.getValue());
        }
    }

    private static void printTopTwoLosersHighestDamageValueInfo() {
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDHighestDamageMap.entrySet()) {
            FinalStatistics.topTwoLosersHighestDamageValue.add(entry.getValue());
            if (FinalStatistics.topTwoLosersHighestDamageValue.size() > 2) {
                FinalStatistics.topTwoLosersHighestDamageValue.poll();
            }
        }

        for (Integer integer : FinalStatistics.topTwoLosersHighestDamageValue) {
            System.out.println("\t\t Highest Damage Value = " + integer);
        }
    }

    // not used at the moment
    private static void printLosersIDHighestDamageValueInfo() {
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDHighestDamageMap.entrySet()) {
            for (Hero hero : FinalStatistics.losers) {
                if (entry.getKey().equals(hero.getId())) {
                    FinalStatistics.losersHighestDamageValue.put(entry.getKey(), entry.getValue());
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : FinalStatistics.losersHighestDamageValue.entrySet()) {
            System.out.println("\t\tID = " + entry.getKey() + " Highest Damage Value = " + entry.getValue());
        }
    }

    private static void printTopTwoLosersHighestNumberOfSuccessfulAttackDodgesInfo() {
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDHighestNumberOfSuccessfulAttackDodgesMap.entrySet()) {
            FinalStatistics.topTwoLosersHighestNumberOfSuccessfulAttackDodges.add(entry.getValue());
            if (FinalStatistics.topTwoLosersHighestNumberOfSuccessfulAttackDodges.size() > 2) {
                FinalStatistics.topTwoLosersHighestNumberOfSuccessfulAttackDodges.poll();
            }
        }

        for (Integer integer : FinalStatistics.topTwoLosersHighestNumberOfSuccessfulAttackDodges) {
            System.out.println("\t\t Highest Number of Successful Dodges = " + integer);
        }
    }

    // not used at the moment
    private static void printLosersIDHighestNumberOfSuccessfulAttackDodgesInfo() {
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDHighestNumberOfSuccessfulAttackDodgesMap.entrySet()) {
            for (Hero hero : FinalStatistics.losers) {
                if (entry.getKey().equals(hero.getId())) {
                    FinalStatistics.losersHighestNumberOfSuccessfulAttackDodges.put(entry.getKey(), entry.getValue());
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : FinalStatistics.losersHighestNumberOfSuccessfulAttackDodges.entrySet()) {
            System.out.println("\t\tID = " + entry.getKey() + " Highest Number of Successful Dodges = " + entry.getValue());
        }
    }

    private static void printFinalistsIDFightsInfo() {
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDFightsMap.entrySet()) {
            for (Hero hero : FinalStatistics.finalTwoStanding) {
                if (entry.getKey().equals(hero.getId())) {
                    FinalStatistics.finalistsIDFigthsMap.put(entry.getKey(), entry.getValue());
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : FinalStatistics.finalistsIDFigthsMap.entrySet()) {
            System.out.print("\t\tID = " + entry.getKey() + " Fights = " + entry.getValue());
        }
    }

    private static void printFinalistsIDBattleInfo() {
        for (Map.Entry<Integer, Integer> entry : FinalStatistics.heroesIDBattlesMap.entrySet()) {
            for (Hero hero : FinalStatistics.finalTwoStanding) {
                if (entry.getKey().equals(hero.getId())) {
                    FinalStatistics.finalistsIDBattlesMap.put(entry.getKey(), entry.getValue());
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : FinalStatistics.finalistsIDBattlesMap.entrySet()) {
            System.out.print("\t\tID = " + entry.getKey() + " Battles = " + entry.getValue());
        }
    }

    private static void printBattleInfo(Hero firstHero, Hero secondHero, int damage, int damageTook) {
        printSeparator();
        System.out.println("The heroes fighting location: " + location);
        printSeparator();

        System.out.println("\t\t\t\tBATTLE");
        printSeparator();
        System.out.println("ID = " + firstHero.getId() + " " + firstHero.getClassName() + " dealt " + damage + " damage to the " + secondHero.getClassName());
        System.out.println("ID = " + firstHero.getId() + " " + firstHero.getClassName() + " has " + firstHero.healthPoints + " health points left");

        System.out.println("ID = " + secondHero.getId() + " " + secondHero.getClassName() + " dealt " + damageTook + " damage to the " + firstHero.getClassName());
        System.out.println("ID = " + secondHero.getId() + " " + secondHero.getClassName() + " has " + secondHero.healthPoints + " health points left");
    }

    private static void printFinalInfo() {
        printTwoFinalistsStats();
        printSeparator();
        System.out.println("\t\t\t\t\t\tROUNDS = " + finalStatistics.getRounds());
        printFinalistsIDBattleInfo();
        System.out.println();
        printFinalistsIDFightsInfo();
        System.out.println();
        printFinalistsIDDamageInfo();
        System.out.println();
        printSeparator();
        System.out.println("\t\t\t\t\tHONORABLE MENTIONS");
        printTopTwoLosersHighestDamageValueInfo();
        printTopTwoLosersHighestNumberOfSuccessfulAttackDodgesInfo();
    }
}
