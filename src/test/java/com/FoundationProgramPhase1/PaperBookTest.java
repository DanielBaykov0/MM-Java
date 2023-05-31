package com.FoundationProgramPhase1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PaperBookTest {
    /**
     * Method under test: {@link PaperBook#PaperBook(BookType, String, String, String, String, int)}
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
        int paperBookNumberOfCopiesTotal = 0;

        // Act
        PaperBook actualPaperBook = new PaperBook(bookType, bookTitle, bookAuthor, bookGenre, bookDescription,
                paperBookNumberOfCopiesTotal);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PaperBook#setPaperBookNumberOfCopiesAvailable(int)}
     *   <li>{@link PaperBook#setPaperBookNumberOfCopiesTotal(int)}
     *   <li>{@link PaperBook#getPaperBookNumberOfCopiesAvailable()}
     *   <li>{@link PaperBook#getPaperBookNumberOfCopiesTotal()}
     * </ul>
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSetPaperBookNumberOfCopiesAvailable() {
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
        PaperBook paperBook = null;
        int paperBookNumberOfCopiesAvailable = 0;

        // Act
        paperBook.setPaperBookNumberOfCopiesAvailable(paperBookNumberOfCopiesAvailable);
        int paperBookNumberOfCopiesTotal = 0;
        paperBook.setPaperBookNumberOfCopiesTotal(paperBookNumberOfCopiesTotal);
        int actualPaperBookNumberOfCopiesAvailable = paperBook.getPaperBookNumberOfCopiesAvailable();
        int actualPaperBookNumberOfCopiesTotal = paperBook.getPaperBookNumberOfCopiesTotal();

        // Assert
        // TODO: Add assertions on result
    }
}

