package com.FoundationProgramPhase1.core;

public class Book {

    private final BookType bookType;
    private final String bookTitle;
    private final String bookAuthor;
    private final String bookGenre;
    private final String bookDescription;
    private final int ISBN;

    public Book(BookType bookType, String bookTitle, String bookAuthor, String bookGenre, String bookDescription, int ISBN) {
        this.bookType = bookType;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
        this.bookDescription = bookDescription;
        this.ISBN = ISBN;
    }

    public BookType getBookType() {
        return bookType;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public int getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookType=" + bookType +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookGenre='" + bookGenre + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", ISBN=" + ISBN + ", ";
    }
}
