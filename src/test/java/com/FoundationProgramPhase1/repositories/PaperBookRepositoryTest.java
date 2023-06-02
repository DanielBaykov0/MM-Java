package com.FoundationProgramPhase1.repositories;

import com.FoundationProgramPhase1.core.BookType;
import com.FoundationProgramPhase1.core.PaperBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PaperBookRepositoryTest {

    @Test
    void testGetPaperBooks() {
        PaperBook paperBook = new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, null);
        List<PaperBook> actualPaperBooks = PaperBookRepository.getPaperBooks();
        Assertions.assertTrue(actualPaperBooks.contains(paperBook));
        Assertions.assertEquals(15, actualPaperBooks.size());
    }
}

