package com.IntermediateLevelOOP.AcademyOceanAssignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.Scanner;

import static org.mockito.Mockito.spy;

class FightersServiceTest {

    @InjectMocks
    FightersService fightersServiceConstructorInjectionMock;

    HeroesService heroesService;
    FinalStatistics finalStatistics;

    @BeforeEach
    void setUp() {
        heroesService = spy(HeroesService.class);
        finalStatistics = spy(FinalStatistics.class);
    }

    @Test
    void testGameLoopWithInputNumber4() {
        String number = "4\n";
        Scanner scanner = new Scanner(number);

        fightersServiceConstructorInjectionMock = new FightersService(scanner, finalStatistics, heroesService);
        fightersServiceConstructorInjectionMock.gameLoop();
    }

    @Test
    void testGameLoopWithInputNumber16() {
        String number = "16\n";
        Scanner scanner = new Scanner(number);

        fightersServiceConstructorInjectionMock = new FightersService(scanner, finalStatistics, heroesService);
        fightersServiceConstructorInjectionMock.gameLoop();
    }

    @Test
    void testGameLoopWithInputNumber10Then4() {
        String number = "10\n4\n";
        Scanner scanner = new Scanner(number);

        fightersServiceConstructorInjectionMock = new FightersService(scanner, finalStatistics, heroesService);
        fightersServiceConstructorInjectionMock.gameLoop();
    }

    @Test
    void testGameLoopWithInputStringThen4() {
        String number = "sad\n4\n";
        Scanner scanner = new Scanner(number);

        fightersServiceConstructorInjectionMock = new FightersService(scanner, finalStatistics, heroesService);
        fightersServiceConstructorInjectionMock.gameLoop();
    }
}

