package com.FoundationProgramPhase1.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class OutputMessagesTest {

    OutputMessages outputMessages;

    @BeforeEach
    void setOutputMessages() {
        outputMessages = new OutputMessages();
    }

    @Test
    void testEnterName() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outputMessages.enterName();
        String expectedOutput = "Please enter your full name: \r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testEnterPostponeDays() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outputMessages.enterPostponeDays();
        String expectedOutput = "Please enter how many days do you want to postpone the final date with: \r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testEnterBookTitle() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outputMessages.enterBookTitle();
        String expectedOutput = "Please enter book title: \r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testEnterBookGenre() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outputMessages.enterBookGenre();
        String expectedOutput = "Please enter book genre: \r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testEnterBookDescription() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outputMessages.enterBookDescription();
        String expectedOutput = "Please enter book description: \r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testEnterAuthorFirstName() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outputMessages.enterAuthorFirstName();
        String expectedOutput = "Please enter author's first name: \r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testEnterAuthorLastName() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outputMessages.enterAuthorLastName();
        String expectedOutput = "Please enter author's last name: \r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintBookNotAvailable() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outputMessages.printBookNotAvailable();
        String expectedOutput = "Sorry this book is not available\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintInvalidBookTitle() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outputMessages.printInvalidBookTitle();
        String expectedOutput = "Invalid book title\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintInvalidPostponeDays() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outputMessages.printInvalidPostponeDays();
        String expectedOutput = "You can only postpone up to 14 days max\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintWouldYouBorrowBook() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outputMessages.printWouldYouBorrowBook();
        String expectedOutput = "Would you like to borrow this book?(yes/no)\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintLibraryMenu() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outputMessages.printLibraryMenu();
        String expectedOutput = "Welcome to the Library!\r\n" +
                "Choose:\r\n" +
                "\t 1 - List all paper books.\r\n" +
                "\t 2 - Search a paper book by title.\r\n" +
                "\t 3 - Search a paper book by genre.\r\n" +
                "\t 4 - Search a paper book by description.\r\n" +
                "\t 5 - Search a paper book by author first name.\r\n" +
                "\t 6 - Search a paper book by author last name.\r\n" +
                "\t 7 - Print all books you borrowed.\r\n" +
                "\t 8 - Ask for postpone.\r\n" +
                "\t 9 - Go back to main menu.\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintEBookMenu() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outputMessages.printEBookMenu();
        String expectedOutput = "Welcome to the EBooks Paradise!\r\n" +
                "Choose:\r\n" +
                "\t 1 - List all Ebooks.\r\n" +
                "\t 2 - Print all readable Ebooks.\r\n" +
                "\t 3 - Print all downloadable Ebooks.\r\n" +
                "\t 4 - Choose an ebook to read online.\r\n" +
                "\t 5 - Choose an ebook to download.\r\n" +
                "\t 6 - Go back to main menu.\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintUsersMenu() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outputMessages.printUsersMenu();
        String expectedOutput = "Welcome!\r\n" +
                "Choose:\r\n" +
                "\t 1 - List all library users.\r\n" +
                "\t 2 - Go to the library.\r\n" +
                "\t 3 - Go to the ebook heaven.\r\n" +
                "\t 4 - Quit.\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }
}

