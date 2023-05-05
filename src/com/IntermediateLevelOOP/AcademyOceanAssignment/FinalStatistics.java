package com.IntermediateLevelOOP.AcademyOceanAssignment;

public class FinalStatistics {

    private int firstHeroFights;
    private int secondHeroFights;
    private int firstHeroDamageValue;
    private int firstHeroBattle;
    private int secondHeroDamageValue;
    private int secondHeroBattle;
    private int rounds;

    private int firstHeroHighestDamageValue;
    private int secondHeroHighestDamageValue;
    private int firstHeroHighestNumberOfSuccessfulAttackDodges;
    private int secondHeroHighestNumberOfSuccessfulAttackDodges;

    public FinalStatistics() {
    }

    public int getFirstHeroHighestDamageValue() {
        return firstHeroHighestDamageValue;
    }

    public int setFirstHeroHighestDamageValue(int firstHeroHighestDamageValue) {
        this.firstHeroHighestDamageValue = firstHeroHighestDamageValue;
        return firstHeroHighestDamageValue;
    }

    public int getSecondHeroHighestDamageValue() {
        return secondHeroHighestDamageValue;
    }

    public int setSecondHeroHighestDamageValue(int secondHeroHighestDamageValue) {
        this.secondHeroHighestDamageValue = secondHeroHighestDamageValue;
        return secondHeroHighestDamageValue;
    }

    public int getFirstHeroHighestNumberOfSuccessfulAttackDodges() {
        return firstHeroHighestNumberOfSuccessfulAttackDodges;
    }

    public int setFirstHeroHighestNumberOfSuccessfulAttackDodges(int firstHeroHighestNumberOfSuccessfulAttackDodges) {
        this.firstHeroHighestNumberOfSuccessfulAttackDodges = firstHeroHighestNumberOfSuccessfulAttackDodges;
        return firstHeroHighestNumberOfSuccessfulAttackDodges;
    }

    public int getSecondHeroHighestNumberOfSuccessfulAttackDodges() {
        return secondHeroHighestNumberOfSuccessfulAttackDodges;
    }

    public int setSecondHeroHighestNumberOfSuccessfulAttackDodges(int secondHeroHighestNumberOfSuccessfulAttackDodges) {
        this.secondHeroHighestNumberOfSuccessfulAttackDodges = secondHeroHighestNumberOfSuccessfulAttackDodges;
        return secondHeroHighestNumberOfSuccessfulAttackDodges;
    }

    public int getFirstHeroDamageValue() {
        return firstHeroDamageValue;
    }

    public int setFirstHeroDamageValue(int firstHeroDamageValue) {
        this.firstHeroDamageValue = firstHeroDamageValue;
        return firstHeroDamageValue;
    }

    public int getFirstHeroBattle() {
        return firstHeroBattle;
    }

    public int setFirstHeroBattle(int firstHeroBattle) {
        this.firstHeroBattle = firstHeroBattle;
        return firstHeroBattle;
    }

    public int getSecondHeroDamageValue() {
        return secondHeroDamageValue;
    }

    public int setSecondHeroDamageValue(int secondHeroDamageValue) {
        this.secondHeroDamageValue = secondHeroDamageValue;
        return secondHeroDamageValue;
    }

    public int getSecondHeroBattle() {
        return secondHeroBattle;
    }

    public int setSecondHeroBattle(int secondHeroBattle) {
        this.secondHeroBattle = secondHeroBattle;
        return secondHeroBattle;
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
}
