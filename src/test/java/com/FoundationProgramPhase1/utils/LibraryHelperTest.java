//package com.FoundationProgramPhase1.utils;
//
//import com.FoundationProgramPhase1.core.BookType;
//import com.FoundationProgramPhase1.core.PaperBook;
//import com.FoundationProgramPhase1.core.User;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//class LibraryHelperTest {
//
//    LibraryHelper libraryHelper;
//
//    @BeforeEach
//    void setLibraryUtils() {
//        libraryHelper = new LibraryHelper();
//    }
//
//    @Test
//    void testReturnCorrectBookTitle() {
//        Scanner scanner = new Scanner("My man");
//        Assertions.assertEquals("My man", libraryHelper.returnCorrectBookTitle(scanner));
//    }
//
//    @Test
//    void testReturnCorrectBookGenre() {
//        Scanner scanner = new Scanner("Fantasy");
//        Assertions.assertEquals("Fantasy", libraryHelper.returnCorrectBookGenre(scanner));
//    }
//
//    @Test
//    void testReturnCorrectBookDescription() {
//        Scanner scanner = new Scanner("Amazing book");
//        Assertions.assertEquals("Amazing book", libraryHelper.returnCorrectBookDescription(scanner));
//    }
//
//    @Test
//    void testReturnCorrectAuthorFirstName() {
//        Scanner scanner = new Scanner("Daniel");
//        Assertions.assertEquals("Daniel", libraryHelper.returnCorrectAuthorFirstName(scanner));
//    }
//
//    @Test
//    void testReturnCorrectAuthorLastName() {
//        Scanner scanner = new Scanner("Georgiev");
//        Assertions.assertEquals("Georgiev", libraryHelper.returnCorrectAuthorLastName(scanner));
//    }
//
//    @Test
//    void testAskForBookISBN_ReturnCorrectNumber() {
//        Scanner scanner = new Scanner(String.valueOf(2));
//        List<PaperBook> paperBooks = new ArrayList<>();
//        PaperBook paperBook = new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, null);
//        paperBooks.add(paperBook);
//        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", false);
//        user.setPaperBookList(paperBooks);
//        Assertions.assertEquals(2, libraryHelper.askForBookISBN(scanner, user));
//    }
//
//    @Test
//    void testAskForBookISBN_ReturnZero() {
//        Scanner scanner = new Scanner(String.valueOf(2));
//        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", false);
//        Assertions.assertEquals(0, libraryHelper.askForBookISBN(scanner, user));
//    }
//}
//
