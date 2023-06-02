package com.FoundationProgramPhase1.utils;

import com.FoundationProgramPhase1.core.BookType;
import com.FoundationProgramPhase1.core.EBook;
import com.FoundationProgramPhase1.core.PaperBook;
import com.FoundationProgramPhase1.core.User;
import com.FoundationProgramPhase1.repositories.EBookRepository;
import com.FoundationProgramPhase1.repositories.PaperBookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;
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
        User user =  new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        Assertions.assertTrue(libraryUtils.searchReadEBookByTitle(scanner, user, list));
    }

    @Test
    void testSearchReadEBookByTitle_No() {
        Scanner scanner = new Scanner("The Grapes of Wrath\nno");
        List<EBook> list = EBookRepository.getEBooks();
        User user =  new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        Assertions.assertTrue(libraryUtils.searchReadEBookByTitle(scanner, user, list));
    }

    @Test
    void testSearchReadEBookByTitle_False() {
        Scanner scanner = new Scanner("Emma");
        List<EBook> list = EBookRepository.getEBooks();
        User user =  new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        Assertions.assertFalse(libraryUtils.searchReadEBookByTitle(scanner, user, list));
    }

    @Test
    void testSearchDownloadEBookByTitle_Yes() {
        Scanner scanner = new Scanner("Emma\nyes");
        List<EBook> list = EBookRepository.getEBooks();
        User user =  new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        Assertions.assertTrue(libraryUtils.searchDownloadEBookByTitle(scanner, user, list));
    }

    @Test
    void testSearchDownloadEBookByTitle_No() {
        Scanner scanner = new Scanner("Emma\nno");
        List<EBook> list = EBookRepository.getEBooks();
        User user =  new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        Assertions.assertTrue(libraryUtils.searchDownloadEBookByTitle(scanner, user, list));
    }

    @Test
    void testSearchDownloadEBookByTitle_False() {
        Scanner scanner = new Scanner("Of Mice and Men");
        List<EBook> list = EBookRepository.getEBooks();
        User user =  new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        Assertions.assertFalse(libraryUtils.searchDownloadEBookByTitle(scanner, user, list));
    }

    @Test
    void testAskForPostpone_True_ChangeDateWith10Days() {
        Scanner scanner = new Scanner(2 + "\n" + 10);
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        user.getPaperBookList().add(new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, LocalDate.now()));
        Assertions.assertTrue(libraryUtils.askForPostpone(scanner, user, user.getPaperBookList()));
    }

    @Test
    void testAskForPostpone_False_ChangeDateWith15Days() {
        Scanner scanner = new Scanner(2 + "\n" + 10);
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        user.getPaperBookList().add(new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, LocalDate.of(2023, 6, 10)));
        Assertions.assertFalse(libraryUtils.askForPostpone(scanner, user, user.getPaperBookList()));
    }

    @Test
    void testAskForPostpone_False() {
        Scanner scanner = new Scanner(String.valueOf(1));
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        user.getPaperBookList().add(new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, LocalDate.of(2023, 6, 10)));
        Assertions.assertFalse(libraryUtils.askForPostpone(scanner, user, user.getPaperBookList()));
    }

    @Test
    void testSearchPaperBookByTitle_Yes_AvailableCopiesMoreThanZero() {
        Scanner scanner = new Scanner("Avatar\nyes");
        List<PaperBook> list = PaperBookRepository.getPaperBooks();
        User user =  new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        Assertions.assertTrue(libraryUtils.searchPaperBookByTitle(scanner, user, list));
    }

    @Test
    void testSearchPaperBookByTitle_Yes_AvailableCopiesEqualZero() {
        Scanner scanner = new Scanner("Avatar\nyes");
        List<PaperBook> list = PaperBookRepository.getPaperBooks();
        PaperBook avatar = list.get(1);
        avatar.setPaperBookNumberOfCopiesAvailable(0);
        User user =  new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        Assertions.assertFalse(libraryUtils.searchPaperBookByTitle(scanner, user, list));
    }

    @Test
    void testSearchPaperBookByTitle_No() {
        Scanner scanner = new Scanner("Avatar\nno");
        List<PaperBook> list = PaperBookRepository.getPaperBooks();
        User user =  new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        Assertions.assertTrue(libraryUtils.searchPaperBookByTitle(scanner, user, list));
    }

    @Test
    void testSearchBookByGenre() {
        Scanner scanner = new Scanner("Autobiography");
        List<PaperBook> list = PaperBookRepository.getPaperBooks();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryUtils.searchBookByGenre(scanner, list);
        String expectedOutput = """
                Please enter book genre: \r
                Book{bookType=PAPER, bookTitle='What a life', bookAuthor='Tom Leveen', bookGenre='Autobiography', bookDescription='Life ot Tom', ISBN=4, paperBookNumberOfCopiesAvailable=5, paperBookNumberOfCopiesTotal=5,\s
                borrowedDate=null}\r
                """;
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testSearchBookByDescription() {
        Scanner scanner = new Scanner("Imaginary");
        List<PaperBook> list = PaperBookRepository.getPaperBooks();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryUtils.searchBookByDescription(scanner, list);
        String expectedOutput = """
                Please enter book description: \r
                Book{bookType=PAPER, bookTitle='Avatar', bookAuthor='James Cameron', bookGenre='Fantasy', bookDescription='Imaginary world', ISBN=2, paperBookNumberOfCopiesAvailable=4, paperBookNumberOfCopiesTotal=4,\s
                borrowedDate=null}\r
                """;
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testSearchBookByAuthorFirstName() {
        Scanner scanner = new Scanner("James");
        List<PaperBook> list = PaperBookRepository.getPaperBooks();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryUtils.searchBookByAuthorFirstName(scanner, list);
        String expectedOutput = """
                Please enter author's first name: \r
                Book{bookType=PAPER, bookTitle='Avatar', bookAuthor='James Cameron', bookGenre='Fantasy', bookDescription='Imaginary world', ISBN=2, paperBookNumberOfCopiesAvailable=4, paperBookNumberOfCopiesTotal=4,\s
                borrowedDate=null}\r
                Book{bookType=PAPER, bookTitle='World of cats', bookAuthor='James Patterson', bookGenre='Novel', bookDescription='The story of three cats', ISBN=7, paperBookNumberOfCopiesAvailable=11, paperBookNumberOfCopiesTotal=11,\s
                borrowedDate=null}\r  
                """;
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testSearchBookByAuthorLastName() {
        Scanner scanner = new Scanner("Cameron");
        List<PaperBook> list = PaperBookRepository.getPaperBooks();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryUtils.searchBookByAuthorLastName(scanner, list);
        String expectedOutput = """
                Please enter author's last name: \r
                Book{bookType=PAPER, bookTitle='Avatar', bookAuthor='James Cameron', bookGenre='Fantasy', bookDescription='Imaginary world', ISBN=2, paperBookNumberOfCopiesAvailable=4, paperBookNumberOfCopiesTotal=4,\s
                borrowedDate=null}\r
                """;
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }
}

