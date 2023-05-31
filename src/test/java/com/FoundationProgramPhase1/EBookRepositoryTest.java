package com.FoundationProgramPhase1;

import java.util.List;

import com.FoundationProgramPhase1.repositories.EBookRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class EBookRepositoryTest {
    /**
     * Method under test: {@link EBookRepository#getEBooks()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetEBooks() {
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
        List<EBook> actualEBooks = EBookRepository.getEBooks();

        // Assert
        // TODO: Add assertions on result
    }
}

