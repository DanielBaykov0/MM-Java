package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.Random;

public class Monk extends Hero {

    public Monk(int id) {
        super(id, "Monk");
    }

    @Override
    public String getQuote() {
        return "But God will show mercy, though you show none.\n" +
                "And where is the merit of your boasted virtue?";
    }

    @Override
    public int defend(Random random, HeroesService heroesService) {
        if (isSpecialDefence(heroesService.getRandomNumberBetweenOneAndOneHundred(random))) {
            return Integer.MAX_VALUE;
        } else {
            return super.defend(new Random(), heroesService);
        }
    }

    private boolean isSpecialLocation(Locations location) {
        return Locations.TEMPLE.equals(location);
    }

    private boolean isSpecialDefence(int specialDefenceNumber) {
        int specialDefencePercent = 30;
        if (isSpecialLocation(FightersService.location)) {
            specialDefencePercent = 40;
        }
        return specialDefenceNumber <= specialDefencePercent;
    }
}