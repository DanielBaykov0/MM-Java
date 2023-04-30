package com.IntermediateLevelOOP.AcademyOceanAssignment;

import java.util.ArrayList;
import java.util.List;

public class Locations {

    private static final List<String> locations = new ArrayList<>(List.of("Temple", "Castle", "Battlefield", "Woods"));

    public static List<String> getLocations() {
        return locations;
    }
}
