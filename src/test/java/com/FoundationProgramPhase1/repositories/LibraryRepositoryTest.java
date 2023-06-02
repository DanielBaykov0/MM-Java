package com.FoundationProgramPhase1.repositories;

import com.FoundationProgramPhase1.core.Author;
import com.FoundationProgramPhase1.core.EBook;
import com.FoundationProgramPhase1.core.PaperBook;
import com.FoundationProgramPhase1.core.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class LibraryRepositoryTest {

    LibraryRepository libraryRepository;

    @BeforeEach
    void setLibraryRepository() {
        libraryRepository = new LibraryRepository();
    }

    @Test
    void testGetAuthors() {
        List<Author> authorList = AuthorRepository.getAuthors();
        Assertions.assertEquals(authorList, libraryRepository.getAuthors());
    }

    @Test
    void testGetPaperBooks() {
        List<PaperBook> paperBooks = PaperBookRepository.getPaperBooks();
        Assertions.assertEquals(paperBooks, libraryRepository.getPaperBooks());
    }

    @Test
    void testGetEBooks() {
        List<EBook> eBookList = EBookRepository.getEBooks();
        Assertions.assertEquals(eBookList, libraryRepository.getEBooks());
    }

    @Test
    void testGetUsers() {
        List<User> userList = UserRepository.getUsers();
        Assertions.assertEquals(userList, libraryRepository.getUsers());
    }
}

