package com.FoundationProgramPhase1.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {

    @Test
    void testAuthorConstructor() {

        String authorFirstName = "";
        String authorLastName = "";
        String authorCountryBorn = "";
        boolean isAuthorAlive = false;

        Author actualAuthor = new Author(authorFirstName, authorLastName, authorCountryBorn, null, isAuthorAlive, null);
        assertEquals(authorFirstName, actualAuthor.getAuthorFirstName());
        assertEquals(authorLastName, actualAuthor.getAuthorLastName());
        assertEquals(authorCountryBorn, actualAuthor.getAuthorCountryBorn());
        assertNull(actualAuthor.getAuthorBirthDate());
        assertEquals(isAuthorAlive, actualAuthor.isAuthorAlive());
        assertNull(actualAuthor.getAuthorDeathDate());
    }

    @Test
    void testAuthorEquals() {
        Author author1 = new Author("James", "Cameron", "USA", LocalDate.of(1965, 10, 26), true, null);
        Author author2 = new Author("James", "Cameron", "USA", LocalDate.of(1965, 10, 26), true, null);
        assertNotEquals(author1, null);
        assertEquals(author1, author2);
    }

    @Test
    void testAuthorNotEquals() {
        Author author1 = new Author("James", "Cameron", "USA", LocalDate.of(1965, 10, 26), true, null);
        Author author2 = new Author("James", "Cameron", "USA", LocalDate.of(1965, 10, 26), false, null);
        assertNotEquals(author1, author2);
    }

    @Test
    void testAuthorHashcode() {
        Author author1 = new Author("James", "Cameron", "USA", LocalDate.of(1965, 10, 26), true, null);
        Author author2 = new Author("James", "Cameron", "USA", LocalDate.of(1965, 10, 26), true, null);
        assertTrue(author1.equals(author2) && author2.equals(author1));
        assertEquals(author1.hashCode(), author2.hashCode());
    }

    @Test
    void testAuthorToString() {
        Author author = new Author("James", "Cameron", "USA", LocalDate.of(1965, 10, 26), true, null);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.out.println(author);
        String expectedOutput = "Author{authorFirstName='James', authorLastName='Cameron', authorCountryBorn='USA', authorBirthDate=1965-10-26, isAuthorAlive=true, authorDeathDate=null}\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }
}

