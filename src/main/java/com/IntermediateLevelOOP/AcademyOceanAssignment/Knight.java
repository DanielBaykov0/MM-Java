package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.Random;

public class Knight extends Hero {

    private final HeroesService heroesService = new HeroesService();

    public Knight(int id) {
        super(id, "Knight");
    }

    @Override
    public String getQuote() {
        return "War seems like a fine adventure, the greatest most of them will ever know.\n" +
                "Then they get a taste of battle.";
    }

    @Override
    public int attack(Random random) {
        if (isSpecialAttack(heroesService.getRandomNumberBetweenOneAndOneHundred(random))) {
            return super.attack(new Random()) * 2;
        } else {
            return super.attack(new Random());
        }
    }

    @Override
    public int defend(Random random) {
        if (isSpecialDefence(heroesService.getRandomNumberBetweenOneAndOneHundred(random))) {
            return Integer.MAX_VALUE;
        } else {
            return super.defend(new Random());
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