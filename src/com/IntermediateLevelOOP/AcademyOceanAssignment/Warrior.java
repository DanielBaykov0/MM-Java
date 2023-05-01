package com.IntermediateLevelOOP.AcademyOceanAssignment;

public class Warrior extends Hero {

    public Warrior(int id) {
        super(id, "Warrior");
    }

    @Override
    public String getQuote() {
        return "If you're a true warrior, competition doesn't scare you.\n" +
                "It makes you better.";
    }

    protected static boolean isBattlefieldLocation(String location) {
        return "Battlefield".equals(location);
    }

    private boolean isSpecialAttackLocation(int specialAttackLocationNumber) {
        int specialAttackLocationPercent = 10;
        return specialAttackLocationNumber <= specialAttackLocationPercent;
    }

    @Override
    public int attack() {
        if (isBattlefieldLocation(FightersService.location)) {
            if (isSpecialAttackLocation(RANDOM_NUMBER_GENERATOR.nextInt(1, 101))) {
                return (int) (super.attack() * 1.5);
            }
        }

        return super.attack();
    }

    @Override
    public int defend() {
        return super.defend();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
