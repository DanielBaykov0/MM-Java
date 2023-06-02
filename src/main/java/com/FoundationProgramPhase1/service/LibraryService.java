package com.FoundationProgramPhase1.service;

import com.FoundationProgramPhase1.core.Author;
import com.FoundationProgramPhase1.core.EBook;
import com.FoundationProgramPhase1.core.PaperBook;
import com.FoundationProgramPhase1.core.User;
import com.FoundationProgramPhase1.utils.LibraryUtils;
import com.FoundationProgramPhase1.utils.OutputMessages;
import com.FoundationProgramPhase1.utils.UserUtils;

import java.time.LocalDate;
import java.util.*;

public class LibraryService {

    private final UserUtils userUtils = new UserUtils();
    private final OutputMessages outputMessages = new OutputMessages();
    private final LibraryUtils libraryUtils = new LibraryUtils();
    private final List<User> borrowedBook;
    private final LocalDate returnDate = LocalDate.now();

    private final List<User> userEBooksReadList;
    private final List<User> userEBooksDownloadedList;

    public LibraryService() {
        borrowedBook = new ArrayList<>();
        userEBooksReadList = new ArrayList<>();
        userEBooksDownloadedList = new ArrayList<>();
    }

    private void borrowPaperBook(Scanner scanner, User user, PaperBook paperBook, List<PaperBook> bookList) {
        outputMessages.printWouldYouBorrowBook();
        String input = scanner.nextLine();
        LocalDate localDate = LocalDate.now();

        switch (input) {
            case "yes" -> {
                bookList.add(paperBook);
                user.setPaperBookList(bookList);
                paperBook.setBorrowedDate(localDate);
                if (!borrowedBook.contains(user)) {
                    borrowedBook.add(user);
                }
                paperBook.setPaperBookNumberOfCopiesAvailable(paperBook.getPaperBookNumberOfCopiesAvailable() - 1);
                System.out.println("You borrowed the book: " + paperBook.getBookTitle());
                System.out.println(paperBook.getBookTitle() + " available copies = " + paperBook.getPaperBookNumberOfCopiesAvailable());
            }

            case "no" -> {
            }
        }
    }

    private void readEBook(Scanner scanner, User user, EBook eBook, List<EBook> eBooks) {
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
                if (!userEBooksReadList.contains(user)) {
                    userEBooksReadList.add(user);
                }
            }

            case "no" -> {
            }
        }
    }

    public boolean searchReadEBookByTitle(Scanner scanner, User user, List<EBook> eBooks) {
        String bookName = libraryUtils.returnCorrectBookTitle(scanner);
        for (EBook eBook : eBooks) {
            if (eBook.getBookTitle().equals(bookName) && !(eBook.getEBookReadOnlineLink().equals("Not readable"))) {
                System.out.println(eBook);
                readEBook(scanner, user, eBook, user.geteBookReadList());
                return true;
            }
        }

        return false;
    }

    private void downloadEBook(Scanner scanner, User user, EBook eBook, List<EBook> eBooks) {
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
                if (!userEBooksDownloadedList.contains(user)) {
                    userEBooksDownloadedList.add(user);
                }
            }

            case "no" -> {
            }
        }
    }

    public boolean searchDownloadEBookByTitle(Scanner scanner, User user, List<EBook> eBooks) {
        String bookName = libraryUtils.returnCorrectBookTitle(scanner);
        for (EBook eBook : eBooks) {
            if (eBook.getBookTitle().equals(bookName) && !(eBook.getEBookReadOnlineLink().equals("Not downloadable for free"))) {
                System.out.println(eBook);
                downloadEBook(scanner, user, eBook, user.geteBookReadList());
                return true;
            }
        }

        return false;
    }

    public boolean askForPostpone(Scanner scanner, User user) {
        int bookISBN = libraryUtils.askForBookISBN(scanner, user);
        for (User user1 : getBorrowedBook()) {
            for (PaperBook paperBook : user1.getPaperBookList()) {
                if (paperBook.getISBN() == bookISBN) {
                    int numberOfDays = userUtils.returnCorrectPostponeDays(scanner);

                    LocalDate newLocalDate = paperBook.getBorrowedDate().plusDays(numberOfDays);
                    if (returnDate.plusDays(14).isAfter(newLocalDate)) {
                        paperBook.setBorrowedDate(newLocalDate);
                        System.out.println(paperBook.getBorrowedDate());
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }

        return false;
    }

    public boolean searchPaperBookByTitle(Scanner scanner, User user, List<PaperBook> paperBooks) {
        String bookName = libraryUtils.returnCorrectBookTitle(scanner);
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookTitle().equals(bookName)) {
                System.out.println(paperBook);
                if (paperBook.getPaperBookNumberOfCopiesAvailable() > 0) {
                    borrowPaperBook(scanner, user, paperBook, user.getPaperBookList());
                    return true;
                } else if (paperBook.getPaperBookNumberOfCopiesAvailable() == 0) {
                    outputMessages.printBookNotAvailable();
                    return false;
                }
            }
        }

        return false;
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

    public List<User> getUserEBooksReadList() {
        return userEBooksReadList;
    }
}
