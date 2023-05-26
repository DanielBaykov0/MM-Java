package com.IntermediateLevelOOP.AcademyOceanAssignment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class HeroTest {

    private Hero firstHero;
    private Hero secondHero;

    @BeforeEach
    void setHero() {
        firstHero = new Warrior(1);
        secondHero = new Monk(2);
    }

    @Test
    void testHeroAttack() {
        firstHero.setAttackPoints(10);
        int attackNumber = firstHero.attack(new Random());
        assertTrue(attackNumber >= 8 && attackNumber <= 12);
    }

    @Test
    void testCheckHeroHealthPoints() {
        firstHero.setHealthPoints(-2);
        firstHero.checkHeroHealthPoints();
        assertEquals(0, firstHero.getHealthPoints());
    }

    @RepeatedTest(10)
    void testGetFirstHeroZeroDamage() {
        firstHero.setAttackPoints(2);
        Random randomMock = mock(Random.class, withSettings().withoutAnnotations());
        HeroesService mockHeroService = mock(HeroesService.class);
        when(mockHeroService.getRandomNumberBetweenOneAndOneHundred(randomMock)).thenReturn(0);
        assertEquals(0 , firstHero.getFirstHeroDamage(firstHero, secondHero));
    }

    @RepeatedTest(10)
    void testGetFirstHeroDamage() {
        secondHero.setArmorPoints(1);
        Random randomMock = mock(Random.class, withSettings().withoutAnnotations());
        int damage = firstHero.getFirstHeroDamage(firstHero, secondHero);
        HeroesService mockHeroService = mock(HeroesService.class);
        when(mockHeroService.getRandomNumberBetweenOneAndOneHundred(randomMock)).thenReturn(50);
//        when(secondHero.defend(randomMock)).thenReturn(1);
        assertEquals(10, damage);
    }

    @Test
    void testIsHeroDead() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        firstHero.printHeroDied();
        String expectedOutput = "\r\nWarrior died...\r\n\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testToString() {
        assertEquals("ID=1 Hero: 'Warrior', healthPoints=100, attackPoints=25, armorPoints=20",
                firstHero.toString());
    }
}

