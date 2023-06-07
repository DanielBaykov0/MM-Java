package com.FoundationProgramPhase1.app;

import com.FoundationProgramPhase1.core.User;
import com.FoundationProgramPhase1.repositories.LibraryRepository;
import com.FoundationProgramPhase1.service.LibraryService;
import com.FoundationProgramPhase1.utils.LibraryUtils;
import com.FoundationProgramPhase1.utils.OutputMessages;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryMenu {

    private final Scanner scanner;

    private final LibraryService libraryService;
    private final OutputMessages outputMessages;
    private final LibraryUtils libraryUtils;

    public LibraryMenu(Scanner scanner, LibraryService libraryService, OutputMessages outputMessages, LibraryUtils libraryUtils) {
        this.scanner = scanner;
        this.libraryService = libraryService;
        this.outputMessages = outputMessages;
        this.libraryUtils = libraryUtils;
    }

    public void libraryLoop(User user) {
        boolean isRunning = true;
        int choice = 0;

        outputMessages.printLibraryMenu();
        while (isRunning) {
            System.out.println("Enter your choice:");
            try {
                choice = 0;
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input");
                outputMessages.printLibraryMenu();
            }
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    libraryService.listPaperBooks(LibraryRepository.getPaperBooks());
                    outputMessages.printLibraryMenu();
                }
                case 2 -> {
                    if (!libraryUtils.searchPaperBookByTitle(scanner, user, LibraryRepository.getPaperBooks())) {
                        outputMessages.printInvalidBookTitle();
                    }
                    outputMessages.printLibraryMenu();
                }
                case 3 -> {
                    libraryUtils.searchBookByGenre(scanner, LibraryRepository.getPaperBooks());
                    outputMessages.printLibraryMenu();
                }
                case 4 -> {
                    libraryUtils.searchBookByDescription(scanner, LibraryRepository.getPaperBooks());
                    outputMessages.printLibraryMenu();
                }
                case 5 -> {
                    libraryUtils.searchBookByAuthorFirstName(scanner, LibraryRepository.getPaperBooks());
                    outputMessages.printLibraryMenu();
                }
                case 6 -> {
                    libraryUtils.searchBookByAuthorLastName(scanner, LibraryRepository.getPaperBooks());
                    outputMessages.printLibraryMenu();
                }
                case 7 -> {
                    libraryService.printBooks(libraryService.getBorrowedBook());
                    outputMessages.printLibraryMenu();
                }
                case 8 -> {
                    if (libraryUtils.askForPaperBookPostpone(scanner, user, user.getPaperBookList())) {
                        outputMessages.printLibraryMenu();
                    } else {
                        outputMessages.printBookNotAvailableOrPostponeDateTooLong();
                        outputMessages.printLibraryMenu();
                    }
                }

                case 9 -> {
                    if (libraryUtils.askToReturnPaperBook(scanner, user, LibraryRepository.getPaperBooks())) {
                        outputMessages.printLibraryMenu();
                    }
                }

                case 10 -> {
                    libraryService.listAuthors(LibraryRepository.getAuthors());
                    outputMessages.printLibraryMenu();
                }

                case 11 -> {
                    isRunning = false;
                    outputMessages.printUsersMenu();
                }
            }
        }
    }

    public void EBookLoop(User user) {
        boolean isRunning = true;
        int choice = 0;

        outputMessages.printEBookMenu();
        while (isRunning) {
            System.out.println("Enter your choice:");
            try {
                choice = 0;
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input");
                outputMessages.printEBookMenu();
            }
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    libraryService.listEBooks(LibraryRepository.getEBooks());
                    outputMessages.printEBookMenu();
                }
                case 2 -> {
                    libraryService.listReadableEBooks(LibraryRepository.getEBooks());
                    outputMessages.printEBookMenu();
                }

                case 3 -> {
                    libraryService.listDownloadableEBooks(LibraryRepository.getEBooks());
                    outputMessages.printEBookMenu();
                }

                case 4 -> {
                    if (!libraryUtils.searchReadEBookByTitle(scanner, user, LibraryRepository.getEBooks())) {
                        outputMessages.printInvalidBookTitle();
                    }
                    outputMessages.printEBookMenu();
                }

                case 5 -> {
                    if (!libraryUtils.searchDownloadEBookByTitle(scanner, user, LibraryRepository.getEBooks())) {
                        outputMessages.printInvalidBookTitle();
                    }
                    outputMessages.printEBookMenu();
                }
                case 6 -> {
                    libraryService.printBooks(libraryService.getUserEBooksReadList());
                    outputMessages.printEBookMenu();
                }
                case 7 -> {
                    isRunning = false;
                    outputMessages.printUsersMenu();
                }
            }
        }
    }
}
