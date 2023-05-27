package com.IntermediateLevelOOP.AcademyOceanAssignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HeroesServiceTest {

    HeroesService heroesService;
    FinalStatistics finalStatistics;
    Hero knight;
    Hero warrior;

    @BeforeEach
    void setHeroesService() {
        heroesService = new HeroesService();
        finalStatistics = new FinalStatistics();
        knight = new Knight(1);
        warrior = new Warrior(2);
    }

    @Test
    void testResetHeroStats() {
        Warrior warrior = new Warrior(0);
        List<Hero> heroList = List.of(warrior);
        warrior.setHealthPoints(0);
        warrior.setAttackPoints(0);
        warrior.setArmorPoints(0);
        heroesService.resetHeroStats(heroList);
        assertEquals(100, warrior.getHealthPoints());
        assertEquals(25, warrior.getAttackPoints());
        assertEquals(20, warrior.getArmorPoints());
    }

    @Test
    void testGetRandomNumberBetweenOneAndOneHundred() {
        Random randomMock = mock(Random.class, withSettings().withoutAnnotations());
        when(randomMock.nextInt(1, 101)).thenReturn(10);
        int number = heroesService.getRandomNumberBetweenOneAndOneHundred(randomMock);
        assertEquals(10, number);
    }

    @Test
    void testGetAssassinRandomSpecialAttackValue() {
        List<Integer> specialValues = List.of(35, 10);
        Random randomMock = mock(Random.class, withSettings().withoutAnnotations());
        when(randomMock.nextInt(specialValues.size())).thenReturn(1);
        int number = heroesService.getAssassinRandomSpecialAttackValue(randomMock);
        assertEquals(10, number);
    }

    @Test
    void testIsFirstKnightLocation() {
        knight.setHealthPoints(100);
        knight.setArmorPoints(10);
        Assassin assassin = new Assassin(1);
        heroesService.isKnightLocation(FightersService.location = Locations.CASTLE, knight, assassin);
        assertEquals(110, knight.getHealthPoints());
        assertEquals(11, knight.getArmorPoints());
    }

    @Test
    void testIsSecondKnightLocation() {
        knight.setHealthPoints(100);
        knight.setArmorPoints(10);
        Assassin assassin = new Assassin(1);
        heroesService.isKnightLocation(FightersService.location = Locations.CASTLE, assassin, knight);
        assertEquals(110, knight.getHealthPoints());
        assertEquals(11, knight.getArmorPoints());
    }

    @Test
    void testIsFirstWarriorHealed() {
        Assassin assassin = new Assassin(1);
        heroesService.isWarriorHealed(FightersService.location = Locations.BATTLEFIELD, warrior, assassin, 100, 0);
        assertEquals(105, warrior.getHealthPoints());
    }

    @Test
    void testIsSecondWarriorHealed() {
        Assassin assassin = new Assassin(1);
        heroesService.isWarriorHealed(FightersService.location = Locations.BATTLEFIELD, assassin, warrior, 0, 100);
        assertEquals(105, warrior.getHealthPoints());
    }


    @Test
    void testGenerateHeroes() {
        assertEquals(10, heroesService.generateHeroes(10).size());
    }

    @Test
    void testIsFinal() {
        List<Hero> heroes = List.of(new Warrior(0), new Assassin(1));
        heroesService.isFinal(heroes);
        assertEquals(2, heroes.size());
        assertEquals(heroes, heroesService.getFinalTwoStanding());
    }

    // HERO STORE MAP
    @Test
    void testGenerateHeroStoreMap() {
        List<Hero> heroes = List.of(new Warrior(0), new Assassin(1));
        heroesService.generateHeroStoreMap(heroes);
        assertFalse(heroesService.getHeroesHashMapStore().isEmpty());
        assertEquals(2, heroesService.getHeroesHashMapStore().size());
    }

    @Test
    void testGenerateLosers() {
        List<Hero> heroes = List.of(new Warrior(0), new Assassin(1));
        heroesService.generateHeroStoreMap(heroes);
        List<Hero> heroesList = List.of(new Monk(0), new Assassin(1));
        heroesService.getFinalTwoStanding().addAll(heroesList);
        heroesService.generateLosers();
        assertFalse(heroesService.getLosers().isEmpty());
        assertEquals(1, heroesService.getLosers().size());
    }

    // ID FIGHTS MAP
    @Test
    void testPutFirstHeroIDFightsMap() {
        Assassin firstHero = new Assassin(1);
        List<Hero> heroes = List.of(new Assassin(1));
        heroesService.putFirstHeroIDFightsMap(firstHero, heroes);
        assertEquals(1, heroesService.getHeroesIDFightsMap().size());
        assertFalse(heroesService.getHeroesIDFightsMap().isEmpty());
        assertTrue(heroesService.getHeroesIDFightsMap().containsKey(firstHero.getId()));
    }

    @Test
    void testCheckFirstHeroFights() {
        Assassin firstHero = new Assassin(1);
        heroesService.getHeroesIDFightsMap().put(firstHero.getId(), finalStatistics.getFirstHeroFights());
        assertEquals(0, finalStatistics.getFirstHeroFights());
        finalStatistics.setFirstHeroFights(2);
        heroesService.checkFirstHeroFights(firstHero);
        assertEquals(2, finalStatistics.getFirstHeroFights());
    }

    @Test
    void testPutSecondHeroIDFightsMap() {
        Monk secondHero = new Monk(1);
        List<Hero> heroes = List.of(new Monk(1));
        heroesService.putSecondHeroIDFightsMap(secondHero, heroes);
        assertEquals(1, heroesService.getHeroesIDFightsMap().size());
        assertFalse(heroesService.getHeroesIDFightsMap().isEmpty());
        assertTrue(heroesService.getHeroesIDFightsMap().containsKey(secondHero.getId()));
    }

    @Test
    void testCheckSecondHeroFights() {
        Monk secondHero = new Monk(1);
        heroesService.getHeroesIDFightsMap().put(secondHero.getId(), finalStatistics.getSecondHeroFights());
        assertEquals(0, finalStatistics.getSecondHeroFights());
        finalStatistics.setSecondHeroFights(2);
        heroesService.checkSecondHeroFights(secondHero);
        assertEquals(2, finalStatistics.getSecondHeroFights());
    }

    // ID HIGHEST DAMAGE MAP
    @Test
    void testPutFirstHeroIDHighestDamageMap() {
        Warrior firstHero = new Warrior(1);
        List<Hero> heroes = List.of(new Warrior(1));
        firstHero.setAttackPoints(100);
        finalStatistics.setFirstHeroHighestDamageValue(1);
        heroesService.putFirstHeroIDHighestDamageMap(firstHero, heroes, finalStatistics.getFirstHeroHighestDamageValue());
        assertEquals(1, heroesService.getHeroesIDHighestDamageMap().size());
        assertFalse(heroesService.getHeroesIDHighestDamageMap().isEmpty());
        assertTrue(heroesService.getHeroesIDHighestDamageMap().containsKey(firstHero.getId()));
    }

    @Test
    void testCheckFirstHeroHighestDamageValue() {
        Warrior firstHero = new Warrior(1);
        heroesService.getHeroesIDHighestDamageMap().put(firstHero.getId(), finalStatistics.getFirstHeroHighestDamageValue());
        assertEquals(0, finalStatistics.getFirstHeroHighestDamageValue());
        finalStatistics.setFirstHeroHighestDamageValue(200);
        heroesService.checkFirstHeroHighestDamageValue(firstHero);
        assertEquals(200, finalStatistics.getFirstHeroHighestDamageValue());
    }

    @Test
    void testPutSecondHeroIDHighestDamageMap() {
        Warrior secondHero = new Warrior(1);
        List<Hero> heroes = List.of(new Warrior(1));
        secondHero.setAttackPoints(100);
        finalStatistics.setSecondHeroHighestDamageValue(1);
        heroesService.putSecondHeroIDHighestDamageMap(secondHero, heroes, finalStatistics.getSecondHeroHighestDamageValue());
        assertEquals(1, heroesService.getHeroesIDHighestDamageMap().size());
        assertFalse(heroesService.getHeroesIDHighestDamageMap().isEmpty());
        assertTrue(heroesService.getHeroesIDHighestDamageMap().containsKey(secondHero.getId()));
    }

    @Test
    void testCheckSecondHeroHighestDamageValue() {
        Warrior secondHero = new Warrior(1);
        heroesService.getHeroesIDHighestDamageMap().put(secondHero.getId(), finalStatistics.getSecondHeroHighestDamageValue());
        assertEquals(0, finalStatistics.getSecondHeroHighestDamageValue());
        finalStatistics.setSecondHeroHighestDamageValue(200);
        heroesService.checkSecondHeroHighestDamageValue(secondHero);
        assertEquals(200, finalStatistics.getSecondHeroHighestDamageValue());
    }

    // ID DAMAGE / BATTLES MAP
    @Test
    void testPutFirstHeroIDDamageBattlesMap() {
        Knight firstHero = new Knight(1);
        List<Hero> heroes = List.of(new Knight(1));
        heroesService.putFirstHeroIDDamageBattlesMap(firstHero, heroes, finalStatistics.getFirstHeroDamageValue());
        heroesService.putFirstHeroIDDamageBattlesMap(firstHero, heroes, finalStatistics.getFirstHeroBattle());

        assertEquals(1, heroesService.getHeroesIDDamageMap().size());
        assertFalse(heroesService.getHeroesIDDamageMap().isEmpty());
        assertTrue(heroesService.getHeroesIDDamageMap().containsKey(firstHero.getId()));

        assertEquals(1, heroesService.getHeroesIDBattlesMap().size());
        assertFalse(heroesService.getHeroesIDBattlesMap().isEmpty());
        assertTrue(heroesService.getHeroesIDBattlesMap().containsKey(firstHero.getId()));
    }

    @Test
    void testCheckFirstHeroDamageValue() {
        Knight firstHero = new Knight(1);
        heroesService.getHeroesIDDamageMap().put(firstHero.getId(), finalStatistics.getFirstHeroDamageValue());
        assertEquals(0, finalStatistics.getFirstHeroDamageValue());
        finalStatistics.setFirstHeroDamageValue(200);
        heroesService.checkFirstHeroDamageValue(firstHero);
        assertEquals(200, finalStatistics.getFirstHeroDamageValue());
    }

    @Test
    void testCheckFirstHeroBattles() {
        Knight firstHero = new Knight(1);
        heroesService.getHeroesIDBattlesMap().put(firstHero.getId(), finalStatistics.getFirstHeroBattle());
        assertEquals(0, finalStatistics.getFirstHeroBattle());
        finalStatistics.setFirstHeroBattle(10);
        heroesService.checkFirstHeroBattles(firstHero);
        assertEquals(10, finalStatistics.getFirstHeroBattle());
    }

    @Test
    void testPutSecondHeroIDDamageBattlesMap() {
        Knight secondHero = new Knight(1);
        List<Hero> heroes = List.of(new Knight(1));
        heroesService.putFirstHeroIDDamageBattlesMap(secondHero, heroes, finalStatistics.getSecondHeroDamageValue());
        heroesService.putFirstHeroIDDamageBattlesMap(secondHero, heroes, finalStatistics.getSecondHeroBattle());

        assertEquals(1, heroesService.getHeroesIDDamageMap().size());
        assertFalse(heroesService.getHeroesIDDamageMap().isEmpty());
        assertTrue(heroesService.getHeroesIDDamageMap().containsKey(secondHero.getId()));

        assertEquals(1, heroesService.getHeroesIDBattlesMap().size());
        assertFalse(heroesService.getHeroesIDBattlesMap().isEmpty());
        assertTrue(heroesService.getHeroesIDBattlesMap().containsKey(secondHero.getId()));
    }

    @Test
    void testCheckSecondHeroDamageValue() {
        Knight secondHero = new Knight(1);
        heroesService.getHeroesIDDamageMap().put(secondHero.getId(), finalStatistics.getSecondHeroDamageValue());
        assertEquals(0, finalStatistics.getSecondHeroDamageValue());
        finalStatistics.setSecondHeroDamageValue(200);
        heroesService.checkSecondHeroDamageValue(secondHero);
        assertEquals(200, finalStatistics.getSecondHeroDamageValue());
    }

    @Test
    void testCheckSecondHeroBattles() {
        Knight secondHero = new Knight(1);
        heroesService.getHeroesIDBattlesMap().put(secondHero.getId(), finalStatistics.getSecondHeroBattle());
        assertEquals(0, finalStatistics.getSecondHeroBattle());
        finalStatistics.setSecondHeroBattle(10);
        heroesService.checkSecondHeroBattles(secondHero);
        assertEquals(10, finalStatistics.getSecondHeroBattle());
    }

    // HIGHEST NUMBER OF SUCCESSFUL ATTACK DODGES
    @Test
    void testPutFirstHeroHighestNumberOfSuccessfulAttackDodges() {
        Warrior secondHero = new Warrior(1);
        List<Hero> heroes = List.of(new Warrior(1));
        finalStatistics.setSecondHeroDamageValue(0);
        heroesService.putFirstHeroHighestNumberOfSuccessfulAttackDodges(secondHero, heroes, finalStatistics.getSecondHeroDamageValue());
        assertEquals(1, heroesService.getHeroesIDHighestNumberOfSuccessfulAttackDodgesMap().size());
        assertFalse(heroesService.getHeroesIDHighestNumberOfSuccessfulAttackDodgesMap().isEmpty());
        assertTrue(heroesService.getHeroesIDHighestNumberOfSuccessfulAttackDodgesMap().containsKey(secondHero.getId()));
    }

    @Test
    void testCheckFirstHeroHighestNumberOfSuccessfulAttackDodges() {
        Warrior firstHero = new Warrior(1);
        heroesService.getHeroesIDHighestNumberOfSuccessfulAttackDodgesMap().put(firstHero.getId(), finalStatistics.getFirstHeroHighestNumberOfSuccessfulAttackDodges());
        assertEquals(0, finalStatistics.getFirstHeroHighestNumberOfSuccessfulAttackDodges());
        finalStatistics.setFirstHeroHighestNumberOfSuccessfulAttackDodges(10);
        heroesService.checkFirstHeroHighestNumberOfSuccessfulAttackDodges(firstHero);
        assertEquals(10, finalStatistics.getFirstHeroHighestNumberOfSuccessfulAttackDodges());
    }

    @Test
    void testPutSecondHeroHighestNumberOfSuccessfulAttackDodges() {
        Warrior firstHero = new Warrior(1);
        List<Hero> heroes = List.of(new Warrior(1));
        finalStatistics.setFirstHeroDamageValue(0);
        heroesService.putFirstHeroHighestNumberOfSuccessfulAttackDodges(firstHero, heroes, finalStatistics.getFirstHeroDamageValue());
        assertEquals(1, heroesService.getHeroesIDHighestNumberOfSuccessfulAttackDodgesMap().size());
        assertFalse(heroesService.getHeroesIDHighestNumberOfSuccessfulAttackDodgesMap().isEmpty());
        assertTrue(heroesService.getHeroesIDHighestNumberOfSuccessfulAttackDodgesMap().containsKey(firstHero.getId()));
    }

    @Test
    void testCheckSecondHeroHighestNumberOfSuccessfulAttackDodges() {
        Warrior secondHero = new Warrior(1);
        heroesService.getHeroesIDHighestNumberOfSuccessfulAttackDodgesMap().put(secondHero.getId(), finalStatistics.getSecondHeroHighestNumberOfSuccessfulAttackDodges());
        assertEquals(0, finalStatistics.getSecondHeroHighestNumberOfSuccessfulAttackDodges());
        finalStatistics.setSecondHeroHighestNumberOfSuccessfulAttackDodges(10);
        heroesService.checkSecondHeroHighestNumberOfSuccessfulAttackDodges(secondHero);
        assertEquals(10, finalStatistics.getSecondHeroHighestNumberOfSuccessfulAttackDodges());
    }

    // PRINT FINALISTS
    @Test
    void testPrintTwoFinalistsStats() {
        List<Hero> heroes = List.of(new Warrior(1), new Assassin(2));
        heroesService.setFinalTwoStanding(heroes);
        heroesService.printTwoFinalistsStats();
        assertFalse(heroesService.getFinalTwoStanding().isEmpty());
        assertEquals(2, heroesService.getFinalTwoStanding().size());
    }

    @Test
    void testPrintFinalistsIDDamageInfo() {
        Monk firstHero = new Monk(1);
        Warrior secondHero = new Warrior(2);
        heroesService.getFinalistsIDDamageMap().put(firstHero.getId(), firstHero.getFirstHeroDamage(firstHero, secondHero));
        heroesService.getFinalistsIDDamageMap().put(secondHero.getId(), secondHero.getSecondHeroDamage(secondHero, firstHero));
        heroesService.printFinalistsIDDamageInfo();
        assertFalse(heroesService.getFinalistsIDDamageMap().isEmpty());
        assertEquals(2, heroesService.getFinalistsIDDamageMap().size());

    }

    @Test
    void testPrintFinalistsIDFightsInfo() {
        Monk firstHero = new Monk(1);
        Warrior secondHero = new Warrior(2);
        heroesService.getFinalistsIDFigthsMap().put(firstHero.getId(), finalStatistics.getFirstHeroFights());
        heroesService.getFinalistsIDFigthsMap().put(secondHero.getId(), finalStatistics.getSecondHeroFights());
        heroesService.printFinalistsIDFightsInfo();
        assertFalse(heroesService.getFinalistsIDFigthsMap().isEmpty());
        assertEquals(2, heroesService.getFinalistsIDFigthsMap().size());
    }

    @Test
    void testPrintFinalistsIDBattleInfo() {
        Monk firstHero = new Monk(1);
        Warrior secondHero = new Warrior(2);
        heroesService.getFinalistsIDBattlesMap().put(firstHero.getId(), finalStatistics.getFirstHeroBattle());
        heroesService.getFinalistsIDBattlesMap().put(secondHero.getId(), finalStatistics.getSecondHeroBattle());
        heroesService.printFinalistsIDBattleInfo();
        assertFalse(heroesService.getFinalistsIDBattlesMap().isEmpty());
        assertEquals(2, heroesService.getFinalistsIDBattlesMap().size());
    }

    // PRINT LOSERS
    @Test
    void testPrintTopTwoLosersHighestDamageValueInfo() {
        heroesService.getTopTwoLosersHighestDamageValue().add(finalStatistics.getFirstHeroHighestDamageValue());
        heroesService.getTopTwoLosersHighestDamageValue().add(finalStatistics.getSecondHeroHighestDamageValue());
        heroesService.printTopTwoLosersHighestDamageValueInfo();
        assertFalse(heroesService.getTopTwoLosersHighestDamageValue().isEmpty());
        assertEquals(2, heroesService.getTopTwoLosersHighestDamageValue().size());
    }

    @Test
    void testPrintTopTwoLosersHighestNumberOfSuccessfulAttackDodgesInfo() {
        heroesService.getTopTwoLosersHighestNumberOfSuccessfulAttackDodges().add(finalStatistics.getFirstHeroHighestNumberOfSuccessfulAttackDodges());
        heroesService.getTopTwoLosersHighestNumberOfSuccessfulAttackDodges().add(finalStatistics.getSecondHeroHighestNumberOfSuccessfulAttackDodges());
        heroesService.printTopTwoLosersHighestNumberOfSuccessfulAttackDodgesInfo();
        assertFalse(heroesService.getTopTwoLosersHighestNumberOfSuccessfulAttackDodges().isEmpty());
        assertEquals(2, heroesService.getTopTwoLosersHighestNumberOfSuccessfulAttackDodges().size());
    }
}

