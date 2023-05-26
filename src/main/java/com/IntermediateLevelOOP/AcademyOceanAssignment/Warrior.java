package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.Random;

public class Warrior extends Hero {

    private static final double WARRIOR_SPECIAL_ATTACK_MULTIPLIER = 1.5;
    private static final double WARRIOR_HEALING_MULTIPLIER = 0.05;
    private final HeroesService heroesService = new HeroesService();

    public Warrior(int id) {
        super(id, "Warrior");
    }

    @Override
    public String getQuote() {
        return "If you're a true warrior, competition doesn't scare you.\n" +
                "It makes you better.";
    }

    @Override
    public int attack(Random random) {
        if (isBattlefieldLocation(FightersService.location)) {
            if (isSpecialAttackLocation(heroesService.getRandomNumberBetweenOneAndOneHundred(random))) {
                return (int) (super.attack(new Random()) * WARRIOR_SPECIAL_ATTACK_MULTIPLIER);
            }
        }

        return super.attack(new Random());
    }

    private static boolean isBattlefieldLocation(Locations location) {
        return Locations.BATTLEFIELD.equals(location);
    }

    private boolean isSpecialAttackLocation(int specialAttackLocationNumber) {
        int specialAttackLocationPercent = 10;
        return specialAttackLocationNumber <= specialAttackLocationPercent;
    }

    public static void isWarriorHealed(Locations location, Hero firstHero, Hero secondHero, int damage, int damageTook) {
        if ((Warrior.isBattlefieldLocation(location) && "Warrior".equals(firstHero.getSpecializationName()))) {
            firstHero.setHealthPoints(firstHero.getHealthPoints() + (int) (damage * WARRIOR_HEALING_MULTIPLIER));
        }

        if ((Warrior.isBattlefieldLocation(location) && "Warrior".equals(secondHero.getSpecializationName()))) {
            secondHero.setHealthPoints(secondHero.getHealthPoints() + (int) (damageTook * WARRIOR_HEALING_MULTIPLIER));
        }
    }
}