package com.IntermediateLevelOOP.AcademyOceanAssignment;

public class FightersApp {

    public static void main(String[] args) {

        FightersService fightersService = new FightersService(new FinalStatistics(), new HeroesService(), new OutputMessages());
        fightersService.gameLoop();
    }
}
