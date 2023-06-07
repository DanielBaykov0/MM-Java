package com.FoundationProgramPhase1.repositories;

import com.FoundationProgramPhase1.core.Author;
import com.FoundationProgramPhase1.core.EBook;
import com.FoundationProgramPhase1.core.PaperBook;
import com.FoundationProgramPhase1.core.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class LibraryRepositoryTest {

    @Test
    void testGetAuthors() {
        List<Author> authorList = AuthorRepository.getAuthors();
        Assertions.assertEquals(authorList, LibraryRepository.getAuthors());
    }

    @Test
    void testGetPaperBooks() {
        Map<Integer, PaperBook> paperBooks = PaperBookRepository.getPaperBooks();
        Assertions.assertEquals(paperBooks, LibraryRepository.getPaperBooks());
    }

    @Test
    void testGetEBooks() {
        List<EBook> eBookList = EBookRepository.getEBooks();
        Assertions.assertEquals(eBookList, LibraryRepository.getEBooks());
    }

    @Test
    void testGetUsers() {
        List<User> userList = UserRepository.getUsers();
        Assertions.assertEquals(userList, LibraryRepository.getUsers());
    }
}

