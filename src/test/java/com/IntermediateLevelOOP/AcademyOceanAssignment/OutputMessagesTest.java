package com.IntermediateLevelOOP.AcademyOceanAssignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class OutputMessagesTest {

    OutputMessages outputMessages;

    @BeforeEach
    void setOutputMessages() {
        outputMessages = new OutputMessages();
    }

    @Test
    void testPrintStartingHeroes() {
        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(new Assassin(1));
        heroes.add(new Warrior(2));
        outputMessages.printStartingHeroes(heroes);
    }

    @Test
    void testPrintMenu() {
        outputMessages.printMenu();
    }

    @Test
    void testPrintSeparator() {
        outputMessages.printSeparator();
    }
}

