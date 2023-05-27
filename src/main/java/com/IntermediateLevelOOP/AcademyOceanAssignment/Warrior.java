package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.Random;

public class Warrior extends Hero {

    private static final double WARRIOR_SPECIAL_ATTACK_MULTIPLIER = 1.5;

    public Warrior(int id) {
        super(id, "Warrior");
    }

    @Override
    public String getQuote() {
        return "If you're a true warrior, competition doesn't scare you.\n" +
                "It makes you better.";
    }

    @Override
    public int attack(Random random, HeroesService heroesService) {
        if (isBattlefieldLocation(FightersService.location)) {
            if (isSpecialAttackLocation(heroesService.getRandomNumberBetweenOneAndOneHundred(random))) {
                return (int) (super.attack(new Random(), heroesService) * WARRIOR_SPECIAL_ATTACK_MULTIPLIER);
            }
        }

        return super.attack(new Random(), heroesService);
    }

    private static boolean isBattlefieldLocation(Locations location) {
        return Locations.BATTLEFIELD.equals(location);
    }

    private boolean isSpecialAttackLocation(int specialAttackLocationNumber) {
        int specialAttackLocationPercent = 10;
        return specialAttackLocationNumber <= specialAttackLocationPercent;
    }
}