package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.Random;

public class Knight extends Hero {

    public Knight(int id) {
        super(id, "Knight");
    }

    @Override
    public String getQuote() {
        return "War seems like a fine adventure, the greatest most of them will ever know.\n" +
                "Then they get a taste of battle.";
    }

    @Override
    public int attack(Random random, HeroesService heroesService) {
        if (isSpecialAttack(heroesService.getRandomNumberBetweenOneAndOneHundred(random))) {
            return super.attack(new Random(), heroesService) * 2;
        } else {
            return super.attack(new Random(), heroesService);
        }
    }

    @Override
    public int defend(Random random, HeroesService heroesService) {
        if (isSpecialDefence(heroesService.getRandomNumberBetweenOneAndOneHundred(random))) {
            return Integer.MAX_VALUE;
        } else {
            return super.defend(new Random(), heroesService);
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