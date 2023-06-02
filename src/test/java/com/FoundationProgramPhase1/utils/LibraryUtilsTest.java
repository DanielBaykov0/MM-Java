package com.FoundationProgramPhase1.utils;

import com.FoundationProgramPhase1.core.BookType;
import com.FoundationProgramPhase1.core.PaperBook;
import com.FoundationProgramPhase1.core.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class LibraryUtilsTest {

    LibraryUtils libraryUtils;

    @BeforeEach
    void setLibraryUtils() {
        libraryUtils = new LibraryUtils();
    }

    @Test
    void testReturnCorrectBookTitle() {
        Scanner scanner = new Scanner("My man");
        Assertions.assertEquals("My man", libraryUtils.returnCorrectBookTitle(scanner));
    }

    @Test
    void testReturnCorrectBookGenre() {
        Scanner scanner = new Scanner("Fantasy");
        Assertions.assertEquals("Fantasy", libraryUtils.returnCorrectBookGenre(scanner));
    }

    @Test
    void testReturnCorrectBookDescription() {
        Scanner scanner = new Scanner("Amazing book");
        Assertions.assertEquals("Amazing book", libraryUtils.returnCorrectBookDescription(scanner));
    }

    @Test
    void testReturnCorrectAuthorFirstName() {
        Scanner scanner = new Scanner("Daniel");
        Assertions.assertEquals("Daniel", libraryUtils.returnCorrectAuthorFirstName(scanner));
    }

    @Test
    void testReturnCorrectAuthorLastName() {
        Scanner scanner = new Scanner("Georgiev");
        Assertions.assertEquals("Georgiev", libraryUtils.returnCorrectAuthorLastName(scanner));
    }

    @Test
    void testAskForBookISBN_ReturnCorrectNumber() {
        Scanner scanner = new Scanner(String.valueOf(2));
        List<PaperBook> paperBooks = new ArrayList<>();
        PaperBook paperBook = new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, null);
        paperBooks.add(paperBook);
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", false);
        user.setPaperBookList(paperBooks);
        Assertions.assertEquals(2, libraryUtils.askForBookISBN(scanner, user));
    }

    @Test
    void testAskForBookISBN_ReturnZero() {
        Scanner scanner = new Scanner(String.valueOf(2));
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", false);
        Assertions.assertEquals(0, libraryUtils.askForBookISBN(scanner, user));
    }
}

