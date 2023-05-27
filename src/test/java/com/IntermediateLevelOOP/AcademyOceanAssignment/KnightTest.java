package com.IntermediateLevelOOP.AcademyOceanAssignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class KnightTest {

    Knight knight;
    HeroesService heroesService;

    @BeforeEach
    void setKnight() {
        knight = new Knight(0);
        heroesService = new HeroesService();
    }

    @Test
    void testConstructor() {
        assertEquals("War seems like a fine adventure, the greatest most of them will ever know.\n"
                + "Then they get a taste of battle.", knight.getQuote());
    }

    @Test
    void testKnightNormalAttack() {
        knight.setAttackPoints(10);
        Random randomMock = mock(Random.class, withSettings().withoutAnnotations());
        when(randomMock.nextInt(1, 101)).thenReturn(20);
        assertTrue(knight.attack(randomMock, heroesService) >= 8 && knight.attack(randomMock, heroesService) <= 12);
    }

    @Test
    void testKnightSpecialAttack() {
        knight.setAttackPoints(10);
        Random randomMock = mock(Random.class, withSettings().withoutAnnotations());
        when(randomMock.nextInt(1, 101)).thenReturn(10);
        assertTrue(knight.attack(randomMock, heroesService) >= 16 && knight.attack(randomMock, heroesService) <= 24);
    }

    @Test
    void testKnightNormalDefence() {
       knight.setArmorPoints(10);
       Random randomMock = mock(Random.class, withSettings().withoutAnnotations());
       when(randomMock.nextInt(1, 101)).thenReturn(30);
       assertTrue(knight.defend(randomMock, heroesService) >= 8 && knight.defend(randomMock, heroesService) <= 12);
    }

    @Test
    void testKnightSpecialDefence() {
        knight.setArmorPoints(10);
        Random randomMock = mock(Random.class, withSettings().withoutAnnotations());
        when(randomMock.nextInt(1, 101)).thenReturn(18);
        assertEquals(Integer.MAX_VALUE, knight.defend(randomMock, heroesService));
    }
}

