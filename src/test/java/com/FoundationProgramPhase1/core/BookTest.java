package com.FoundationProgramPhase1.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {

    @Test
    void testBookConstructor() {

        BookType bookType = BookType.PAPER;
        String bookTitle = "";
        String bookAuthor = "";
        String bookGenre = "";
        String bookDescription = "";
        int ISBN = 0;

        Book actualBook = new Book(bookType, bookTitle, bookAuthor, bookGenre, bookDescription, ISBN);
        assertEquals(bookType, actualBook.getBookType());
        assertEquals(bookTitle, actualBook.getBookTitle());
        assertEquals(bookAuthor, actualBook.getBookAuthor());
        assertEquals(bookGenre, actualBook.getBookGenre());
        assertEquals(bookDescription, actualBook.getBookDescription());
        assertEquals(ISBN, actualBook.getISBN());
    }

    void testBookToString() {
        Book book = new Book(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.out.println(book);
        String expectedOutput = "Book{bookType=PAPER, bookTitle='Avatar', bookAuthor='James Cameron', bookGenre='Fantasy', bookDescription='Imaginary world', ISBN=2}\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }
}

