package com.FoundationProgramPhase1.repositories;

import com.FoundationProgramPhase1.core.Author;
import com.FoundationProgramPhase1.core.EBook;
import com.FoundationProgramPhase1.core.PaperBook;
import com.FoundationProgramPhase1.core.User;

import java.util.List;
import java.util.Map;

public class LibraryRepository {

    private static final Map<Integer, PaperBook> paperBooks = PaperBookRepository.getPaperBooks();
    private static final List<EBook> eBooks = EBookRepository.getEBooks();
    private static final List<Author> authors = AuthorRepository.getAuthors();
    private static final List<User> users = UserRepository.getUsers();


    public static Map<Integer, PaperBook> getPaperBooks() {
        return paperBooks;
    }

    public static List<EBook> getEBooks() {
        return eBooks;
    }

    public static List<Author> getAuthors() {
        return authors;
    }

    public static List<User> getUsers() {
        return users;
    }
}
