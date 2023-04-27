package com.IntermediateLevelOOP.AcademyOceanAssignment;

public class Assassin extends Hero {


    public Assassin() {
        super("Assassin");
    }

    @Override
    public String getQuote() {
        return "One kills a man, one is an assassin; one kills millions,\n" +
                "one is a conqueror; one kills everybody, one is a god.";
    }

    @Override
    public int attack() {
        int attackNumber = super.attack();
        int specialAttackNumber = RANDOM_NUMBER_GENERATOR.nextInt(1, 101);
        if (isSpecialAttack(specialAttackNumber)) {
            return attackNumber * 3;
        } else {
            return attackNumber;
        }
    }

    @Override
    public int defend() {
        return super.defend();
    }

    private boolean isSpecialAttack(int specialAttackNumber) {
        int specialAttackPercent = 30;
        return specialAttackNumber <= specialAttackPercent;
    }
}
