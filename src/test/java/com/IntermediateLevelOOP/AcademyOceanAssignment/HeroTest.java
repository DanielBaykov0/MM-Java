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

class HeroTest {

    private Hero firstHero;
    private Hero secondHero;
    private Hero thirdHero;
    HeroesService heroesService;

    @BeforeEach
    void setHero() {
        firstHero = new Warrior(1);
        secondHero = new Assassin(2);
        thirdHero = new Monk(3);
        heroesService = new HeroesService();
    }

    @Test
    void testHeroAttack() {
        firstHero.setAttackPoints(10);
        int attackNumber = firstHero.attack(new Random(), heroesService);
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
        assertEquals(0 , firstHero.getFirstHeroDamage(firstHero, secondHero));
    }

    @RepeatedTest(10)
    void testGetFirstHeroDamage() {
        secondHero.setArmorPoints(1);
        assertTrue(firstHero.getFirstHeroDamage(firstHero, secondHero) > 0);
    }

    @RepeatedTest(10)
    void testGetSecondHeroZeroDamage() {
        thirdHero.setAttackPoints(2);
        assertEquals(0 , thirdHero.getSecondHeroDamage(thirdHero, firstHero));
    }

    @RepeatedTest(10)
    void testGetSecondHeroDamage() {
        firstHero.setArmorPoints(1);
        assertTrue(thirdHero.getSecondHeroDamage(thirdHero, firstHero) > 0);
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
    void testHashCode() {
        Warrior warrior1 = new Warrior(7);
        Warrior warrior2 = new Warrior(7);
        assertTrue(warrior1.equals(warrior2) && warrior2.equals(warrior1));
        assertEquals(warrior1.hashCode(), warrior2.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("ID=1 Hero: 'Warrior', healthPoints=100, attackPoints=25, armorPoints=20",
                firstHero.toString());
    }
}

