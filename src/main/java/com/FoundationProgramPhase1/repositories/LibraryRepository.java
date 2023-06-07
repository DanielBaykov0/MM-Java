package com.FoundationProgramPhase1.repositories;

import com.FoundationProgramPhase1.core.Author;
import com.FoundationProgramPhase1.core.EBook;
import com.FoundationProgramPhase1.core.PaperBook;
import com.FoundationProgramPhase1.core.User;

import java.util.List;
import java.util.Map;

public class LibraryRepository {

    private static Map<Integer, PaperBook> paperBooks;
    private static List<EBook> eBooks;
    private static List<Author> authors;
    private static List<User> users;

    public LibraryRepository() {
        paperBooks = PaperBookRepository.getPaperBooks();
        eBooks = EBookRepository.getEBooks();
        authors = AuthorRepository.getAuthors();
        users = UserRepository.getUsers();
    }

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
