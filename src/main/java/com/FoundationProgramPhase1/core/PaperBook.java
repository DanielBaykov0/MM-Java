package com.FoundationProgramPhase1.core;

import java.time.LocalDate;
import java.util.Objects;

public class PaperBook extends Book {

    private int paperBookNumberOfCopiesAvailable;
    private int paperBookNumberOfCopiesTotal;
    private LocalDate borrowedDate;

    public PaperBook(BookType bookType, String bookTitle, String bookAuthor, String bookGenre, String bookDescription, int ISBN, int paperBookNumberOfCopiesTotal, int paperBookNumberOfCopiesAvailable, LocalDate borrowedDate) {
        super(bookType, bookTitle, bookAuthor, bookGenre, bookDescription, ISBN);
        this.paperBookNumberOfCopiesTotal = paperBookNumberOfCopiesTotal;
        this.paperBookNumberOfCopiesAvailable = paperBookNumberOfCopiesAvailable;
        this.borrowedDate = borrowedDate;
    }

    public int getPaperBookNumberOfCopiesAvailable() {
        return paperBookNumberOfCopiesAvailable;
    }

    public int getPaperBookNumberOfCopiesTotal() {
        return paperBookNumberOfCopiesTotal;
    }

    public void setPaperBookNumberOfCopiesTotal(int paperBookNumberOfCopiesTotal) {
        this.paperBookNumberOfCopiesTotal = paperBookNumberOfCopiesTotal;
    }

    public void setPaperBookNumberOfCopiesAvailable(int paperBookNumberOfCopiesAvailable) {
        this.paperBookNumberOfCopiesAvailable = paperBookNumberOfCopiesAvailable;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaperBook paperBook)) return false;
        return paperBookNumberOfCopiesTotal == paperBook.paperBookNumberOfCopiesTotal && Objects.equals(borrowedDate, paperBook.borrowedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paperBookNumberOfCopiesTotal, borrowedDate);
    }

    @Override
    public String toString() {
        return super.toString() +
                "paperBookNumberOfCopiesAvailable=" + paperBookNumberOfCopiesAvailable +
                ", paperBookNumberOfCopiesTotal=" + paperBookNumberOfCopiesTotal +
                ", \nborrowedDate=" + borrowedDate +
                '}';
    }
}
