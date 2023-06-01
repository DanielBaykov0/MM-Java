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
    private Map<Map<User, PaperBook>, LocalDate> borrowedBook;
    private Map<User, PaperBook> userPaperBookMap;
    private LocalDate returnDate = LocalDate.now();

    public LibraryService() {
        borrowedBook = new HashMap<>();
        userPaperBookMap = new HashMap<>();
    }

    public void borrowPaperBook(User user, PaperBook paperBook) {
        Scanner scanner = new Scanner(System.in);
        outputMessages.printWouldYouBorrowBook();
        String input = scanner.nextLine();

        switch (input) {
            case "yes" -> {
                paperBook.setPaperBookNumberOfCopiesAvailable(paperBook.getPaperBookNumberOfCopiesAvailable() - 1);
                userPaperBookMap.put(user, paperBook);
                borrowedBook.put(userPaperBookMap, returnDate);
                System.out.println("You borrowed the book: " + paperBook.getBookTitle());
            }

            case "no" -> {
            }
        }
    }

    public void printBorrowedBooks(Map<Map<User, PaperBook>, LocalDate> borrowedBook) {
        for (Map.Entry<Map<User, PaperBook>, LocalDate> entry : borrowedBook.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

//    public Map<User, EBook> readEBook(Scanner scanner, User user, List<EBook> eBooks) {
//        String title = libraryUtils.returnCorrectBookTitle(scanner);
//
//        Map<User, EBook> userEBookMap = new HashMap<>();
//        if (eBooks.contains(eBook)) {
//            userEBookMap.put(user, eBook);
//        }
//
//        return userEBookMap;
//    }

    public Map<User, EBook> downloadEBook(Scanner scanner, User user, List<EBook> eBooks) {
        String title = libraryUtils.returnCorrectBookTitle(scanner);
        EBook newEBook = null;
        for (EBook eBook : eBooks) {
            if (eBook.getBookTitle().equals(title)) {
                newEBook = eBook;
            }
        }

        Map<User, EBook> userEBookMap = new HashMap<>();
        if (eBooks.contains(newEBook)) {
            assert newEBook != null;
            if (!"Not downloadable for free".equals(newEBook.getEBookDownloadLink())) {
                userEBookMap.put(user, newEBook);
            }
        }
        System.out.println("You downloaded: " + newEBook);
        return userEBookMap;
    }

    public void askForPostpone(Scanner scanner, User user) {
        int numberOfDays = userUtils.returnCorrectPostponeDays(scanner);
        for (Map.Entry<Map<User, PaperBook>, LocalDate> entry : borrowedBook.entrySet()) {
            LocalDate newLocalDate = entry.getValue().plusDays(numberOfDays);
            for (Map.Entry<User, PaperBook> paperBookEntry : entry.getKey().entrySet()) {
                if (paperBookEntry.getKey().equals(user)) {
                    borrowedBook.put(userPaperBookMap, newLocalDate);
                }
            }

            System.out.println(getBorrowedBook());
            System.out.println(newLocalDate);
        }
    }

//    public LocalDate getReturnDate(LocalDate localDate, Map<LocalDate, Map<User, PaperBook>> localDateMapMap, Map<User, PaperBook> userPaperBookMap) {
//        LocalDate returnDate = null;
//        for (Map.Entry<LocalDate, Map<User, PaperBook>> entry : localDateMapMap.entrySet()) {
//            returnDate = entry.getKey();
//        }
//
//        return returnDate;
//    }

    public LocalDate getLastReturnDatePaperBook(Map<LocalDate, Map<User, PaperBook>> localDateMapMap) {
        LocalDate finalReturnDate = null;
        for (Map.Entry<LocalDate, Map<User, PaperBook>> entry : localDateMapMap.entrySet()) {
            finalReturnDate = entry.getKey().plusDays(14);
        }

        return finalReturnDate;
    }

    public boolean searchBookByTitle(Scanner scanner, User user, List<PaperBook> paperBooks) {
        String bookName = libraryUtils.returnCorrectBookTitle(scanner);
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookTitle().equals(bookName)) {
                System.out.println(paperBook);
                if (paperBook.getPaperBookNumberOfCopiesAvailable() > 0) {
                    borrowPaperBook(user, paperBook);
                    return true;
                } else {
                    outputMessages.printBookNotAvailable();
                    return false;
                }
            }
        }

        return false;
    }

    public boolean searchBookByGenre(Scanner scanner, User user, List<PaperBook> paperBooks) {
        String bookGenre = libraryUtils.returnCorrectBookGenre(scanner);
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookGenre().contains(bookGenre)) {
                System.out.println(paperBook);
                return true;
            }
        }

        return false;
    }

    public boolean searchBookByDescription(Scanner scanner, User user, List<PaperBook> paperBooks) {
        String bookDesc = libraryUtils.returnCorrectBookDescription(scanner);
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookDescription().contains(bookDesc)) {
                System.out.println(paperBook);
                return true;
            }
        }

        return false;
    }

    public boolean searchBookByAuthorFirstName(Scanner scanner, User user, List<PaperBook> paperBooks) {
        String authorFirstName = libraryUtils.returnCorrectAuthorFirstName(scanner);
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookAuthor().contains(authorFirstName)) {
                System.out.println(paperBook);
                return true;
            }
        }

        return false;
    }

    public boolean searchBookByAuthorLastName(Scanner scanner, User user, List<PaperBook> paperBooks) {
        String authorLastName = libraryUtils.returnCorrectAuthorLastName(scanner);
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookAuthor().contains(authorLastName)) {
                System.out.println(paperBook);
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

    public Map<Map<User, PaperBook>, LocalDate> getBorrowedBook() {
        return borrowedBook;
    }

    public Map<User, PaperBook> getUserPaperBookMap() {
        return userPaperBookMap;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
