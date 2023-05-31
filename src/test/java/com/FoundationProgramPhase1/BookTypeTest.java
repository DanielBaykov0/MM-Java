package com.FoundationProgramPhase1;

import java.util.List;

import com.FoundationProgramPhase1.core.BookType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class BookTypeTest {
    /**
     * Method under test: {@link BookType#getBookTypes()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetBookTypes() {
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

        // Act
        List<BookType> actualBookTypes = bookType.getBookTypes();

        // Assert
        // TODO: Add assertions on result
    }
}

