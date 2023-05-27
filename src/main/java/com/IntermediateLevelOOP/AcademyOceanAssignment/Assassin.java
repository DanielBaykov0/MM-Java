package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.Random;

public class Assassin extends Hero {

    private static final int ASSASSIN_SPECIAL_ATTACK_MULTIPLIER = 3;
    private static final int ASSASSIN_SPECIAL_ATTACK_PERCENT = 30;
    private static final double ASSASSIN_SPECIAL_LOCATION_ATTACK_MULTIPLIER = 4.5;

    public Assassin(int id) {
        super(id, "Assassin");
    }

    @Override
    public String getQuote() {
        return "One kills a man, one is an assassin; one kills millions,\n" +
                "one is a conqueror; one kills everybody, one is a god.";
    }

    @Override
    public int attack(Random random, HeroesService heroesService) {
        int number = heroesService.getRandomNumberBetweenOneAndOneHundred(random);
        if (isSpecialLocation(FightersService.location)) {
            int specialValueNumber = heroesService.getAssassinRandomSpecialAttackValue(random);
            if (isSpecialAttack(number, specialValueNumber)) {
                if (specialValueNumber == heroesService.getASSASSIN_SPECIAL_LOCATION_LOWER_ATTACK_PERCENT()) {
                    return (int) (super.attack(new Random(), heroesService) * ASSASSIN_SPECIAL_LOCATION_ATTACK_MULTIPLIER);
                } else if (specialValueNumber == heroesService.getASSASSIN_SPECIAL_LOCATION_HIGHER_ATTACK_PERCENT()) {
                    return super.attack(new Random(), heroesService) * ASSASSIN_SPECIAL_ATTACK_MULTIPLIER;
                }
            }
        }
        if (isSpecialAttack(number, ASSASSIN_SPECIAL_ATTACK_PERCENT)) {
            return super.attack(new Random(), heroesService) * ASSASSIN_SPECIAL_ATTACK_MULTIPLIER;
        }

        return super.attack(new Random(), heroesService);
    }

    private static boolean isSpecialLocation(Locations location) {
        return Locations.WOODS.equals(location);
    }

    private boolean isSpecialAttack(int specialAttackNumber, int specialAttackPercent) {
        return specialAttackNumber <= specialAttackPercent;
    }
}