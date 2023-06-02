package com.FoundationProgramPhase1.repositories;

import com.FoundationProgramPhase1.core.BookType;
import com.FoundationProgramPhase1.core.EBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class EBookRepositoryTest {

    @Test
    void testGetEBooks() {
        EBook eBook = new EBook(BookType.EBOOK, "The Great Gatsby", "Stella Gibbons", "Novel", "The adventures of a noble man", 23,"https://openlibrary.org/read/TheGreatGatsby", "https://openlibrary.org/download/TheGreatGatsby");
        List<EBook> actualEBooks = EBookRepository.getEBooks();
        Assertions.assertTrue(actualEBooks.contains(eBook));
        Assertions.assertEquals(21, actualEBooks.size());
    }
}

