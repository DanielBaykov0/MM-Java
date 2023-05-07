package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.*;

public class HeroesService {

    private final Random RANDOM_NUMBER_GENERATOR = new Random();
    private final FinalStatistics finalStatistics = new FinalStatistics();
    private final OutputMessages outputMessages = new OutputMessages();

    private final Map<Integer, Hero> heroesHashMapStore = new HashMap<>();
    private final Map<Integer, Integer> heroesIDFightsMap = new HashMap<>();
    private final Map<Integer, Integer> heroesIDDamageMap = new HashMap<>();
    private final Map<Integer, Integer> heroesIDBattlesMap = new HashMap<>();
    private final Map<Integer, Integer> heroesIDHighestDamageMap = new HashMap<>();
    private final Map<Integer, Integer> heroesIDHighestNumberOfSuccessfulAttackDodgesMap = new HashMap<>();

    private List<Hero> finalTwoStanding = new ArrayList<>();
    private final Map<Integer, Integer> finalistsIDBattlesMap = new HashMap<>();
    private final Map<Integer, Integer> finalistsIDFigthsMap = new HashMap<>();
    private final Map<Integer, Integer> finalistsIDDamageMap = new HashMap<>();

    private final List<Hero> losers = new ArrayList<>();
    private final Map<Integer, Integer> losersHighestDamageValue = new HashMap<>();
    private final Queue<Integer> topTwoLosersHighestDamageValue = new PriorityQueue<>();
    private final Map<Integer, Integer> losersHighestNumberOfSuccessfulAttackDodges = new HashMap<>();
    private final Queue<Integer> topTwoLosersHighestNumberOfSuccessfulAttackDodges = new PriorityQueue<>();

    public HeroesService() {
    }

    public Map<Integer, Integer> getLosersHighestDamageValue() {
        return losersHighestDamageValue;
    }

    public Queue<Integer> getTopTwoLosersHighestDamageValue() {
        return topTwoLosersHighestDamageValue;
    }

    public Map<Integer, Integer> getLosersHighestNumberOfSuccessfulAttackDodges() {
        return losersHighestNumberOfSuccessfulAttackDodges;
    }

    public Queue<Integer> getTopTwoLosersHighestNumberOfSuccessfulAttackDodges() {
        return topTwoLosersHighestNumberOfSuccessfulAttackDodges;
    }

    public Map<Integer, Integer> getFinalistsIDBattlesMap() {
        return finalistsIDBattlesMap;
    }

    public Map<Integer, Integer> getFinalistsIDFigthsMap() {
        return finalistsIDFigthsMap;
    }

    public Map<Integer, Integer> getFinalistsIDDamageMap() {
        return finalistsIDDamageMap;
    }

    public List<Hero> getLosers() {
        return losers;
    }

    public Map<Integer, Hero> getHeroesHashMapStore() {
        return heroesHashMapStore;
    }

    public List<Hero> getFinalTwoStanding() {
        return finalTwoStanding;
    }

    public void setFinalTwoStanding(List<Hero> finalTwoStanding) {
        this.finalTwoStanding = finalTwoStanding;
    }

    public Map<Integer, Integer> getHeroesIDFightsMap() {
        return heroesIDFightsMap;
    }

    public Map<Integer, Integer> getHeroesIDDamageMap() {
        return heroesIDDamageMap;
    }

    public Map<Integer, Integer> getHeroesIDBattlesMap() {
        return heroesIDBattlesMap;
    }

    public Map<Integer, Integer> getHeroesIDHighestDamageMap() {
        return heroesIDHighestDamageMap;
    }

    public Map<Integer, Integer> getHeroesIDHighestNumberOfSuccessfulAttackDodgesMap() {
        return heroesIDHighestNumberOfSuccessfulAttackDodgesMap;
    }

    public void resetHeroStats(List<Hero> heroes) {
        for (Hero hero : heroes) {
            hero.setHealthPoints(hero.getMaxHealthPoints());
            hero.setAttackPoints(hero.getMaxAttackPoints());
            hero.setArmorPoints(hero.getMaxArmorPoints());
        }
    }

