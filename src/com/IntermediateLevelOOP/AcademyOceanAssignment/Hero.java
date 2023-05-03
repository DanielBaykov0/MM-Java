package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.Random;

public abstract class Hero {

    private final Random RANDOM_NUMBER_GENERATOR = new Random();
    private final String className;
    private int healthPoints;
    private int attackPoints;
    private int armorPoints;
    private final int id;

    public Hero(int id, String className) {
        this.className = className;
        this.id = id;
        this.healthPoints = 100;
        this.attackPoints = 25;
        this.armorPoints = 20;
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

    public String getClassName() {
        return className;
    }

    public Random getRANDOM_NUMBER_GENERATOR() {
        return RANDOM_NUMBER_GENERATOR;
    }

    public int attack() {
        return RANDOM_NUMBER_GENERATOR.nextInt((int) (attackPoints * 0.8), (int) (attackPoints * 1.21));
    }

    public int defend() {
        return RANDOM_NUMBER_GENERATOR.nextInt((int) (armorPoints * 0.8), (int) (armorPoints * 1.21));
    }

    public void checkHeroHealthPoints() {
        if (this.getHealthPoints() <= 0) {
            this.setHealthPoints(0);
        }
    }

    public int getHeroDamage() {
        int damage = this.attack() - this.defend();
        if (damage < 0) {
            damage = 0;
        }

        return damage;
    }

    public void isHeroDead() {
        System.out.println();
        System.out.println(this.getClassName() + " died...");
        System.out.println();
    }

    @Override
    public String toString() {
        return "ID=" + id + " Hero: " +
                "'" + className + '\'' +
                ", healthPoints=" + healthPoints +
                ", attackPoints=" + attackPoints +
                ", armorPoints=" + armorPoints;
    }

}
