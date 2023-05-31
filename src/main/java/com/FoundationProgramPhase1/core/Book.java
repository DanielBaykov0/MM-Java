package com.FoundationProgramPhase1.core;

import java.util.Objects;
import java.util.Random;

public class Book {

    private final BookType bookType;
    private final String bookTitle;
    private final String bookAuthor;
    private final String bookGenre;
    private final String bookDescription;
    private final long ISBN;

    public Book(BookType bookType, String bookTitle, String bookAuthor, String bookGenre, String bookDescription) {
        this.bookType = bookType;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
        this.bookDescription = bookDescription;
        this.ISBN = provideISBN();
    }

    public long provideISBN() {
        long number;
        while (true) {
            if (checkISBN(generateISBN())) {
                number = generateISBN();
                break;
            }
        }

        return number;
    }

    public boolean checkISBN(long number) {
        int sum = 0;
        int dNumber;
        String strNumber;

        strNumber = "" + number;

        if (strNumber.length() != 10) {
            return false;
        }

        for (int i = 0; i < strNumber.length(); i++) {
            int intNumber = Integer.parseInt(strNumber.substring(i, i + 1));
            dNumber = i + 1;
            int t = dNumber * intNumber;
            sum = sum + t;
        }

        return (sum % 11) == 0;
    }

    public long generateISBN() {
        StringBuilder numberString = new StringBuilder();
        Random random = new Random();

        for (int i = 1; i <= 10; i++) {
            numberString.append(random.nextInt(1, 11));
        }

        return Long.parseLong(numberString.toString());
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

    public long getISBN() {
        return ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return ISBN == book.ISBN && bookType == book.bookType && Objects.equals(bookTitle, book.bookTitle) && Objects.equals(bookDescription, book.bookDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookType, bookTitle, bookDescription, ISBN);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookType=" + bookType +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookGenre='" + bookGenre + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", ISBN=" + ISBN +
                '}';
    }
}
