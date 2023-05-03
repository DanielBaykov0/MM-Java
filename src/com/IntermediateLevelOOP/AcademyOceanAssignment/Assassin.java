package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.ArrayList;
import java.util.List;

public class Assassin extends Hero {

    public Assassin(int id) {
        super(id, "Assassin");
    }

    @Override
    public String getQuote() {
        return "One kills a man, one is an assassin; one kills millions,\n" +
                "one is a conqueror; one kills everybody, one is a god.";
    }

    @Override
    public int attack() {
        int number = getRANDOM_NUMBER_GENERATOR().nextInt(1, 101);
        int specialValue = getSpecialValue();
        if (isSpecialLocation(FightersService.location)) {
            if (isSpecialAttack(number, specialValue)) {
                if (specialValue == 10) {
                    return (int) (super.attack() * 4.5);
                } else if (specialValue == 35) {
                    return super.attack() * 3;
                }
            }
        }
        if (isSpecialAttack(number, 30)) {
            return super.attack() * 3;
        }

        return super.attack();
    }

    private static boolean isSpecialLocation(Locations location) {
        return Locations.WOODS.equals(location);
    }

    private int getSpecialValue() {
        List<Integer> specialValues = new ArrayList<>(List.of(35, 10));
        return specialValues.get(getRANDOM_NUMBER_GENERATOR().nextInt(specialValues.size()));
    }

    private boolean isSpecialAttack(int specialAttackNumber, int specialAttackPercent) {
        return specialAttackNumber <= specialAttackPercent;
    }
}
