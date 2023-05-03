package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.*;

public enum Locations {

    TEMPLE, CASTLE, BATTLEFIELD, WOODS;
    private static final Random RANDOM_NUMBER_GENERATOR = new Random();
    private static final List<Locations> locations = List.of(values());

    public static Locations getRandomLocation() {
        return locations.get(RANDOM_NUMBER_GENERATOR.nextInt(locations.size()));
    }
}
