package com.FoundationProgramPhase1;

import java.util.List;

import com.FoundationProgramPhase1.core.PaperBook;
import com.FoundationProgramPhase1.repositories.PaperBookRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PaperBookRepositoryTest {
    /**
     * Method under test: {@link PaperBookRepository#getPaperBooks()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPaperBooks() {
        // TODO: Complete this test.
        //   Reason: R006 Static initializer failed.
        //   The static initializer of
        //   org.mockito.Mockito
        //   threw java.lang.NoClassDefFoundError while trying to load it.
        //   Make sure the static initializer of Mockito
        //   can be executed without throwing exceptions.
        //   Exception: java.lang.NoClassDefFoundError: Could not initialize class org.mockito.Mockito
        //       at java.util.Collections$SingletonList.forEach(Collections.java:4966)

        // Arrange and Act
        // TODO: Populate arranged inputs
        List<PaperBook> actualPaperBooks = PaperBookRepository.getPaperBooks();

        // Assert
        // TODO: Add assertions on result
    }
}

