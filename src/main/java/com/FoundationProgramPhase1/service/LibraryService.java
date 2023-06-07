package com.FoundationProgramPhase1.service;

import com.FoundationProgramPhase1.core.Author;
import com.FoundationProgramPhase1.core.EBook;
import com.FoundationProgramPhase1.core.PaperBook;
import com.FoundationProgramPhase1.core.User;
import com.FoundationProgramPhase1.utils.OutputMessages;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LibraryService {

    private final OutputMessages outputMessages = new OutputMessages();
    private static List<User> borrowedBook;

    private static List<User> userEBooksReadList;
    private static List<User> userEBooksDownloadedList;

    public LibraryService() {
        borrowedBook = new ArrayList<>();
        userEBooksReadList = new ArrayList<>();
        userEBooksDownloadedList = new ArrayList<>();
    }

    public void borrowPaperBook(Scanner scanner, User user, int id, PaperBook paperBook, Map<Integer, PaperBook> bookList) {
        outputMessages.printWouldYouBorrowBook();
        String input = scanner.nextLine();
        LocalDate localDate = LocalDate.now();

        switch (input) {
            case "yes" -> {
                bookList.put(id, paperBook);
                user.setPaperBookList(bookList);
                paperBook.setBorrowedDate(localDate);
                if (!getBorrowedBook().contains(user)) {
                    getBorrowedBook().add(user);
                    setBorrowedBook(getBorrowedBook());
                }
                paperBook.setPaperBookNumberOfCopiesAvailable(paperBook.getPaperBookNumberOfCopiesAvailable() - 1);
                System.out.println("You borrowed the book: " + paperBook.getBookTitle());
                System.out.println(paperBook.getBookTitle() + " available copies = " + paperBook.getPaperBookNumberOfCopiesAvailable());
            }

            case "no" -> {
            }
        }
    }

    public void readEBook(Scanner scanner, User user, EBook eBook, List<EBook> eBooks) {
        outputMessages.printWouldYouReadBook();
        String input = scanner.nextLine();

        switch (input) {
            case "yes" -> {
                if (!user.geteBookReadList().contains(eBook)) {
                    eBooks.add(eBook);
                    user.setEBookReadList(eBooks);
                    System.out.println("You read " + eBook.getBookTitle());
                } else {
                    outputMessages.printCantAddBook();
                }
                if (!getUserEBooksReadList().contains(user)) {
                    getUserEBooksReadList().add(user);
                    setUserEBooksReadList(getUserEBooksReadList());
                }
            }

            case "no" -> {
            }
        }
    }

    public void downloadEBook(Scanner scanner, User user, EBook eBook, List<EBook> eBooks) {
        outputMessages.printWouldYouDownloadBook();
        String input = scanner.nextLine();

        switch (input) {
            case "yes" -> {
                if (!user.geteBookDownloadedList().contains(eBook)) {
                    eBooks.add(eBook);
                    user.setEBookDownloadedList(eBooks);
                    System.out.println("You downloaded " + eBook.getBookTitle());
                } else {
                    System.out.println("Can not add this book");
                }
                if (!getUserEBooksDownloadedList().contains(user)) {
                    getUserEBooksDownloadedList().add(user);
                    setUserEBooksDownloadedList(getUserEBooksDownloadedList());
                }
            }

            case "no" -> {
            }
        }
    }

    public void listPaperBooks(Map<Integer, PaperBook> paperBooks) {
        for (Map.Entry<Integer, PaperBook> entry : paperBooks.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public void listEBooks(List<EBook> eBooks) {
        for (EBook EBook : eBooks) {
            System.out.println(EBook);
        }
    }

    public void listAuthors(List<Author> authors) {
        for (Author author : authors) {
            System.out.println(author);
        }
    }

    public void listReadableEBooks(List<EBook> eBooks) {
        for (EBook eBook : eBooks) {
            if (!eBook.getEBookReadOnlineLink().equals("Not readable")) {
                System.out.println(eBook);
            }
        }
    }

    public void listDownloadableEBooks(List<EBook> eBooks) {
        for (EBook eBook : eBooks) {
            if (!eBook.getEBookDownloadLink().equals("Not downloadable for free")) {
                System.out.println(eBook);
            }
        }
    }

    public void printBooks(List<User> users) {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public List<User> getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(List<User> borrowedBook) {
        LibraryService.borrowedBook = borrowedBook;
    }

    public List<User> getUserEBooksReadList() {
        return userEBooksReadList;
    }

    public static void setUserEBooksReadList(List<User> userEBooksReadList) {
        LibraryService.userEBooksReadList = userEBooksReadList;
    }

    public static List<User> getUserEBooksDownloadedList() {
        return userEBooksDownloadedList;
    }

    public static void setUserEBooksDownloadedList(List<User> userEBooksDownloadedList) {
        LibraryService.userEBooksDownloadedList = userEBooksDownloadedList;
    }
}
