package com.FoundationProgramPhase1.service;

import com.FoundationProgramPhase1.core.Book;
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

    public Map<LocalDate, Map<User, PaperBook>> borrowPaperBook(Scanner scanner, User user, PaperBook paperBook, List<PaperBook> paperBooks) {
        System.out.println("Would you like to borrow this book?");
        System.out.println("Type " + "'yes'" + " or " + "'no'");
        String answer = scanner.nextLine();
        Map<LocalDate, Map<User, PaperBook>> localDateMap = new HashMap<>();
        Map<User, PaperBook> userPaperBookMap = new HashMap<>();

        switch (answer) {
            case "yes":
                if (paperBooks.contains(paperBook)) {
                    userPaperBookMap.put(user, paperBook);
                    localDateMap.put(LocalDate.now(), userPaperBookMap);
                    paperBook.setPaperBookNumberOfCopiesAvailable(paperBook.getPaperBookNumberOfCopiesTotal() - 1);
                }
                System.out.println("You borrowed the book: " + paperBook.getBookTitle());
                break;

            case "no":
                break;
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

    public boolean searchBookByName(Scanner scanner, User user, List<PaperBook> paperBooks) {
        String bookName = libraryUtils.returnCorrectBookTitle(scanner);
        Book book;
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookTitle().equals(bookName)) {
                book = paperBook;
                System.out.println(book);

                if (!(paperBook.getPaperBookNumberOfCopiesAvailable() < 0)) {
                    borrowPaperBook(scanner, user, paperBook, paperBooks);
                } else {
                    outputMessages.printBookNotAvailable();
                }
                return true;
            }
        }

        return false;
    }

    public boolean searchBookByGenre(Scanner scanner, User user, List<PaperBook> paperBooks) {
        String bookGenre = libraryUtils.returnCorrectBookGenre(scanner);
        Book book;
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookGenre().equals(bookGenre)) {
                book = paperBook;
                System.out.println(book);

                if (!(paperBook.getPaperBookNumberOfCopiesAvailable() < 0)) {
                    borrowPaperBook(scanner, user, paperBook, paperBooks);
                } else {
                    outputMessages.printBookNotAvailable();
                }
                return true;
            }
        }

        return false;
    }

    public boolean searchBookByDesctiption(Scanner scanner, User user, List<PaperBook> paperBooks) {
        String bookDesc = libraryUtils.returnCorrectBookDescription(scanner);
        Book book;
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookDescription().contains(bookDesc)) {
                book = paperBook;
                System.out.println(book);

                if (!(paperBook.getPaperBookNumberOfCopiesAvailable() < 0)) {
                    borrowPaperBook(scanner, user, paperBook, paperBooks);
                } else {
                    outputMessages.printBookNotAvailable();
                }
                return true;
            }
        }

        return false;
    }

    public boolean searchBookByAuthorFirstName(Scanner scanner, User user, List<PaperBook> paperBooks) {
        String authorFirstName = libraryUtils.returnCorrectAuthorFirstName(scanner);
        Book book;
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookAuthor().contains(authorFirstName)) {
                book = paperBook;
                System.out.println(book);

                if (!(paperBook.getPaperBookNumberOfCopiesAvailable() < 0)) {
                    borrowPaperBook(scanner, user, paperBook, paperBooks);
                } else {
                    outputMessages.printBookNotAvailable();
                }
                return true;
            }
        }

        return false;
    }

    public boolean searchBookByAuthorLastName(Scanner scanner, User user, List<PaperBook> paperBooks) {
        String authorLastName = libraryUtils.returnCorrectAuthorLastName(scanner);
        Book book;
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookAuthor().contains(authorLastName)) {
                book = paperBook;
                System.out.println(book);

                if (!(paperBook.getPaperBookNumberOfCopiesAvailable() < 0)) {
                    borrowPaperBook(scanner, user, paperBook, paperBooks);
                } else {
                    outputMessages.printBookNotAvailable();
                }
                return true;
            }
        }

        return false;
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
