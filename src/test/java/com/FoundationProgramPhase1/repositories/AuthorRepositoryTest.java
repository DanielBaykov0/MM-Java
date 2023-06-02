package com.FoundationProgramPhase1.repositories;

import com.FoundationProgramPhase1.core.Author;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class AuthorRepositoryTest {

    @Test
    void testGetAuthors() {
        Author author = new Author("James", "Cameron", "USA", LocalDate.of(1965, 10, 26), true, null);
        List<Author> actualAuthors = AuthorRepository.getAuthors();
        Assertions.assertTrue(actualAuthors.contains(author));
        Assertions.assertEquals(56, actualAuthors.size());
    }
}

