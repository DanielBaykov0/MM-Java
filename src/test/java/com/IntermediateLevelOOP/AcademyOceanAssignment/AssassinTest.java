package com.IntermediateLevelOOP.AcademyOceanAssignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;
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
        assertTrue(assassin.attack(randomMock) >= 16 && assassin.attack(randomMock) <= 24);
    }

    @Test
    void testAssassinSpecialAttack() {
        assassin.setAttackPoints(10);
        Random randomMock = mock(Random.class, withSettings().withoutAnnotations());
        when(randomMock.nextInt(1, 101)).thenReturn(30);
        int damage = assassin.attack(randomMock);
        assertTrue(damage >= 24 && damage <= 36);
    }

    @Test
    void testAssassinSpecialLocationHigherAttack() {
        FightersService.location = Locations.WOODS;
        assassin.setAttackPoints(10);
        List<Integer> specialValues = List.of(35, 10);
        Random randomMock = mock(Random.class, withSettings().withoutAnnotations());
        when(randomMock.nextInt(1, 101)).thenReturn(10);
        int damage = assassin.attack(randomMock);
        assertTrue(damage >= 36 && damage <= 54);
    }

    @RepeatedTest(10)
    void testAssassinSpecialLocationLowerAttack() {
        FightersService.location = Locations.WOODS;
        assassin.setAttackPoints(10);
        Random randomMock = mock(Random.class, withSettings().withoutAnnotations());
        when(randomMock.nextInt(1, 101)).thenReturn(35);
        List<Integer> specialValues = List.of(35, 10);

        HeroesService mockHeroService = mock(HeroesService.class);
        when(mockHeroService.getAssassinRandomSpecialAttackValue(randomMock, specialValues)).thenReturn(35);

        int damage = assassin.attack(randomMock);
        assertTrue(damage >= 24 && damage <= 36);
    }

    @Test
    void testAssassinNormalDefence() {
        assassin.setArmorPoints(20);
        assertTrue(assassin.defend(new Random()) >= 16 && assassin.defend(new Random()) <= 24);
    }
}

