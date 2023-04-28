package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.Random;

public abstract class Hero {

    protected final Random RANDOM_NUMBER_GENERATOR = new Random();
    private final String className;
    protected int HEALTH_POINTS = 100;
    protected int ATTACK_POINTS = 25;
    protected int ARMOR_POINTS = 20;

    public Hero(String className) {
        this.className = className;
    }

    public abstract String getQuote();

    public int attack() {
        return RANDOM_NUMBER_GENERATOR.nextInt((int) (ATTACK_POINTS * 0.8), (int) (ATTACK_POINTS * 1.21));
    }
    public int defend() {
        return RANDOM_NUMBER_GENERATOR.nextInt((int) (ARMOR_POINTS * 0.8), (int) (ARMOR_POINTS * 1.21));
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "Hero: " +
                "'" + className + '\'' +
                ", healthPoints=" + HEALTH_POINTS +
                ", attackPoints=" + ATTACK_POINTS +
                ", armorPoints=" + ARMOR_POINTS;
    }

}
