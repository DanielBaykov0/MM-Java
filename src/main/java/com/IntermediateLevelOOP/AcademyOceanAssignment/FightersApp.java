package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.Scanner;

public class FightersApp {

    public static void main(String[] args) {

        FightersService fightersService = new FightersService(new Scanner(System.in), new FinalStatistics(), new HeroesService());
        fightersService.gameLoop();
    }
}
