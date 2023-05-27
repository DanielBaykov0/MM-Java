package com.IntermediateLevelOOP.AcademyOceanAssignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class MonkTest {

    Monk monk;
    HeroesService heroesService;

    @BeforeEach
    void setMonk() {
        monk = new Monk(0);
        heroesService = new HeroesService();
    }

    @Test
    void testConstructor() {
        assertEquals("But God will show mercy, though you show none.\nAnd where is the merit of your boasted virtue?",
                monk.getQuote());
    }

    @Test
    void testMonkNormalAttack() {
        monk.setAttackPoints(10);
        assertTrue(monk.attack(new Random(), heroesService) >= 8 && monk.attack(new Random(), heroesService) <= 12);
    }

    @Test
    void testMonkNormalDefence() {
        monk.setArmorPoints(10);
        Random randomMock = mock(Random.class, withSettings().withoutAnnotations());
        when(randomMock.nextInt(1, 101)).thenReturn(50);
        assertTrue(monk.defend(randomMock, heroesService) >= 8 && monk.defend(randomMock, heroesService) <= 12);
    }

    @Test
    void testMonkSpecialDefence() {
        FightersService.location = Locations.WOODS;
        Random randomMock = mock(Random.class, withSettings().withoutAnnotations());
        when(randomMock.nextInt(1, 101)).thenReturn(30);
        assertEquals(Integer.MAX_VALUE, monk.defend(randomMock, heroesService));
    }

    @Test
    void testMonkSpecialLocationDefence() {
        FightersService.location = Locations.TEMPLE;
        Random randomMock = mock(Random.class, withSettings().withoutAnnotations());
        when(randomMock.nextInt(1, 101)).thenReturn(40);
        assertEquals(Integer.MAX_VALUE, monk.defend(randomMock, heroesService));
    }
}

