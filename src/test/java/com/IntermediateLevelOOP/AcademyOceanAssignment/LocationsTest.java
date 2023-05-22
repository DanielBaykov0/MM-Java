package com.IntermediateLevelOOP.AcademyOceanAssignment;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LocationsTest {

    @Test
    void testGetRandomLocation() {
        List<Locations> locationsList = List.of(Locations.values());
        Locations location = Locations.getRandomLocation();
        assertTrue(locationsList.contains(location));
    }
}

