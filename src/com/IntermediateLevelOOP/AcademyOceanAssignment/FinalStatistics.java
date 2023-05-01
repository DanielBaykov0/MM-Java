package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.HashMap;
import java.util.Map;

public class FinalStatistics {

    private HashMap<Integer, Hero> highestDamageOutput = new HashMap<>();
    private HashMap<Integer, Hero> highestNumberOfSuccessfulAttackDodges;
    private HashMap<Integer, Hero> highestDamageSurvivedOnASingleFight;
    private HashMap<Integer, Integer> allHeroesDamageSum = new HashMap<>();
    private int longestFight;
    private int firstHeroDamageSum;
    private int secondHeroDamageSum;

    private int firstHeroFights = 0;
    private int secondHeroFights = 0;
    private int rounds = 0;
    private int numberOfAllBattles = 0;

    public FinalStatistics() {
        firstHeroDamageSum = 0;
        secondHeroDamageSum = 0;
    }

    public int getNumberOfAllBattles() {
        return numberOfAllBattles;
    }

    public void setNumberOfAllBattles(int numberOfAllBattles) {
        this.numberOfAllBattles = numberOfAllBattles;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public int getFirstHeroFights() {
        return firstHeroFights;
    }

    public void setFirstHeroFights(int firstHeroFights) {
        this.firstHeroFights = firstHeroFights;
    }

    public int getSecondHeroFights() {
        return secondHeroFights;
    }

    public void setSecondHeroFights(int secondHeroFights) {
        this.secondHeroFights = secondHeroFights;
    }

    public HashMap<Integer, Integer> getAllHeroesDamageSum() {
        return allHeroesDamageSum;
    }

    public void setAllHeroesDamageSum(HashMap<Integer, Integer> allHeroesDamageSum) {
        this.allHeroesDamageSum = allHeroesDamageSum;
    }

    public int getSecondHeroDamageSum() {
        return secondHeroDamageSum;
    }

    public void setSecondHeroDamageSum(int secondHeroDamageSum) {
        this.secondHeroDamageSum = secondHeroDamageSum;
    }

    public int getFirstHeroDamageSum() {
        return firstHeroDamageSum;
    }

    public void setFirstHeroDamageSum(int firstHeroDamageSum) {
        this.firstHeroDamageSum = firstHeroDamageSum;
    }

    public HashMap<Integer, Hero> getHighestDamageOutput() {
        return highestDamageOutput;
    }

    public void setHighestDamageOutput(HashMap<Integer, Hero> highestDamageOutput) {
        this.highestDamageOutput = highestDamageOutput;
    }

    public HashMap<Integer, Hero> getHighestNumberOfSuccessfulAttackDodges() {
        return highestNumberOfSuccessfulAttackDodges;
    }

    public void setHighestNumberOfSuccessfulAttackDodges(HashMap<Integer, Hero> highestNumberOfSuccessfulAttackDodges) {
        this.highestNumberOfSuccessfulAttackDodges = highestNumberOfSuccessfulAttackDodges;
    }

    public HashMap<Integer, Hero> getHighestDamageSurvivedOnASingleFight() {
        return highestDamageSurvivedOnASingleFight;
    }

    public void setHighestDamageSurvivedOnASingleFight(HashMap<Integer, Hero> highestDamageSurvivedOnASingleFight) {
        this.highestDamageSurvivedOnASingleFight = highestDamageSurvivedOnASingleFight;
    }

    public int getLongestFight() {
        return longestFight;
    }

    public void setLongestFight(int longestFight) {
        this.longestFight = longestFight;
    }

    @Override
    public String toString() {
        return "FinalStats{" +
                "highestDamageOutput=" + highestDamageOutput +
                ", highestDamageSurvivedOnASingleFight=" + highestDamageSurvivedOnASingleFight +
                '}';
    }

    public Map<Integer, String> getHighestDamageOutput(int damage, Hero firstHero) {
        Map<Integer, String> map = new HashMap<>();
        map.put(damage, firstHero.getClassName());
        return map;
    }

    public void printHighestDamageOutput(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("'" + entry.getKey() + "' did the highest damage output of " + entry.getValue());
        }
    }
}
