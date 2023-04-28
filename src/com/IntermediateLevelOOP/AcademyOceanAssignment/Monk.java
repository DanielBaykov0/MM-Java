package com.IntermediateLevelOOP.AcademyOceanAssignment;

public class Monk extends Hero {


    public Monk() {
        super("Monk");
    }

    @Override
    public String getQuote() {
        return "But God will show mercy, though you show none.\n" +
                "And where is the merit of your boasted virtue?";
    }

    @Override
    public int attack() {
        return super.attack();
    }

    @Override
    public int defend() {
        if (isSpecialDefence(RANDOM_NUMBER_GENERATOR.nextInt(1, 101))) {
            return 0;
        } else {
            return super.defend();
        }
    }

    private boolean isSpecialDefence(int specialDefenceNumber) {
        int specialDefencePercent = 30;
        return specialDefenceNumber <= specialDefencePercent;
    }
}
