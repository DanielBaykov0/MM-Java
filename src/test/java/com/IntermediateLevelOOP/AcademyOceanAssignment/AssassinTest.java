package com.IntermediateLevelOOP.AcademyOceanAssignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class AssassinTest {

    Assassin assassin;
    HeroesService heroesService;

    @BeforeEach
    void setAssassin() {
        assassin = new Assassin(0);
        heroesService = new HeroesService();
    }

    @Test
    void testAssassinConstructor() {
        assertEquals("One kills a man, one is an assassin; one kills millions,\n"
                + "one is a conqueror; one kills everybody, one is a god.", assassin.getQuote());
    }

    @Test
    void testAssassinNormalAttack() {
        assassin.setAttackPoints(20);
        Random randomMock = mock(Random.class, withSettings().withoutAnnotations());
        when(randomMock.nextInt(1, 101)).thenReturn(50);
        assertTrue(assassin.attack(randomMock, heroesService) >= 16 && assassin.attack(randomMock, heroesService) <= 24);
    }

    @Test
    void testAssassinSpecialAttack() {
        assassin.setAttackPoints(10);
        Random randomMock = mock(Random.class, withSettings().withoutAnnotations());
        when(randomMock.nextInt(1, 101)).thenReturn(30);
        int damage = assassin.attack(randomMock, heroesService);
        assertTrue(damage >= 24 && damage <= 36);
    }

    @RepeatedTest(10)
    void testAssassinSpecialLocationHigherAttack() {
        FightersService.location = Locations.WOODS;
        assassin.setAttackPoints(10);
        HeroesService heroesServiceMock = spy(HeroesService.class);

        Random randomMock = mock(Random.class, withSettings().withoutAnnotations());
        when(heroesServiceMock.getRandomNumberBetweenOneAndOneHundred(randomMock)).thenReturn(10);
        when(heroesServiceMock.getAssassinRandomSpecialAttackValue(randomMock)).thenReturn(10);

        int damage = assassin.attack(randomMock, heroesServiceMock);
        assertTrue(damage >= 36 && damage <= 54);
    }

    @RepeatedTest(10)
    void testAssassinSpecialLocationLowerAttack() {
        FightersService.location = Locations.WOODS;
        assassin.setAttackPoints(10);
        HeroesService heroesServiceMock = spy(HeroesService.class);

        Random randomMock = mock(Random.class, withSettings().withoutAnnotations());
        when(heroesServiceMock.getRandomNumberBetweenOneAndOneHundred(randomMock)).thenReturn(35);
        when(heroesServiceMock.getAssassinRandomSpecialAttackValue(randomMock)).thenReturn(35);

        int damage = assassin.attack(randomMock, heroesServiceMock);
        assertTrue(damage >= 24 && damage <= 36);
    }

    @Test
    void testAssassinNormalDefence() {
        assassin.setArmorPoints(20);
        assertTrue(assassin.defend(new Random(), heroesService) >= 16 && assassin.defend(new Random(), heroesService) <= 24);
    }
}

