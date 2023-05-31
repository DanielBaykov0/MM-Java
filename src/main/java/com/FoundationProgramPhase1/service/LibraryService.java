package com.FoundationProgramPhase1.service;

import com.FoundationProgramPhase1.core.EBook;
import com.FoundationProgramPhase1.core.PaperBook;
import com.FoundationProgramPhase1.core.User;
import com.FoundationProgramPhase1.utils.LibraryUtils;
import com.FoundationProgramPhase1.utils.OutputMessages;
import com.FoundationProgramPhase1.utils.UserUtils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LibraryService {

    private final UserUtils userUtils = new UserUtils();
    private final OutputMessages outputMessages = new OutputMessages();
    private final LibraryUtils libraryUtils = new LibraryUtils();

    public LibraryService() {
    }

    public Map<User, PaperBook> borrowPaperBook(Scanner scanner, User user, List<PaperBook> paperBooks) {
        String title = libraryUtils.returnCorrectBookTitle(scanner);
        PaperBook paperBook = libraryUtils.returnPaperBookByTitle(title);
//        Map<LocalDate, Map<User, PaperBook>> localDateMap = new HashMap<>();
        Map<User, PaperBook> userPaperBookMap = new HashMap<>();

        userPaperBookMap.put(user, paperBook);
//        localDateMap.put(LocalDate.now(), userPaperBookMap);
        paperBook.setPaperBookNumberOfCopiesAvailable(paperBook.getPaperBookNumberOfCopiesTotal() - 1);

        System.out.println("You borrowed the book: " + paperBook.getBookTitle());
        return userPaperBookMap;
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

    public void searchBookByTitle(Scanner scanner, List<PaperBook> paperBooks) {
        String bookName = libraryUtils.returnCorrectBookTitle(scanner);
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookTitle().equals(bookName)) {
                System.out.println(paperBook);
            }
        }
    }

    public void searchBookByGenre(Scanner scanner, List<PaperBook> paperBooks) {
        String bookGenre = libraryUtils.returnCorrectBookGenre(scanner);
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookGenre().equals(bookGenre)) {
                System.out.println(paperBook);
            }
        }
    }

    public void searchBookByDescription(Scanner scanner, List<PaperBook> paperBooks) {
        String bookDesc = libraryUtils.returnCorrectBookDescription(scanner);
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookDescription().contains(bookDesc)) {
                System.out.println(paperBook);
            }
        }
    }

    public void searchBookByAuthorFirstName(Scanner scanner, List<PaperBook> paperBooks) {
        String authorFirstName = libraryUtils.returnCorrectAuthorFirstName(scanner);
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookAuthor().contains(authorFirstName)) {
                System.out.println(paperBook);
            }
        }
    }

    public void searchBookByAuthorLastName(Scanner scanner, List<PaperBook> paperBooks) {
        String authorLastName = libraryUtils.returnCorrectAuthorLastName(scanner);
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookAuthor().contains(authorLastName)) {
                System.out.println(paperBook);
            }
        }
    }

    public void listPaperBooks(List<PaperBook> paperBooks) {
        for (PaperBook paperBook : paperBooks) {
            System.out.println(paperBook);
        }
    }

    public void listEBooks(List<EBook> eBooks) {
        for (EBook EBook : eBooks) {
            System.out.println(EBook);
        }
    }
}