    public List<Hero> generateHeroes(int inputNumber) {
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < inputNumber; i++) {
            heroes.add(getRandomHero(i));
        }

        return heroes;
    }

    private Hero getRandomHero(int id) {
        return getHeroes(id).get(RANDOM_NUMBER_GENERATOR.nextInt(getHeroes(id).size()));
    }

    private List<Hero> getHeroes(int id) {
        List<Hero> heroes = new ArrayList<>();
        heroes.add(new Warrior(id));
        heroes.add(new Knight(id));
        heroes.add(new Assassin(id));
        heroes.add(new Monk(id));
        return heroes;
    }


    public void isFinal(List<Hero> heroes) {
        if (heroes.size() == 2) {
            setFinalTwoStanding(heroes);
            System.out.println("\t\t\t   LAST MATCH");
        }
    }

    // HERO STORE MAP
    public void generateHeroStoreMap(List<Hero> heroes) {
        for (Hero hero : heroes) {
            getHeroesHashMapStore().put(hero.getId(), hero);
        }
    }

    public void generateLosers() {
        for (Hero hero : getHeroesHashMapStore().values()) {
            if (!getFinalTwoStanding().contains(hero)) {
                getLosers().add(hero);
            }
        }
    }

    // ID FIGHTS MAP
    public void putFirstHeroIDFightsMap(Hero firstHero, List<Hero> heroes) {
        for (Hero hero : heroes) {
            if (hero.getId() == firstHero.getId()) {
                heroesIDFightsMap.put(hero.getId(), finalStatistics.getFirstHeroFights() + 1);
            }
        }
    }

    public void checkFirstHeroFights(Hero firstHero) {
        for (Map.Entry<Integer, Integer> entry : heroesIDFightsMap.entrySet()) {
            if (entry.getKey().equals(firstHero.getId())) {
                finalStatistics.setFirstHeroFights(entry.getValue());
            }
        }
    }

    public void putSecondHeroIDFightsMap(Hero secondHero, List<Hero> heroes) {
        for (Hero hero : heroes) {
            if (hero.getId() == secondHero.getId()) {
                heroesIDFightsMap.put(hero.getId(), finalStatistics.getSecondHeroFights() + 1);
            }
        }
    }

    public void checkSecondHeroFights(Hero secondHero) {
        for (Map.Entry<Integer, Integer> entry : heroesIDFightsMap.entrySet()) {
            if (entry.getKey().equals(secondHero.getId())) {
                finalStatistics.setSecondHeroFights(entry.getValue());
            }
        }
    }

    // ID HIGHEST DAMAGE MAP
    public void putFirstHeroIDHighestDamageMap(Hero firstHero, List<Hero> heroes, int damage) {
        for (Hero hero : heroes) {
            if (hero.getId() == firstHero.getId() && damage > finalStatistics.getFirstHeroHighestDamageValue()) {
                heroesIDHighestDamageMap.put(hero.getId(), finalStatistics.setFirstHeroHighestDamageValue(damage));
            }
        }
    }

    public void checkFirstHeroHighestDamageValue(Hero firstHero) {
        for (Map.Entry<Integer, Integer> entry : heroesIDHighestDamageMap.entrySet()) {
            if (entry.getKey().equals(firstHero.getId())) {
                finalStatistics.setFirstHeroHighestDamageValue(entry.getValue());
            }
        }
    }

    public void putSecondHeroIDHighestDamageMap(Hero secondHero, List<Hero> heroes, int damageTook) {
        for (Hero hero : heroes) {
            if (hero.getId() == secondHero.getId() && damageTook > finalStatistics.getSecondHeroHighestDamageValue()) {
                heroesIDHighestDamageMap.put(hero.getId(), finalStatistics.setSecondHeroHighestDamageValue(damageTook));
            }
        }
    }

    public void checkSecondHeroHighestDamageValue(Hero secondHero) {
        for (Map.Entry<Integer, Integer> entry : heroesIDHighestDamageMap.entrySet()) {
            if (entry.getKey().equals(secondHero.getId())) {
                finalStatistics.setSecondHeroHighestDamageValue(entry.getValue());
            }
        }
    }

    // ID DAMAGE / BATTLES MAP
    public void putFirstHeroIDDamageBattlesMap(Hero firstHero, List<Hero> heroes, int damage) {
        for (Hero hero : heroes) {
            if (hero.getId() == firstHero.getId()) {
                heroesIDDamageMap.put(hero.getId(), finalStatistics.setFirstHeroDamageValue(finalStatistics.getFirstHeroDamageValue() + damage));
                heroesIDBattlesMap.put(hero.getId(), finalStatistics.setFirstHeroBattle(1 + finalStatistics.getFirstHeroBattle()));
            }
        }
    }

    public void checkFirstHeroDamageValue(Hero firstHero) {
        for (Map.Entry<Integer, Integer> entry : heroesIDDamageMap.entrySet()) {
            if (entry.getKey().equals(firstHero.getId())) {
                finalStatistics.setFirstHeroDamageValue(entry.getValue());
            }
        }
    }

    public void checkFirstHeroBattles(Hero firstHero) {
        for (Map.Entry<Integer, Integer> entry : heroesIDBattlesMap.entrySet()) {
            if (entry.getKey().equals(firstHero.getId())) {
                finalStatistics.setFirstHeroBattle(entry.getValue());
            }
        }
    }

    public void putSecondHeroIDDamageBattleMap(Hero secondHero, List<Hero> heroes, int damageTook) {
        for (Hero hero : heroes) {
            if (hero.getId() == secondHero.getId()) {
                heroesIDDamageMap.put(hero.getId(), finalStatistics.setSecondHeroDamageValue(finalStatistics.getSecondHeroDamageValue() + damageTook));
                heroesIDBattlesMap.put(hero.getId(), finalStatistics.setSecondHeroBattle(1 + finalStatistics.getSecondHeroBattle()));
            }
        }
    }

    public void checkSecondHeroDamageValue(Hero secondHero) {
        for (Map.Entry<Integer, Integer> entry : heroesIDDamageMap.entrySet()) {
            if (entry.getKey().equals(secondHero.getId())) {
                finalStatistics.setSecondHeroDamageValue(entry.getValue());
            }
        }
    }

    public void checkSecondHeroBattles(Hero secondHero) {
        for (Map.Entry<Integer, Integer> entry : heroesIDBattlesMap.entrySet()) {
            if (entry.getKey().equals(secondHero.getId())) {
                finalStatistics.setSecondHeroBattle(entry.getValue());
            }
        }
    }

    // HIGHEST NUMBER OF SUCCESSFUL ATTACK DODGES
    public void putFirstHeroHighestNumberOfSuccessfulAttackDodges(Hero secondHero, List<Hero> heroes, int damage) {
        for (Hero hero : heroes) {
            if (hero.getId() == secondHero.getId() && damage == 0) {
                heroesIDHighestNumberOfSuccessfulAttackDodgesMap
                        .put(hero.getId(),
                                finalStatistics.setSecondHeroHighestNumberOfSuccessfulAttackDodges(1 + finalStatistics.getSecondHeroHighestNumberOfSuccessfulAttackDodges()));
            }
        }
    }

    public void checkFirstHeroHighestNumberOfSuccessfulAttackDodges(Hero firstHero) {
        for (Map.Entry<Integer, Integer> entry : heroesIDHighestNumberOfSuccessfulAttackDodgesMap.entrySet()) {
            if (entry.getKey().equals(firstHero.getId())) {
                finalStatistics.setFirstHeroHighestNumberOfSuccessfulAttackDodges(entry.getValue());
            }
        }
    }

    public void putSecondHeroHighestNumberOfSuccessfulAttackDodges(Hero firstHero, List<Hero> heroes, int damageTook) {
        for (Hero hero : heroes) {
            if (hero.getId() == firstHero.getId() && damageTook == 0) {
                heroesIDHighestNumberOfSuccessfulAttackDodgesMap
                        .put(hero.getId(),
                                finalStatistics.setFirstHeroHighestNumberOfSuccessfulAttackDodges(1 + finalStatistics.getFirstHeroHighestNumberOfSuccessfulAttackDodges()));
            }
        }
    }

    public void checkSecondHeroHighestNumberOfSuccessfulAttackDodges(Hero secondHero) {
        for (Map.Entry<Integer, Integer> entry : heroesIDHighestNumberOfSuccessfulAttackDodgesMap.entrySet()) {
            if (entry.getKey().equals(secondHero.getId())) {
                finalStatistics.setSecondHeroHighestNumberOfSuccessfulAttackDodges(entry.getValue());
            }
        }
    }

    // PRINT FINALISTS
    public void printTwoFinalistsStats() {
        System.out.println("\t\t\t\t\t\tTWO FINALISTS INFO");
        for (Hero hero : getFinalTwoStanding()) {
            resetHeroStats(getFinalTwoStanding());
            System.out.println(hero);
        }
    }

    public void printFinalistsIDDamageInfo() {
        for (Map.Entry<Integer, Integer> entry : getHeroesIDDamageMap().entrySet()) {
            for (Hero hero : getFinalTwoStanding()) {
                if (entry.getKey().equals(hero.getId())) {
                    getFinalistsIDDamageMap().put(entry.getKey(), entry.getValue());
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : getFinalistsIDDamageMap().entrySet()) {
            System.out.print("\t\tID = " + entry.getKey() + " Damage = " + entry.getValue());
        }
    }

    public void printFinalistsIDFightsInfo() {
        for (Map.Entry<Integer, Integer> entry : getHeroesIDFightsMap().entrySet()) {
            for (Hero hero : getFinalTwoStanding()) {
                if (entry.getKey().equals(hero.getId())) {
                    getFinalistsIDFigthsMap().put(entry.getKey(), entry.getValue());
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : getFinalistsIDFigthsMap().entrySet()) {
            System.out.print("\t\tID = " + entry.getKey() + " Fights = " + entry.getValue());
        }
    }

    public void printFinalistsIDBattleInfo() {
        for (Map.Entry<Integer, Integer> entry : getHeroesIDBattlesMap().entrySet()) {
            for (Hero hero : getFinalTwoStanding()) {
                if (entry.getKey().equals(hero.getId())) {
                    getFinalistsIDBattlesMap().put(entry.getKey(), entry.getValue());
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : getFinalistsIDBattlesMap().entrySet()) {
            System.out.print("\t\tID = " + entry.getKey() + " Battles = " + entry.getValue());
        }
    }

    // PRINT LOSERS
    public void printTopTwoLosersHighestDamageValueInfo() {
        for (Map.Entry<Integer, Integer> entry : getHeroesIDHighestDamageMap().entrySet()) {
            getTopTwoLosersHighestDamageValue().add(entry.getValue());
            if (getTopTwoLosersHighestDamageValue().size() > 2) {
                getTopTwoLosersHighestDamageValue().poll();
            }
        }

        for (Integer integer : getTopTwoLosersHighestDamageValue()) {
            System.out.println("\t\t Highest Damage Value = " + integer);
        }
    }

    public void printTopTwoLosersHighestNumberOfSuccessfulAttackDodgesInfo() {
        for (Map.Entry<Integer, Integer> entry : getHeroesIDHighestNumberOfSuccessfulAttackDodgesMap().entrySet()) {
            getTopTwoLosersHighestNumberOfSuccessfulAttackDodges().add(entry.getValue());
            if (getTopTwoLosersHighestNumberOfSuccessfulAttackDodges().size() > 2) {
                getTopTwoLosersHighestNumberOfSuccessfulAttackDodges().poll();
            }
        }

        for (Integer integer : getTopTwoLosersHighestNumberOfSuccessfulAttackDodges()) {
            System.out.println("\t\t Highest Number of Successful Dodges = " + integer);
        }
    }

    // not used at the moment
    public void printAllHeroesIDDamageInfo() {
        outputMessages.printSeparator();
        System.out.println("\t\tDAMAGE SUMMARY");
        outputMessages.printSeparator();
        for (Map.Entry<Integer, Integer> entry : getHeroesIDDamageMap().entrySet()) {
            for (Map.Entry<Integer, Hero> heroId : getHeroesHashMapStore().entrySet()) {
                if (heroId.getKey().equals(entry.getKey())) {
                    System.out.print("ID = " + entry.getKey() + " Hero " + heroId.getValue().getClassName() + " Damage = " + entry.getValue());
                }
            }
            System.out.println();
        }
    }

    // not used at the moment
    public void printAllHeroesIDBattlesInfo() {
        outputMessages.printSeparator();
        System.out.println("\t\tBATTLES SUMMARY");
        outputMessages.printSeparator();
        for (Map.Entry<Integer, Integer> entry : getHeroesIDBattlesMap().entrySet()) {
            for (Map.Entry<Integer, Hero> heroId : getHeroesHashMapStore().entrySet()) {
                if (heroId.getKey().equals(entry.getKey())) {
                    System.out.print("ID = " + entry.getKey() + " Hero " + heroId.getValue().getClassName() + " Battles = " + entry.getValue());
                }
            }
            System.out.println();
        }
    }

    // not used at the moment
    public void printAllHeroesIDHighestDamageValueInfo() {
        outputMessages.printSeparator();
        System.out.println("\t\tHIGHEST DAMAGE VALUE SUMMARY");
        outputMessages.printSeparator();
        for (Map.Entry<Integer, Integer> entry : getHeroesIDHighestDamageMap().entrySet()) {
            for (Map.Entry<Integer, Hero> heroId : getHeroesHashMapStore().entrySet()) {
                if (heroId.getKey().equals(entry.getKey())) {
                    System.out.print("ID = " + entry.getKey() + " Hero " + heroId.getValue().getClassName() + " Battles = " + entry.getValue());
                }
            }
            System.out.println();
        }
    }

    // not used at the moment
    public void printAllHeroesIDHighestNumberOfSuccessfulAttackDodgesInfo() {
        outputMessages.printSeparator();
        System.out.println("\t\tHIGHEST DAMAGE VALUE SUMMARY");
        outputMessages.printSeparator();
        for (Map.Entry<Integer, Integer> entry : getHeroesIDHighestNumberOfSuccessfulAttackDodgesMap().entrySet()) {
            for (Map.Entry<Integer, Hero> heroId : getHeroesHashMapStore().entrySet()) {
                if (heroId.getKey().equals(entry.getKey())) {
                    System.out.print("ID = " + entry.getKey() + " Hero " + heroId.getValue().getClassName() + " Highest Number of Successful Dodges = " + entry.getValue());
                }
            }
            System.out.println();
        }
    }

    // not used at the moment
    public void printLosersIDHighestDamageValueInfo() {
        for (Map.Entry<Integer, Integer> entry : getHeroesIDHighestDamageMap().entrySet()) {
            for (Hero hero : getLosers()) {
                if (entry.getKey().equals(hero.getId())) {
                    getLosersHighestDamageValue().put(entry.getKey(), entry.getValue());
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : getLosersHighestDamageValue().entrySet()) {
            System.out.println("\t\tID = " + entry.getKey() + " Highest Damage Value = " + entry.getValue());
        }
    }

    // not used at the moment
    public void printLosersIDHighestNumberOfSuccessfulAttackDodgesInfo() {
        for (Map.Entry<Integer, Integer> entry : getHeroesIDHighestNumberOfSuccessfulAttackDodgesMap().entrySet()) {
            for (Hero hero : getLosers()) {
                if (entry.getKey().equals(hero.getId())) {
                    getLosersHighestNumberOfSuccessfulAttackDodges().put(entry.getKey(), entry.getValue());
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : getLosersHighestNumberOfSuccessfulAttackDodges().entrySet()) {
            System.out.println("\t\tID = " + entry.getKey() + " Highest Number of Successful Dodges = " + entry.getValue());
        }
    }
}
