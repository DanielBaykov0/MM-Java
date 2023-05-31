package com.FoundationProgramPhase1.repositories;

import com.FoundationProgramPhase1.core.Author;
import com.FoundationProgramPhase1.core.EBook;
import com.FoundationProgramPhase1.core.PaperBook;

import java.util.List;

public class LibraryRepository {

    private final List<PaperBook> paperBooks;
    private final List<EBook> eBooks;
    private final List<Author> authors;

    public LibraryRepository() {
        paperBooks = PaperBookRepository.getPaperBooks();
        eBooks = EBookRepository.getEBooks();
        authors = AuthorRepository.getAuthors();
    }

    public List<PaperBook> getPaperBooks() {
        return paperBooks;
    }

    public List<EBook> getEBooks() {
        return eBooks;
    }

    public List<Author> getAuthors() {
        return authors;
    }
}
