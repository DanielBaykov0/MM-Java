package com.FoundationProgramPhase1.core;

import com.FoundationProgramPhase1.core.BookType;
import com.FoundationProgramPhase1.core.EBook;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class EBookTest {
    /**
     * Method under test: {@link EBook#EBook(BookType, String, String, String, String, String, String)}
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
        //       at java.util.Collections$SingletonList.forEach(Collections.java:4966)

        // Arrange
        // TODO: Populate arranged inputs
        BookType bookType = BookType.PAPER;
        String bookTitle = "";
        String bookAuthor = "";
        String bookGenre = "";
        String bookDescription = "";
        String eBookReadOnlineLink = "";
        String eBookDownloadLink = "";

        // Act
        EBook actualEBook = new EBook(bookType, bookTitle, bookAuthor, bookGenre, bookDescription, eBookReadOnlineLink,
                eBookDownloadLink);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link EBook#getEBookDownloadLink()}
     *   <li>{@link EBook#getEBookReadOnlineLink()}
     * </ul>
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetEBookDownloadLink() {
        // TODO: Complete this test.
        //   Reason: R006 Static initializer failed.
        //   The static initializer of
        //   org.mockito.Mockito
        //   threw java.lang.NoClassDefFoundError while trying to load it.
        //   Make sure the static initializer of Mockito
        //   can be executed without throwing exceptions.
        //   Exception: java.lang.NoClassDefFoundError: Could not initialize class org.mockito.Mockito
        //       at java.util.Collections$SingletonList.forEach(Collections.java:4966)

        // Arrange
        // TODO: Populate arranged inputs
        EBook eBook = null;

        // Act
        String actualEBookDownloadLink = eBook.getEBookDownloadLink();
        String actualEBookReadOnlineLink = eBook.getEBookReadOnlineLink();

        // Assert
        // TODO: Add assertions on result
    }
}

