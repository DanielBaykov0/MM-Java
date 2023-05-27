package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.Objects;
import java.util.Random;

public abstract class Hero {

    private static final int HEALTH_POINTS = 100;
    private static final int ATTACK_POINTS = 25;
    private static final int ARMOR_POINTS = 20;
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

    public int attack(Random random, HeroesService heroesService) {
        return random.nextInt((int) (attackPoints * heroesService.getEIGHTY_PERCENT_BOUND()), (int) (attackPoints * heroesService.getONE_HUNDRED_AND_TWENTY_ONE_PERCENT_BOUND()));
    }

    public int defend(Random random, HeroesService heroesService) {
        return random.nextInt((int) (armorPoints * heroesService.getEIGHTY_PERCENT_BOUND()), (int) (armorPoints * heroesService.getONE_HUNDRED_AND_TWENTY_ONE_PERCENT_BOUND()));
    }

    public void checkHeroHealthPoints() {
        if (this.getHealthPoints() <= 0) {
            this.setHealthPoints(0);
        }
    }

    public int getFirstHeroDamage(Hero firstHero, Hero secondHero) {
        int damage = firstHero.attack(new Random(), new HeroesService()) - secondHero.defend(new Random(), new HeroesService());
        if (damage < 0) {
            damage = 0;
        }

        return damage;
    }

    public int getSecondHeroDamage(Hero secondHero, Hero firstHero) {
        int damage = secondHero.attack(new Random(), new HeroesService()) - firstHero.defend(new Random(), new HeroesService());
        if (damage < 0) {
            damage = 0;
        }

        return damage;
    }

    public void printHeroDied() {
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