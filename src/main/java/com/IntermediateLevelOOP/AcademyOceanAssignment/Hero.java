package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.Objects;
import java.util.Random;

public abstract class Hero {

    private static final int HEALTH_POINTS = 100;
    private static final int ATTACK_POINTS = 25;
    private static final int ARMOR_POINTS = 20;
    private static final Random RANDOM_NUMBER_GENERATOR = new Random();
    private final String specializationName;
    private int healthPoints;
    private int attackPoints;
    private int armorPoints;
    private final int id;

    public Hero(int id, String specializationName) {
        this.specializationName = specializationName;
        this.id = id;
        this.healthPoints = HEALTH_POINTS;
        this.attackPoints = ATTACK_POINTS;
        this.armorPoints = ARMOR_POINTS;
    }

    public abstract String getQuote();

    public int getId() {
        return id;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getArmorPoints() {
        return armorPoints;
    }

    public int getMaxHealthPoints() {
        return HEALTH_POINTS;
    }

    public int getMaxAttackPoints() {
        return ATTACK_POINTS;
    }

    public int getMaxArmorPoints() {
        return ARMOR_POINTS;
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

    public String getSpecializationName() {
        return specializationName;
    }

    public static Random getRANDOM_NUMBER_GENERATOR() {
        return RANDOM_NUMBER_GENERATOR;
    }

    public int attack(Random random) {
        return random.nextInt((int) (attackPoints * 0.8), (int) (attackPoints * 1.21));
    }

    public int defend(Random random) {
        return random.nextInt((int) (armorPoints * 0.8), (int) (armorPoints * 1.21));
    }

    public void checkHeroHealthPoints() {
        if (this.getHealthPoints() <= 0) {
            this.setHealthPoints(0);
        }
    }

    public int getHeroDamage() {
        int damage = this.attack(new Random()) - this.defend(new Random());
        if (damage < 0) {
            damage = 0;
        }

        return damage;
    }

    public void isHeroDead() {
        System.out.println();
        System.out.println(this.getSpecializationName() + " died...");
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return healthPoints == hero.healthPoints && attackPoints == hero.attackPoints && armorPoints == hero.armorPoints && id == hero.id && Objects.equals(specializationName, hero.specializationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specializationName, healthPoints, attackPoints, armorPoints, id);
    }

    @Override
    public String toString() {
        return "ID=" + id + " Hero: " +
                "'" + specializationName + '\'' +
                ", healthPoints=" + healthPoints +
                ", attackPoints=" + attackPoints +
                ", armorPoints=" + armorPoints;
    }

}