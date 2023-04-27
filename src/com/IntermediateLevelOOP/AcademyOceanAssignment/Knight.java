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
        int attackNumber = super.attack();
        int specialAttackNumber = RANDOM_NUMBER_GENERATOR.nextInt(1, 101);
        if (isSpecialAttack(specialAttackNumber)) {
            return attackNumber * 2;
        } else {
            return attackNumber;
        }
    }

    @Override
    public int defend() {
        int defenceNumber = super.defend();
        int specialDefenceNumber = RANDOM_NUMBER_GENERATOR.nextInt(1, 101);
        if (isSpecialDefence(specialDefenceNumber)) {
            return 0;
        } else {
            return defenceNumber;
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
