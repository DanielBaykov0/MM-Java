package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.Random;

public class AssassinMock extends Hero {

    private final HeroesService heroesService = new HeroesService();
    private static final double ASSASSIN_SPECIAL_LOCATION_ATTACK_MULTIPLIER = 4.5;
    private static final int ASSASSIN_SPECIAL_ATTACK_MULTIPLIER = 3;

    public AssassinMock(int id) {
        super(id, "Assassin");
    }

    @Override
    public String getQuote() {
        return "One kills a man, one is an assassin; one kills millions,\n" +
                "one is a conqueror; one kills everybody, one is a god.";
    }

    public int attackHigherValue(Random random) {
        int number = 10;
        if (isSpecialLocation(FightersService.location)) {
            int specialValueNumber = heroesService.getAssassinRandomSpecialAttackValue(random);
            if (isSpecialAttack(number, specialValueNumber)) {
                if (specialValueNumber == heroesService.getASSASSIN_SPECIAL_LOCATION_LOWER_ATTACK_PERCENT()) {
                    return (int) (super.attack(new Random()) * ASSASSIN_SPECIAL_LOCATION_ATTACK_MULTIPLIER);
                }
            }
        }

        return super.attack(new Random());
    }

    public int attackLowerValue(Random random) {
        int number = 35;
        if (isSpecialLocation(FightersService.location)) {
            int specialValueNumber = heroesService.getAssassinRandomSpecialAttackValue(random);
            if (isSpecialAttack(number, specialValueNumber)) {
                if (specialValueNumber == heroesService.getASSASSIN_SPECIAL_LOCATION_HIGHER_ATTACK_PERCENT()) {
                    return super.attack(new Random()) * ASSASSIN_SPECIAL_ATTACK_MULTIPLIER;
                }
            }
        }

        return super.attack(new Random());
    }

    private static boolean isSpecialLocation(Locations location) {
        return Locations.WOODS.equals(location);
    }

    private boolean isSpecialAttack(int specialAttackNumber, int specialAttackPercent) {
        return specialAttackNumber <= specialAttackPercent;
    }
}
