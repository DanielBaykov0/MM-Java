package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.Random;

public abstract class Hero {

    protected Random RANDOM_NUMBER_GENERATOR = new Random();
    private final String className;
    protected int healthPoints = 100;
    protected int attackPoints = 25;
    protected int armorPoints = 20;
    private final int id;

    public Hero(int id, String className) {
        this.className = className;
        this.id = id;
    }

    public abstract String getQuote();

    public int getId() {
        return id;
    }

    public int getMaxHealthPoints() {
        return 100;
    }

    public int getMaxAttackPoints() {
        return 25;
    }

    public int getMaxArmorPoints() {
        return 20;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void setArmorPoints(int armorPoints) {
        this.armorPoints = armorPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getArmorPoints() {
        return armorPoints;
    }

    public int attack() {
        return RANDOM_NUMBER_GENERATOR.nextInt((int) (attackPoints * 0.8), (int) (attackPoints * 1.21));
    }
    public int defend() {
        return RANDOM_NUMBER_GENERATOR.nextInt((int) (armorPoints * 0.8), (int) (armorPoints * 1.21));
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "Hero: " +
                "'" + className + '\'' +
                ", healthPoints=" + healthPoints +
                ", attackPoints=" + attackPoints +
                ", armorPoints=" + armorPoints;
    }

}
