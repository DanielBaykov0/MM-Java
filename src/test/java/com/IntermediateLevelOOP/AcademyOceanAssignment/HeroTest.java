package com.IntermediateLevelOOP.AcademyOceanAssignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class HeroTest {

    private Hero hero;

    @BeforeEach
    void setHero() {
        hero = new Warrior(1);
    }

    @Test
    void testHeroAttack() {
        hero.setAttackPoints(10);
        int attackNumber = hero.attack(new Random());
        assertTrue(attackNumber >= 8 && attackNumber <= 12);
    }

    @Test
    void testCheckHeroHealthPoints() {
        hero.setHealthPoints(-2);
        hero.checkHeroHealthPoints();
        assertEquals(0, hero.getHealthPoints());
    }

    @Test
    void testGetHeroDamage() {
        hero.setAttackPoints(2);
        hero.setArmorPoints(10);
        assertEquals(0 ,hero.getHeroDamage());
    }

    // ASK !!!
    @Test
    void testIsHeroDead() {
        Hero heroMock = mock(Hero.class);
        doNothing().when(heroMock).isHeroDead();
        verify(heroMock, atLeastOnce());
    }

    @Test
    void testToString() {
        assertEquals("ID=1 Hero: 'Warrior', healthPoints=100, attackPoints=25, armorPoints=20",
                hero.toString());
    }
}

