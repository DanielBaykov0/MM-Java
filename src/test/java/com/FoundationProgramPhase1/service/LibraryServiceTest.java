package com.FoundationProgramPhase1.service;

import com.FoundationProgramPhase1.core.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class LibraryServiceTest {

    LibraryService libraryService;

    @BeforeEach
    void setLibraryService() {
        libraryService = new LibraryService();
    }

    @Test
    void testBorrowPaperBook_Yes_True() {
        Scanner scanner = new Scanner("yes");
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        PaperBook paperBook = new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 1, null);
        int id = 1;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryService.borrowPaperBook(scanner, user, id, paperBook, user.getPaperBookList());
        String expectedOutput = "Would you like to borrow this book?(yes/no)\r\nYou borrowed the book: Avatar\r\nAvatar available copies = 0\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testBorrowPaperBook_No() {
        Scanner scanner = new Scanner("no");
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        PaperBook paperBook = new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 1, null);
        int id = 1;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryService.borrowPaperBook(scanner, user, id, paperBook, user.getPaperBookList());
        String expectedOutput = "Would you like to borrow this book?(yes/no)\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testReturnPaperBook_Yes_True() {
        Scanner scanner = new Scanner("\nyes");
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        PaperBook paperBook = new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 1, null);
        int id = 1;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryService.returnPaperBook(scanner, user, id, paperBook, user.getPaperBookList());
        String expectedOutput = "Would you like to return this book?(yes/no)\r\nYou returned the book: Avatar\r\nAvatar available copies = 2\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testReturnPaperBook_No() {
        Scanner scanner = new Scanner("\nno");
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        PaperBook paperBook = new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 1, null);
        int id = 1;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryService.returnPaperBook(scanner, user, id, paperBook, user.getPaperBookList());
        String expectedOutput = "Would you like to return this book?(yes/no)\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testReadEBook_Yes_True() {
        Scanner scanner = new Scanner("yes");
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        EBook eBook = new EBook(BookType.EBOOK, "The Great Gatsby", "Stella Gibbons", "Novel", "The adventures of a noble man", 23,"https://openlibrary.org/read/TheGreatGatsby", "https://openlibrary.org/download/TheGreatGatsby");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryService.readEBook(scanner, user, eBook, user.geteBookReadList());
        String expectedOutput = "Would you like to read this book?(yes/no)\r\nYou read The Great Gatsby\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testReadEBook_Yes_False() {
        Scanner scanner = new Scanner("yes");
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        EBook eBook = new EBook(BookType.EBOOK, "The Great Gatsby", "Stella Gibbons", "Novel", "The adventures of a noble man", 23,"https://openlibrary.org/read/TheGreatGatsby", "https://openlibrary.org/download/TheGreatGatsby");
        user.geteBookReadList().add(eBook);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryService.readEBook(scanner, user, eBook, user.geteBookReadList());
        String expectedOutput = "Would you like to read this book?(yes/no)\r\nCan not add this book\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testReadEBook_Yes_No() {
        Scanner scanner = new Scanner("no");
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        EBook eBook = new EBook(BookType.EBOOK, "The Great Gatsby", "Stella Gibbons", "Novel", "The adventures of a noble man", 23,"https://openlibrary.org/read/TheGreatGatsby", "https://openlibrary.org/download/TheGreatGatsby");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryService.readEBook(scanner, user, eBook, user.geteBookReadList());
        String expectedOutput = "Would you like to read this book?(yes/no)\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testDownloadEBook_Yes_True() {
        Scanner scanner = new Scanner("yes");
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        EBook eBook = new EBook(BookType.EBOOK, "The Great Gatsby", "Stella Gibbons", "Novel", "The adventures of a noble man", 23,"https://openlibrary.org/read/TheGreatGatsby", "https://openlibrary.org/download/TheGreatGatsby");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryService.downloadEBook(scanner, user, eBook, user.geteBookDownloadedList());
        String expectedOutput = "Would you like to download this book?(yes/no)\r\nYou downloaded The Great Gatsby\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testDownloadEBook_Yes_False() {
        Scanner scanner = new Scanner("yes");
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        EBook eBook = new EBook(BookType.EBOOK, "The Great Gatsby", "Stella Gibbons", "Novel", "The adventures of a noble man", 23,"https://openlibrary.org/read/TheGreatGatsby", "https://openlibrary.org/download/TheGreatGatsby");
        user.geteBookDownloadedList().add(eBook);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryService.downloadEBook(scanner, user, eBook, user.geteBookDownloadedList());
        String expectedOutput = "Would you like to download this book?(yes/no)\r\nCan not add this book\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testDownloadEBook_No() {
        Scanner scanner = new Scanner("no");
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        EBook eBook = new EBook(BookType.EBOOK, "The Great Gatsby", "Stella Gibbons", "Novel", "The adventures of a noble man", 23,"https://openlibrary.org/read/TheGreatGatsby", "https://openlibrary.org/download/TheGreatGatsby");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryService.downloadEBook(scanner, user, eBook, user.geteBookDownloadedList());
        String expectedOutput = "Would you like to download this book?(yes/no)\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testListPaperBooks() {
        PaperBook paperBook = new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, null);
        Map<Integer, PaperBook> paperBooks = Map.of(1, paperBook);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryService.listPaperBooks(paperBooks);
        String expectedOutput = "1 Book{bookType=PAPER, bookTitle='Avatar', bookAuthor='James Cameron', bookGenre='Fantasy', bookDescription='Imaginary world', ISBN=2, paperBookNumberOfCopiesAvailable=4, paperBookNumberOfCopiesTotal=4, \n" +
                "borrowedDate=null}\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testListEBooks() {
        EBook eBook = new EBook(BookType.EBOOK, "The Great Gatsby", "Stella Gibbons", "Novel", "The adventures of a noble man", 23,"https://openlibrary.org/read/TheGreatGatsby", "https://openlibrary.org/download/TheGreatGatsby");
        List<EBook> eBooks = List.of(eBook);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryService.listEBooks(eBooks);
        String expectedOutput = "Book{bookType=EBOOK, bookTitle='The Great Gatsby', bookAuthor='Stella Gibbons', bookGenre='Novel', bookDescription='The adventures of a noble man', ISBN=23, eBookReadOnlineLink='https://openlibrary.org/read/TheGreatGatsby', eBookDownloadLink='https://openlibrary.org/download/TheGreatGatsby'}\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testListAuthors() {
        Author author = new Author("James", "Cameron", "USA", LocalDate.of(1965, 10, 26), true, null);
        List<Author> authors = List.of(author);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryService.listAuthors(authors);
        String expectedOutput = "Author{authorFirstName='James', authorLastName='Cameron', authorCountryBorn='USA', authorBirthDate=1965-10-26, isAuthorAlive=true, authorDeathDate=null}\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testListReadableEBooks() {
        EBook eBook = new EBook(BookType.EBOOK, "The Great Gatsby", "Stella Gibbons", "Novel", "The adventures of a noble man", 23,"https://openlibrary.org/read/TheGreatGatsby", "https://openlibrary.org/download/TheGreatGatsby");
        List<EBook> eBooks = List.of(eBook);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryService.listReadableEBooks(eBooks);
        String expectedOutput = "Book{bookType=EBOOK, bookTitle='The Great Gatsby', bookAuthor='Stella Gibbons', bookGenre='Novel', bookDescription='The adventures of a noble man', ISBN=23, eBookReadOnlineLink='https://openlibrary.org/read/TheGreatGatsby', eBookDownloadLink='https://openlibrary.org/download/TheGreatGatsby'}\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testListDownloadableEBooks() {
        EBook eBook = new EBook(BookType.EBOOK, "The Great Gatsby", "Stella Gibbons", "Novel", "The adventures of a noble man", 23,"https://openlibrary.org/read/TheGreatGatsby", "https://openlibrary.org/download/TheGreatGatsby");
        List<EBook> eBooks = List.of(eBook);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryService.listDownloadableEBooks(eBooks);
        String expectedOutput = "Book{bookType=EBOOK, bookTitle='The Great Gatsby', bookAuthor='Stella Gibbons', bookGenre='Novel', bookDescription='The adventures of a noble man', ISBN=23, eBookReadOnlineLink='https://openlibrary.org/read/TheGreatGatsby', eBookDownloadLink='https://openlibrary.org/download/TheGreatGatsby'}\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintBooks() {
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        user.geteBookReadList().add(new EBook(BookType.EBOOK, "The Great Gatsby", "Stella Gibbons", "Novel", "The adventures of a noble man", 23,"https://openlibrary.org/read/TheGreatGatsby", "https://openlibrary.org/download/TheGreatGatsby"));
        List<User> users = List.of(user);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        libraryService.printBooks(users);
        String expectedOutput = "User{username='ivanivan', password='longOne', name='Ivan Georgiev', userAge=54, userGender='male', userAddress='123 Washington', userCity='Munich', userCounty='Germany', userEmail='ivan@abv.bg', GDPR=true,\n" +
                " paperBookList={},\n" +
                " eBookReadList=[Book{bookType=EBOOK, bookTitle='The Great Gatsby', bookAuthor='Stella Gibbons', bookGenre='Novel', bookDescription='The adventures of a noble man', ISBN=23, eBookReadOnlineLink='https://openlibrary.org/read/TheGreatGatsby', eBookDownloadLink='https://openlibrary.org/download/TheGreatGatsby'}],\n" +
                " eBookDownloadedList=[]}\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }
}

