package com.FoundationProgramPhase1.repositories;

import com.FoundationProgramPhase1.core.BookType;
import com.FoundationProgramPhase1.core.PaperBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class PaperBookRepositoryTest {

    @Test
    void testGetPaperBooks() {
        PaperBook paperBook = new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, null);
        Map<Integer, PaperBook> actualPaperBooks = PaperBookRepository.getPaperBooks();
        Assertions.assertTrue(actualPaperBooks.containsValue(paperBook));
        Assertions.assertEquals(11, actualPaperBooks.size());
    }
}

