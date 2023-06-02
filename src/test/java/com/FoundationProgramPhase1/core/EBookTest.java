package com.FoundationProgramPhase1.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class EBookTest {

    @Test
    void testConstructor() {
        BookType bookType = BookType.PAPER;
        String bookTitle = "";
        String bookAuthor = "";
        String bookGenre = "";
        String bookDescription = "";
        int ISBN = 0;
        String eBookReadOnlineLink = "";
        String eBookDownloadLink = "";

        EBook actualEBook = new EBook(bookType, bookTitle, bookAuthor, bookGenre, bookDescription, ISBN, eBookReadOnlineLink,
                eBookDownloadLink);
        assertEquals(bookType, actualEBook.getBookType());
        assertEquals(bookTitle, actualEBook.getBookTitle());
        assertEquals(bookAuthor, actualEBook.getBookAuthor());
        assertEquals(bookGenre, actualEBook.getBookGenre());
        assertEquals(bookDescription, actualEBook.getBookDescription());
        assertEquals(ISBN, actualEBook.getISBN());
        assertEquals(eBookReadOnlineLink, actualEBook.getEBookReadOnlineLink());
        assertEquals(eBookDownloadLink, actualEBook.getEBookDownloadLink());
    }

    @Test
    void testEBookEquals() {
        EBook eBook1 = new EBook(BookType.EBOOK, "The Great Gatsby", "Stella Gibbons", "Novel", "The adventures of a noble man", 23,"https://openlibrary.org/read/TheGreatGatsby", "https://openlibrary.org/download/TheGreatGatsby");
        EBook eBook2 = new EBook(BookType.EBOOK, "The Great Gatsby", "Stella Gibbons", "Novel", "The adventures of a noble man", 23,"https://openlibrary.org/read/TheGreatGatsby", "https://openlibrary.org/download/TheGreatGatsby");
        assertNotEquals(eBook1, null);
        assertEquals(eBook1, eBook2);
    }

    @Test
    void testPaperBookNotEquals() {
        EBook eBook1 = new EBook(BookType.EBOOK, "The Great Gatsby", "Stella Gibbons", "Novel", "The adventures of a noble man", 23,"https://openlibrary.org/read/TheGreatGatsby", "https://openlibrary.org/download/TheGreatGatsby");
        EBook eBook2 = new EBook(BookType.EBOOK, "The Great Gatsby", "Stella Gibbons", "Novel", "The adventures of a noble man", 23,"Not readable", "https://openlibrary.org/download/TheGreatGatsby");
        assertNotEquals(eBook1, eBook2);
    }

    @Test
    void testPaperBookHashcode() {
        EBook eBook1 = new EBook(BookType.EBOOK, "The Great Gatsby", "Stella Gibbons", "Novel", "The adventures of a noble man", 23,"https://openlibrary.org/read/TheGreatGatsby", "https://openlibrary.org/download/TheGreatGatsby");
        EBook eBook2 = new EBook(BookType.EBOOK, "The Great Gatsby", "Stella Gibbons", "Novel", "The adventures of a noble man", 23,"https://openlibrary.org/read/TheGreatGatsby", "https://openlibrary.org/download/TheGreatGatsby");
        assertTrue(eBook1.equals(eBook2) && eBook2.equals(eBook1));
        assertEquals(eBook1.hashCode(), eBook2.hashCode());
    }

    @Test
    void testPaperBookToString() {
        EBook eBook = new EBook(BookType.EBOOK, "The Great Gatsby", "Stella Gibbons", "Novel", "The adventures of a noble man", 23,"https://openlibrary.org/read/TheGreatGatsby", "https://openlibrary.org/download/TheGreatGatsby");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.out.println(eBook);
        String expectedOutput = "Book{bookType=EBOOK, bookTitle='The Great Gatsby', bookAuthor='Stella Gibbons', bookGenre='Novel', bookDescription='The adventures of a noble man', ISBN=23, eBookReadOnlineLink='https://openlibrary.org/read/TheGreatGatsby', eBookDownloadLink='https://openlibrary.org/download/TheGreatGatsby'}\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }
}

