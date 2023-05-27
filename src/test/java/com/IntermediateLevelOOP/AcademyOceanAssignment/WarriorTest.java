package com.IntermediateLevelOOP.AcademyOceanAssignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WarriorTest {

    Warrior warrior;
    FightersService fightersService;
    HeroesService heroesService;

    @BeforeEach
    void setWarrior() {
        warrior = new Warrior(0);
        fightersService = new FightersService();
        heroesService = new HeroesService();
    }

    @Test
    void testWarriorConstructor() {
        String warriorString = warrior.toString();
        assertEquals("If you're a true warrior, competition doesn't scare you.\nIt makes you better.",
                warrior.getQuote());
        assertEquals("ID=0 Hero: 'Warrior', healthPoints=100, attackPoints=25, armorPoints=20", warriorString);
    }

    @Test
    void testWarriorNormalAttack() {
        warrior.setAttackPoints(20);
        FightersService.location = Locations.TEMPLE;
        assertTrue(warrior.attack(new Random(), heroesService) >= 16 && warrior.attack(new Random(), heroesService) <= 24);
    }

    @Test
    void testWarriorSpecialAttack() {
        FightersService.location = Locations.BATTLEFIELD;
        warrior.setAttackPoints(10);
        Random randomMock = mock(Random.class, withSettings().withoutAnnotations());
        when(randomMock.nextInt(1, 101)).thenReturn(10);
        int damage = warrior.attack(randomMock, heroesService);
        assertFalse(damage < 12 || damage > 18);
    }

    @Test
    void testWarriorNormalDefence() {
        warrior.setArmorPoints(20);
        assertTrue(warrior.defend(new Random(), heroesService) >= 16 && warrior.defend(new Random(), heroesService) <= 24);
    }
}

