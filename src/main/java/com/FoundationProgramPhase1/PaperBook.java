package com.FoundationProgramPhase1;

public class PaperBook extends Book {

    private int paperBookNumberOfCopiesAvailable;
    private final int paperBookNumberOfCopiesTotal;

    public PaperBook(BookType bookType, String bookTitle, String bookAuthor, String bookGenre, String bookDescription, int paperBookNumberOfCopiesTotal) {
        super(bookType, bookTitle, bookAuthor, bookGenre, bookDescription);
        this.paperBookNumberOfCopiesTotal = paperBookNumberOfCopiesTotal;
    }

    public int getPaperBookNumberOfCopiesAvailable() {
        return paperBookNumberOfCopiesAvailable;
    }

    public int getPaperBookNumberOfCopiesTotal() {
        return paperBookNumberOfCopiesTotal;
    }

    public void setPaperBookNumberOfCopiesAvailable(int paperBookNumberOfCopiesAvailable) {
        this.paperBookNumberOfCopiesAvailable = paperBookNumberOfCopiesAvailable;
    }
}
