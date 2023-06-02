package com.FoundationProgramPhase1.core;

import java.util.Objects;

public class EBook extends Book {

    private final String eBookReadOnlineLink;
    private final String eBookDownloadLink;

    public EBook(BookType bookType, String bookTitle, String bookAuthor, String bookGenre, String bookDescription, int ISBN, String eBookReadOnlineLink, String eBookDownloadLink) {
        super(bookType, bookTitle, bookAuthor, bookGenre, bookDescription, ISBN);
        this.eBookReadOnlineLink = eBookReadOnlineLink;
        this.eBookDownloadLink = eBookDownloadLink;
    }

    public String getEBookReadOnlineLink() {
        return eBookReadOnlineLink;
    }

    public String getEBookDownloadLink() {
        return eBookDownloadLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EBook eBook)) return false;
        return Objects.equals(eBookReadOnlineLink, eBook.eBookReadOnlineLink) && Objects.equals(eBookDownloadLink, eBook.eBookDownloadLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eBookReadOnlineLink, eBookDownloadLink);
    }

    @Override
    public String toString() {
        return super.toString() +
                "eBookReadOnlineLink='" + eBookReadOnlineLink + '\'' +
                ", eBookDownloadLink='" + eBookDownloadLink + '\'' +
                '}';
    }
}
