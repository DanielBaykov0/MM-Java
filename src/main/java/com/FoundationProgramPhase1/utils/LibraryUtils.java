package com.FoundationProgramPhase1.utils;

import com.FoundationProgramPhase1.Book;
import com.FoundationProgramPhase1.EBook;
import com.FoundationProgramPhase1.PaperBook;
import com.FoundationProgramPhase1.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LibraryUtils {

    private final UserUtils userUtils = new UserUtils();

    public LibraryUtils() {
    }

    public Map<LocalDate, Map<User, PaperBook>> borrowPaperBook(User user, PaperBook paperBook, List<PaperBook> paperBooks) {
        Map<LocalDate, Map<User, PaperBook>> localDateMap = new HashMap<>();
        Map<User, PaperBook> userPaperBookMap = new HashMap<>();
        if (paperBooks.contains(paperBook)) {
            userPaperBookMap.put(user, paperBook);
            localDateMap.put(LocalDate.now(), userPaperBookMap);
            paperBook.setPaperBookNumberOfCopiesAvailable(paperBook.getPaperBookNumberOfCopiesTotal() - 1);
        }

        return localDateMap;
    }

    public Map<User, EBook> readEBook(User user, EBook eBook, List<EBook> eBooks) {
        Map<User, EBook> userEBookMap = new HashMap<>();
        if (eBooks.contains(eBook)) {
            userEBookMap.put(user, eBook);
        }

        return userEBookMap;
    }

    public Map<User, EBook> downloadEBook(User user, EBook eBook, List<EBook> eBooks) {
        Map<User, EBook> userEBookMap = new HashMap<>();
        if (eBooks.contains(eBook) && !"Not downloadable for free".equals(eBook.getEBookDownloadLink())) {
            userEBookMap.put(user, eBook);
        }

        return userEBookMap;
    }

    public LocalDate askForPostpone(Scanner scanner, Map<LocalDate, Map<User, PaperBook>> localDateMapMap) {
        int numberOfDays = userUtils.returnCorrectPostponeDays(scanner);
        LocalDate returnDate = null;
        for (Map.Entry<LocalDate, Map<User, PaperBook>> entry : localDateMapMap.entrySet()) {
            returnDate = entry.getKey().plusDays(numberOfDays);
        }

        return returnDate;
    }

    public LocalDate getLastReturnDatePaperBook(Map<LocalDate, Map<User, PaperBook>> localDateMapMap) {
        LocalDate finalReturnDate = null;
        for (Map.Entry<LocalDate, Map<User, PaperBook>> entry : localDateMapMap.entrySet()) {
            finalReturnDate = entry.getKey().plusDays(14);
        }

        return finalReturnDate;
    }

    public Book searchBookByName(Scanner scanner, List<PaperBook> paperBooks) {
        String bookName = userUtils.returnCorrectName(scanner);
        Book book = null;
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookTitle().equals(bookName)) {
                book = paperBook;
            }
        }

        return book;
    }

    public Book searchBookByGenre(Scanner scanner, List<PaperBook> paperBooks) {
        String bookGenre = userUtils.returnCorrectName(scanner);
        Book book = null;
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookGenre().equals(bookGenre)) {
                book = paperBook;
            }
        }

        return book;
    }

    public Book searchBookByTags(Scanner scanner, List<PaperBook> paperBooks) {
        String bookTags = userUtils.returnCorrectName(scanner);
        Book book = null;
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookDescription().contains(bookTags)) {
                book = paperBook;
            }
        }

        return book;
    }

    public Book searchBookByAuthorFirstName(Scanner scanner, List<PaperBook> paperBooks) {
        String authorFirstName = userUtils.returnCorrectName(scanner);
        Book book = null;
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookAuthor().contains(authorFirstName)) {
                book = paperBook;
            }
        }

        return book;
    }

    public Book searchBookByAuthorLastName(Scanner scanner, List<PaperBook> paperBooks) {
        String authorLastName = userUtils.returnCorrectName(scanner);
        Book book = null;
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookAuthor().contains(authorLastName)) {
                book = paperBook;
            }
        }

        return book;
    }
}
