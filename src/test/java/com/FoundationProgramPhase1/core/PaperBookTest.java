package com.FoundationProgramPhase1.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PaperBookTest {

    @Test
    void testConstructor() {
        BookType bookType = BookType.PAPER;
        String bookTitle = "";
        String bookAuthor = "";
        String bookGenre = "";
        String bookDescription = "";
        int ISBN = 0;
        int paperBookNumberOfCopiesTotal = 0;
        int paperBookNumberOfCopiesAvailable= 0;

        PaperBook actualPaperBook = new PaperBook(bookType, bookTitle, bookAuthor, bookGenre, bookDescription,
                ISBN, paperBookNumberOfCopiesTotal, paperBookNumberOfCopiesAvailable, null);

        assertEquals(bookType, actualPaperBook.getBookType());
        assertEquals(bookTitle, actualPaperBook.getBookTitle());
        assertEquals(bookAuthor, actualPaperBook.getBookAuthor());
        assertEquals(bookGenre, actualPaperBook.getBookGenre());
        assertEquals(bookDescription, actualPaperBook.getBookDescription());
        assertEquals(ISBN, actualPaperBook.getISBN());
        assertEquals(paperBookNumberOfCopiesTotal, actualPaperBook.getPaperBookNumberOfCopiesTotal());
        assertEquals(paperBookNumberOfCopiesAvailable, actualPaperBook.getPaperBookNumberOfCopiesAvailable());
        assertNull(actualPaperBook.getBorrowedDate());
    }

    @Test
    void testPaperBookEquals() {
        PaperBook paperBook1 = new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, null);
        PaperBook paperBook2 = new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, null);
        assertNotEquals(paperBook1, null);
        assertEquals(paperBook1, paperBook2);
    }

    @Test
    void testPaperBookNotEquals() {
        PaperBook paperBook1 = new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, null);
        PaperBook paperBook2 = new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, LocalDate.now());
        assertNotEquals(paperBook1, paperBook2);
    }

    @Test
    void testPaperBookHashcode() {
        PaperBook paperBook1 = new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, null);
        PaperBook paperBook2 = new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, null);
        assertTrue(paperBook1.equals(paperBook2) && paperBook2.equals(paperBook1));
        assertEquals(paperBook1.hashCode(), paperBook2.hashCode());
    }

    @Test
    void testPaperBookToString() {
        PaperBook paperBook = new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, null);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.out.println(paperBook);
        String expectedOutput = "Book{bookType=PAPER, bookTitle='Avatar', bookAuthor='James Cameron', bookGenre='Fantasy', bookDescription='Imaginary world', ISBN=2, paperBookNumberOfCopiesAvailable=4, paperBookNumberOfCopiesTotal=4, \n" +
                "borrowedDate=null}\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }
}

