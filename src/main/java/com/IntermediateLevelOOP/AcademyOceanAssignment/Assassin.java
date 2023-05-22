package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Assassin extends Hero {

    private static final int ASSASSIN_SPECIAL_ATTACK_MULTIPLIER = 3;
    private static final int ASSASSIN_SPECIAL_ATTACK_PERCENT = 30;
    private static final double ASSASSIN_SPECIAL_LOCATION_ATTACK_MULTIPLIER = 4.5;
    private static final int ASSASSIN_SPECIAL_LOCATION_LOWER_ATTACK_PERCENT = 10;
    private static final int ASSASSIN_SPECIAL_LOCATION_HIGHER_ATTACK_PERCENT = 35;

    // ASK !!!
    public static int SPECIAL_VALUE = getSPECIAL_VALUE();

    public Assassin(int id) {
        super(id, "Assassin");
    }

    @Override
    public String getQuote() {
        return "One kills a man, one is an assassin; one kills millions,\n" +
                "one is a conqueror; one kills everybody, one is a god.";
    }

    @Override
    public int attack(Random random) {
        int number = random.nextInt(1, 101);
        if (isSpecialLocation(FightersService.location)) {
            if (isSpecialAttack(number, SPECIAL_VALUE)) {
                if (SPECIAL_VALUE == ASSASSIN_SPECIAL_LOCATION_LOWER_ATTACK_PERCENT) {
                    return (int) (super.attack(new Random()) * ASSASSIN_SPECIAL_LOCATION_ATTACK_MULTIPLIER);
                } else if (SPECIAL_VALUE == ASSASSIN_SPECIAL_LOCATION_HIGHER_ATTACK_PERCENT) {
                    return super.attack(new Random()) * ASSASSIN_SPECIAL_ATTACK_MULTIPLIER;
                }
            }
        }
        if (isSpecialAttack(number, ASSASSIN_SPECIAL_ATTACK_PERCENT)) {
            return super.attack(new Random()) * ASSASSIN_SPECIAL_ATTACK_MULTIPLIER;
        }

        return super.attack(new Random());
    }

    private static boolean isSpecialLocation(Locations location) {
        return Locations.WOODS.equals(location);
    }

    private static int getSPECIAL_VALUE() {
        List<Integer> specialValues = new ArrayList<>(List.of(ASSASSIN_SPECIAL_LOCATION_HIGHER_ATTACK_PERCENT, ASSASSIN_SPECIAL_LOCATION_LOWER_ATTACK_PERCENT));
        return specialValues.get(getRANDOM_NUMBER_GENERATOR().nextInt(specialValues.size()));
    }

    private boolean isSpecialAttack(int specialAttackNumber, int specialAttackPercent) {
        return specialAttackNumber <= specialAttackPercent;
    }
}