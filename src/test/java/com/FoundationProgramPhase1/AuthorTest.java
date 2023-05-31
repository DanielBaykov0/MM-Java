package com.FoundationProgramPhase1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AuthorTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Author#Author(String, String, LocalDate, boolean, LocalDate)}
     *   <li>{@link Author#getAuthorBirthDate()}
     *   <li>{@link Author#getAuthorCountryBorn()}
     *   <li>{@link Author#getAuthorDeathDate()}
     *   <li>{@link Author#getAuthorName()}
     *   <li>{@link Author#isAuthorAlive()}
     *   <li>{@link Author#toString()}
     * </ul>
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R006 Static initializer failed.
        //   The static initializer of
        //   org.mockito.Mockito
        //   threw java.lang.NoClassDefFoundError while trying to load it.
        //   Make sure the static initializer of Mockito
        //   can be executed without throwing exceptions.
        //   Exception: java.lang.NoClassDefFoundError: Could not initialize class org.mockito.Mockito
        //       at java.util.ArrayList.forEach(ArrayList.java:1511)

        // Arrange
        // TODO: Populate arranged inputs
        String authorName = "";
        String authorCountryBorn = "";
        LocalDate authorBirthDate = null;
        boolean isAuthorAlive = false;
        LocalDate authorDeathDate = null;

        // Act
        Author actualAuthor = new Author(authorName, authorCountryBorn, authorBirthDate, isAuthorAlive, authorDeathDate);
        LocalDate actualAuthorBirthDate = actualAuthor.getAuthorBirthDate();
        String actualAuthorCountryBorn = actualAuthor.getAuthorCountryBorn();
        LocalDate actualAuthorDeathDate = actualAuthor.getAuthorDeathDate();
        String actualAuthorName = actualAuthor.getAuthorName();
        boolean actualIsAuthorAliveResult = actualAuthor.isAuthorAlive();
        String actualToStringResult = actualAuthor.toString();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link Author#equals(Object)}
     */
    @Test
    void testEquals() {
        LocalDate authorBirthDate = LocalDate.of(1970, 1, 1);
        assertNotEquals(new Author("JaneDoe", "GB", authorBirthDate, true, LocalDate.of(1970, 1, 1)), null);
    }

    /**
     * Method under test: {@link Author#equals(Object)}
     */
    @Test
    void testEquals2() {
        LocalDate authorBirthDate = LocalDate.of(1970, 1, 1);
        assertNotEquals(new Author("JaneDoe", "GB", authorBirthDate, true, LocalDate.of(1970, 1, 1)),
                "Different type to Author");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Author#equals(Object)}
     *   <li>{@link Author#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        LocalDate authorBirthDate = LocalDate.of(1970, 1, 1);
        Author author = new Author("JaneDoe", "GB", authorBirthDate, true, LocalDate.of(1970, 1, 1));
        assertEquals(author, author);
        int expectedHashCodeResult = author.hashCode();
        assertEquals(expectedHashCodeResult, author.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Author#equals(Object)}
     *   <li>{@link Author#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        LocalDate authorBirthDate = LocalDate.of(1970, 1, 1);
        Author author = new Author("JaneDoe", "GB", authorBirthDate, true, LocalDate.of(1970, 1, 1));
        LocalDate authorBirthDate2 = LocalDate.of(1970, 1, 1);
        Author author2 = new Author("JaneDoe", "GB", authorBirthDate2, true, LocalDate.of(1970, 1, 1));

        assertEquals(author, author2);
        int expectedHashCodeResult = author.hashCode();
        assertEquals(expectedHashCodeResult, author2.hashCode());
    }

    /**
     * Method under test: {@link Author#equals(Object)}
     */
    @Test
    void testEquals5() {
        LocalDate authorBirthDate = LocalDate.of(1970, 1, 1);
        Author author = new Author("Author Name", "GB", authorBirthDate, true, LocalDate.of(1970, 1, 1));
        LocalDate authorBirthDate2 = LocalDate.of(1970, 1, 1);
        assertNotEquals(author, new Author("JaneDoe", "GB", authorBirthDate2, true, LocalDate.of(1970, 1, 1)));
    }

    /**
     * Method under test: {@link Author#equals(Object)}
     */
    @Test
    void testEquals6() {
        LocalDate authorBirthDate = LocalDate.of(1970, 1, 1);
        Author author = new Author("JaneDoe", "GBR", authorBirthDate, true, LocalDate.of(1970, 1, 1));
        LocalDate authorBirthDate2 = LocalDate.of(1970, 1, 1);
        assertNotEquals(author, new Author("JaneDoe", "GB", authorBirthDate2, true, LocalDate.of(1970, 1, 1)));
    }

    /**
     * Method under test: {@link Author#equals(Object)}
     */
    @Test
    void testEquals7() {
        LocalDate authorBirthDate = LocalDate.now();
        Author author = new Author("JaneDoe", "GB", authorBirthDate, true, LocalDate.of(1970, 1, 1));
        LocalDate authorBirthDate2 = LocalDate.of(1970, 1, 1);
        assertNotEquals(author, new Author("JaneDoe", "GB", authorBirthDate2, true, LocalDate.of(1970, 1, 1)));
    }

    /**
     * Method under test: {@link Author#equals(Object)}
     */
    @Test
    void testEquals8() {
        LocalDate authorBirthDate = LocalDate.of(1970, 1, 1);
        Author author = new Author("JaneDoe", "GB", authorBirthDate, false, LocalDate.of(1970, 1, 1));
        LocalDate authorBirthDate2 = LocalDate.of(1970, 1, 1);
        assertNotEquals(author, new Author("JaneDoe", "GB", authorBirthDate2, true, LocalDate.of(1970, 1, 1)));
    }

    /**
     * Method under test: {@link Author#equals(Object)}
     */
    @Test
    void testEquals9() {
        LocalDate authorBirthDate = LocalDate.of(1970, 1, 1);
        Author author = new Author("JaneDoe", "GB", authorBirthDate, true, LocalDate.now());
        LocalDate authorBirthDate2 = LocalDate.of(1970, 1, 1);
        assertNotEquals(author, new Author("JaneDoe", "GB", authorBirthDate2, true, LocalDate.of(1970, 1, 1)));
    }
}

