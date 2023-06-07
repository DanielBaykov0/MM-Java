package com.FoundationProgramPhase1.utils;

import com.FoundationProgramPhase1.core.BookType;
import com.FoundationProgramPhase1.core.PaperBook;
import com.FoundationProgramPhase1.core.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class LibraryHelperTest {

    LibraryHelper libraryHelper;

    @BeforeEach
    void setLibraryUtils() {
        libraryHelper = new LibraryHelper();
    }

    @Test
    void testReturnCorrectBookTitle() {
        Scanner scanner = new Scanner("My man");
        Assertions.assertEquals("My man", libraryHelper.returnCorrectBookTitle(scanner));
    }

    @Test
    void testReturnCorrectBookGenre() {
        Scanner scanner = new Scanner("Fantasy");
        Assertions.assertEquals("Fantasy", libraryHelper.returnCorrectBookGenre(scanner));
    }

    @Test
    void testReturnCorrectBookDescription() {
        Scanner scanner = new Scanner("Amazing book");
        Assertions.assertEquals("Amazing book", libraryHelper.returnCorrectBookDescription(scanner));
    }

    @Test
    void testReturnCorrectAuthorFirstName() {
        Scanner scanner = new Scanner("Daniel");
        Assertions.assertEquals("Daniel", libraryHelper.returnCorrectAuthorFirstName(scanner));
    }

    @Test
    void testReturnCorrectAuthorLastName() {
        Scanner scanner = new Scanner("Georgiev");
        Assertions.assertEquals("Georgiev", libraryHelper.returnCorrectAuthorLastName(scanner));
    }

    @Test
    void testAskForBookId_ReturnCorrectNumber() {
        Scanner scanner = new Scanner(String.valueOf(1));
        Map<Integer, PaperBook> paperBooks = new HashMap<>();
        PaperBook paperBook = new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, null);
        paperBooks.put(1, paperBook);
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", false);
        user.setPaperBookList(paperBooks);
        Assertions.assertEquals(1, libraryHelper.askForBookId(scanner, paperBooks));
    }

    @Test
    void testAskForBookId_ReturnZero() {
        Scanner scanner = new Scanner(String.valueOf(2));
        Map<Integer, PaperBook> paperBooks = new HashMap<>();
        PaperBook paperBook = new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, null);
        paperBooks.put(1, paperBook);
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", false);
        user.setPaperBookList(paperBooks);
        Assertions.assertEquals(0, libraryHelper.askForBookId(scanner, paperBooks));
    }
}

