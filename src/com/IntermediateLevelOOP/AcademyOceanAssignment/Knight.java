package com.IntermediateLevelOOP.AcademyOceanAssignment;

public class Knight extends Hero {

    public Knight() {
        super("Knight");
    }

    @Override
    public String getQuote() {
        return "War seems like a fine adventure, the greatest most of them will ever know.\n" +
                "Then they get a taste of battle.";
    }

    @Override
    public int attack() {
        if (isSpecialAttack(RANDOM_NUMBER_GENERATOR.nextInt(1, 101))) {
            return super.attack() * 2;
        } else {
            return super.attack();
        }
    }

    @Override
    public int defend() {
        if (isSpecialDefence(RANDOM_NUMBER_GENERATOR.nextInt(1, 101))) {
            return Integer.MAX_VALUE;
        } else {
            return super.defend();
        }
    }

    private boolean isSpecialAttack(int specialAttackNumber) {
        int specialAttackPercent = 10;
        return specialAttackNumber <= specialAttackPercent;
    }

    private boolean isSpecialDefence(int specialDefenceNumber) {
        int specialDefencePercent = 20;
        return specialDefenceNumber <= specialDefencePercent;
    }
}
