package com.IntermediateLevelOOP.AcademyOceanAssignment;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class FightersServiceTest {

    @Test
    void testGameLoop() {
        String input = "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        FightersService.gameLoop();
    }
}

