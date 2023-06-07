package com.FoundationProgramPhase1.utils;

import com.FoundationProgramPhase1.core.BookType;
import com.FoundationProgramPhase1.core.EBook;
import com.FoundationProgramPhase1.core.PaperBook;
import com.FoundationProgramPhase1.core.User;
import com.FoundationProgramPhase1.repositories.EBookRepository;
import com.FoundationProgramPhase1.repositories.LibraryRepository;
import com.FoundationProgramPhase1.repositories.PaperBookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class LibraryUtilsTest {

    LibraryUtils libraryUtils;

    @BeforeEach
    void setLibraryUtils() {
        libraryUtils = new LibraryUtils();
    }

    @Test
    void testSearchReadEBookByTitle_Yes() {
        Scanner scanner = new Scanner("The Grapes of Wrath\nyes");
        List<EBook> list = EBookRepository.getEBooks();
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        Assertions.assertTrue(libraryUtils.searchReadEBookByTitle(scanner, user, list));
    }

    @Test
    void testSearchReadEBookByTitle_No() {
        Scanner scanner = new Scanner("The Grapes of Wrath\nno");
        List<EBook> list = EBookRepository.getEBooks();
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        Assertions.assertTrue(libraryUtils.searchReadEBookByTitle(scanner, user, list));
    }

    @Test
    void testSearchReadEBookByTitle_False() {
        Scanner scanner = new Scanner("Emma");
        List<EBook> list = EBookRepository.getEBooks();
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        Assertions.assertFalse(libraryUtils.searchReadEBookByTitle(scanner, user, list));
    }

    @Test
    void testSearchDownloadEBookByTitle_Yes() {
        Scanner scanner = new Scanner("Emma\nyes");
        List<EBook> list = EBookRepository.getEBooks();
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        Assertions.assertTrue(libraryUtils.searchDownloadEBookByTitle(scanner, user, list));
    }

    @Test
    void testSearchDownloadEBookByTitle_No() {
        Scanner scanner = new Scanner("Emma\nno");
        List<EBook> list = EBookRepository.getEBooks();
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        Assertions.assertTrue(libraryUtils.searchDownloadEBookByTitle(scanner, user, list));
    }

    @Test
    void testSearchDownloadEBookByTitle_False() {
        Scanner scanner = new Scanner("Of Mice and Men");
        List<EBook> list = EBookRepository.getEBooks();
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        Assertions.assertFalse(libraryUtils.searchDownloadEBookByTitle(scanner, user, list));
    }

    @Test
    void testAskForPostpone_True_ChangeDateWith10Days() {
        Scanner scanner = new Scanner(1 + "\n" + 10);
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        user.getPaperBookList().put(1, new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, LocalDate.now()));
        Assertions.assertTrue(libraryUtils.askForPaperBookPostpone(scanner, user, user.getPaperBookList()));
    }

    @Test
    void testAskForPostpone_False_ChangeDateWith15Days() {
        Scanner scanner = new Scanner(1 + "\n" + 15);
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        user.getPaperBookList().put(1, new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, LocalDate.now()));
        Assertions.assertFalse(libraryUtils.askForPaperBookPostpone(scanner, user, user.getPaperBookList()));
    }

    @Test
    void testAskForPostpone_False() {
        Scanner scanner = new Scanner(1 + "\n" + 10);
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        user.getPaperBookList().put(1, new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, LocalDate.of(2023, 8, 10)));
        Assertions.assertFalse(libraryUtils.askForPaperBookPostpone(scanner, user, user.getPaperBookList()));
    }

    @Test
    void testAskToReturnPaperBook() {
        Scanner scanner = new Scanner(1 + "\n" + "yes");
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        user.getPaperBookList().put(1, new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 113, 4, 0, null));
        Assertions.assertTrue(libraryUtils.askToReturnPaperBook(scanner, user, user.getPaperBookList()));
        Assertions.assertEquals(1, LibraryRepository.getPaperBooks().get(3).getPaperBookNumberOfCopiesAvailable());
        Assertions.assertEquals(5, LibraryRepository.getPaperBooks().get(3).getPaperBookNumberOfCopiesTotal());
        LibraryRepository.getPaperBooks().get(3).setPaperBookNumberOfCopiesTotal(4);
    }

    @Test
    void testSearchPaperBookByTitle_Yes_AvailableCopiesMoreThanZero() {
        Scanner scanner = new Scanner("Avatar\nyes");
        Map<Integer, PaperBook> list = LibraryRepository.getPaperBooks();
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        for (Map.Entry<Integer, PaperBook> entry : list.entrySet()) {
            entry.getValue().setPaperBookNumberOfCopiesAvailable(2);
        }
        Assertions.assertTrue(libraryUtils.searchPaperBookByTitle(scanner, user, list));
    }

    @Test
    void testSearchPaperBookByTitle_No() {
        Scanner scanner = new Scanner("Star Wars\nno\nno");
        Map<Integer, PaperBook> list = LibraryRepository.getPaperBooks();
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        Assertions.assertFalse(libraryUtils.searchPaperBookByTitle(scanner, user, list));
    }

    @Test
    void testSearchBookByGenre() {
        Scanner scanner = new Scanner("Autobiography");
        Map<Integer, PaperBook> list = PaperBookRepository.getPaperBooks();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryUtils.searchBookByGenre(scanner, list);
        String expectedOutput = """
                Please enter book genre: \r
                Book{bookType=PAPER, bookTitle='What a life', bookAuthor='Tom Leveen', bookGenre='Autobiography', bookDescription='Life ot Tom', ISBN=120, paperBookNumberOfCopiesAvailable=1, paperBookNumberOfCopiesTotal=2,\s
                borrowedDate=null}\r
                Book{bookType=PAPER, bookTitle='What a life', bookAuthor='Tom Leveen', bookGenre='Autobiography', bookDescription='Life ot Tom', ISBN=121, paperBookNumberOfCopiesAvailable=1, paperBookNumberOfCopiesTotal=2,\s
                borrowedDate=null}\r
                """;
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testSearchBookByDescription() {
        Scanner scanner = new Scanner("galaxy");
        Map<Integer, PaperBook> list = PaperBookRepository.getPaperBooks();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryUtils.searchBookByDescription(scanner, list);
        String expectedOutput = """
                Please enter book description: \r
                Book{bookType=PAPER, bookTitle='Star Wars', bookAuthor='Luke Shaw', bookGenre='Fantasy', bookDescription='Fighting in the galaxy', ISBN=111, paperBookNumberOfCopiesAvailable=1, paperBookNumberOfCopiesTotal=2,\s
                borrowedDate=null}\r
                Book{bookType=PAPER, bookTitle='Star Wars', bookAuthor='Luke Shaw', bookGenre='Fantasy', bookDescription='Fighting in the galaxy', ISBN=112, paperBookNumberOfCopiesAvailable=1, paperBookNumberOfCopiesTotal=2,\s
                borrowedDate=null}\r
                """;
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testSearchBookByAuthorFirstName() {
        Scanner scanner = new Scanner("Luke");
        Map<Integer, PaperBook> list = PaperBookRepository.getPaperBooks();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryUtils.searchBookByAuthorFirstName(scanner, list);
        String expectedOutput = """
                Please enter author's first name: \r
                Book{bookType=PAPER, bookTitle='Star Wars', bookAuthor='Luke Shaw', bookGenre='Fantasy', bookDescription='Fighting in the galaxy', ISBN=111, paperBookNumberOfCopiesAvailable=1, paperBookNumberOfCopiesTotal=2,\s
                borrowedDate=null}\r
                Book{bookType=PAPER, bookTitle='Star Wars', bookAuthor='Luke Shaw', bookGenre='Fantasy', bookDescription='Fighting in the galaxy', ISBN=112, paperBookNumberOfCopiesAvailable=1, paperBookNumberOfCopiesTotal=2,\s
                borrowedDate=null}\r
                """;
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testSearchBookByAuthorLastName() {
        Scanner scanner = new Scanner("Shaw");
        Map<Integer, PaperBook> list = PaperBookRepository.getPaperBooks();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryUtils.searchBookByAuthorLastName(scanner, list);
        String expectedOutput = """
                Please enter author's last name: \r
                Book{bookType=PAPER, bookTitle='Star Wars', bookAuthor='Luke Shaw', bookGenre='Fantasy', bookDescription='Fighting in the galaxy', ISBN=111, paperBookNumberOfCopiesAvailable=1, paperBookNumberOfCopiesTotal=2,\s
                borrowedDate=null}\r
                Book{bookType=PAPER, bookTitle='Star Wars', bookAuthor='Luke Shaw', bookGenre='Fantasy', bookDescription='Fighting in the galaxy', ISBN=112, paperBookNumberOfCopiesAvailable=1, paperBookNumberOfCopiesTotal=2,\s
                borrowedDate=null}\r
                """;
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }
}

