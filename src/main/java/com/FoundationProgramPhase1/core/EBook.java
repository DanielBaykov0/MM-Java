package com.FoundationProgramPhase1.core;

public class EBook extends Book {

    private final String eBookReadOnlineLink;
    private final String eBookDownloadLink;

    public EBook(BookType bookType, String bookTitle, String bookAuthor, String bookGenre, String bookDescription, String eBookReadOnlineLink, String eBookDownloadLink) {
        super(bookType, bookTitle, bookAuthor, bookGenre, bookDescription);
        this.eBookReadOnlineLink = eBookReadOnlineLink;
        this.eBookDownloadLink = eBookDownloadLink;
    }

    public String getEBookReadOnlineLink() {
        return eBookReadOnlineLink;
    }

    public String getEBookDownloadLink() {
        return eBookDownloadLink;
    }
}
