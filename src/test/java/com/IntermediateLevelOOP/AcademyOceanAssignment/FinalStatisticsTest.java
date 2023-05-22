package com.IntermediateLevelOOP.AcademyOceanAssignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinalStatisticsTest {

    @Test
    void testConstructor() {
        FinalStatistics actualFinalStatistics = new FinalStatistics();
        actualFinalStatistics.setFirstHeroBattle(1);
        actualFinalStatistics.setFirstHeroDamageValue(42);
        actualFinalStatistics.setFirstHeroFights(1);
        actualFinalStatistics.setFirstHeroHighestDamageValue(42);
        actualFinalStatistics.setFirstHeroHighestNumberOfSuccessfulAttackDodges(10);
        actualFinalStatistics.setRounds(1);
        actualFinalStatistics.setSecondHeroBattle(1);
        actualFinalStatistics.setSecondHeroDamageValue(42);
        actualFinalStatistics.setSecondHeroFights(1);
        actualFinalStatistics.setSecondHeroHighestDamageValue(42);
        actualFinalStatistics.setSecondHeroHighestNumberOfSuccessfulAttackDodges(10);
        assertEquals(1, actualFinalStatistics.getFirstHeroBattle());
        assertEquals(42, actualFinalStatistics.getFirstHeroDamageValue());
        assertEquals(1, actualFinalStatistics.getFirstHeroFights());
        assertEquals(42, actualFinalStatistics.getFirstHeroHighestDamageValue());
        assertEquals(10, actualFinalStatistics.getFirstHeroHighestNumberOfSuccessfulAttackDodges());
        assertEquals(1, actualFinalStatistics.getRounds());
        assertEquals(1, actualFinalStatistics.getSecondHeroBattle());
        assertEquals(42, actualFinalStatistics.getSecondHeroDamageValue());
        assertEquals(1, actualFinalStatistics.getSecondHeroFights());
        assertEquals(42, actualFinalStatistics.getSecondHeroHighestDamageValue());
        assertEquals(10, actualFinalStatistics.getSecondHeroHighestNumberOfSuccessfulAttackDodges());
    }
}

