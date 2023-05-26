package com.IntermediateLevelOOP.AcademyOceanAssignment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outputMessages.printStartingHeroes(heroes);
        String expectedOutput = "ID=1 Hero: 'Assassin', healthPoints=100, attackPoints=25, armorPoints=20\r\nID=2 Hero: 'Warrior', healthPoints=100, attackPoints=25, armorPoints=20\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintStartingText() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outputMessages.printStartingText();
        String expectedOutput = "(Number must be even and between 4 and 256)\r\nPlease enter a number for the participants:\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintMenu() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outputMessages.printMenu();
        String expectedOutput = "---------------------------------------------\r\n\tWelcome to Heroes Fighting App\r\n---------------------------------------------\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintSeparator() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outputMessages.printSeparator();
        String expectedOutput = "---------------------------------------------\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }
}

