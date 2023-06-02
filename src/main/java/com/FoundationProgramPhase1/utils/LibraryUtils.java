package com.FoundationProgramPhase1.utils;

import com.FoundationProgramPhase1.core.EBook;
import com.FoundationProgramPhase1.core.PaperBook;
import com.FoundationProgramPhase1.core.User;
import com.FoundationProgramPhase1.service.LibraryService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class LibraryUtils {

    private final LibraryHelper libraryHelper = new LibraryHelper();
    private final LibraryService libraryService = new LibraryService();
    private final OutputMessages outputMessages = new OutputMessages();
    private final UserUtils userUtils = new UserUtils();
    private final LocalDate returnDate = LocalDate.now();

    public LibraryUtils() {
    }

    public boolean searchReadEBookByTitle(Scanner scanner, User user, List<EBook> eBooks) {
        String bookName = libraryHelper.returnCorrectBookTitle(scanner);
        for (EBook eBook : eBooks) {
            if (eBook.getBookTitle().equals(bookName) && !(eBook.getEBookReadOnlineLink().equals("Not readable"))) {
                System.out.println(eBook);
                libraryService.readEBook(scanner, user, eBook, user.geteBookReadList());
                return true;
            }
        }

        return false;
    }


    public boolean searchDownloadEBookByTitle(Scanner scanner, User user, List<EBook> eBooks) {
        String bookName = libraryHelper.returnCorrectBookTitle(scanner);
        for (EBook eBook : eBooks) {
            if (eBook.getBookTitle().equals(bookName) && !(eBook.getEBookDownloadLink().equals("Not downloadable for free"))) {
                System.out.println(eBook);
                libraryService.downloadEBook(scanner, user, eBook, user.geteBookReadList());
                return true;
            }
        }

        return false;
    }

    public boolean askForPostpone(Scanner scanner, User user, List<PaperBook> paperBooks) {
        int bookISBN = libraryHelper.askForBookISBN(scanner, user);
        for (PaperBook paperBook : paperBooks) {
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

        return false;
    }

    public boolean searchPaperBookByTitle(Scanner scanner, User user, List<PaperBook> paperBooks) {
        String bookName = libraryHelper.returnCorrectBookTitle(scanner);
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookTitle().equals(bookName)) {
                System.out.println(paperBook);
                if (paperBook.getPaperBookNumberOfCopiesAvailable() > 0) {
                    libraryService.borrowPaperBook(scanner, user, paperBook, user.getPaperBookList());
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
        String bookGenre = libraryHelper.returnCorrectBookGenre(scanner);
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookGenre().equals(bookGenre)) {
                System.out.println(paperBook);
            }
        }
    }

    public void searchBookByDescription(Scanner scanner, List<PaperBook> paperBooks) {
        String bookDesc = libraryHelper.returnCorrectBookDescription(scanner);
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookDescription().contains(bookDesc)) {
                System.out.println(paperBook);
            }
        }
    }

    public void searchBookByAuthorFirstName(Scanner scanner, List<PaperBook> paperBooks) {
        String authorFirstName = libraryHelper.returnCorrectAuthorFirstName(scanner);
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookAuthor().contains(authorFirstName)) {
                System.out.println(paperBook);
            }
        }
    }

    public void searchBookByAuthorLastName(Scanner scanner, List<PaperBook> paperBooks) {
        String authorLastName = libraryHelper.returnCorrectAuthorLastName(scanner);
        for (PaperBook paperBook : paperBooks) {
            if (paperBook.getBookAuthor().contains(authorLastName)) {
                System.out.println(paperBook);
            }
        }
    }
}
