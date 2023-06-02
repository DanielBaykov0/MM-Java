package com.FoundationProgramPhase1.app;

import com.FoundationProgramPhase1.core.User;
import com.FoundationProgramPhase1.repositories.*;
import com.FoundationProgramPhase1.service.LibraryService;
import com.FoundationProgramPhase1.service.UsersService;
import com.FoundationProgramPhase1.utils.LibraryUtils;
import com.FoundationProgramPhase1.utils.OutputMessages;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryMenu {

    private final Scanner scanner;

    private final UsersService usersService;
    private final LibraryService libraryService;
    private final OutputMessages outputMessages;
    private final LibraryRepository libraryRepository = new LibraryRepository();
    private final LibraryUtils libraryUtils = new LibraryUtils();

    public LibraryMenu(Scanner scanner, UsersService usersService, LibraryService libraryService, OutputMessages outputMessages) {
        this.scanner = scanner;
        this.usersService = usersService;
        this.libraryService = libraryService;
        this.outputMessages = outputMessages;
    }

    public void userLoop() {
        boolean isRunning = true;
        int choice = 0;

        outputMessages.printUsersMenu();
        while (isRunning) {
            try {
                choice = 0;
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input");
                outputMessages.printUsersMenu();
            }
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    usersService.listAllUsers(libraryRepository.getUsers());
                    outputMessages.printUsersMenu();
                }
                case 2 -> {
                    User user = usersService.returnCorrectUser(scanner, libraryRepository.getUsers());
                    if (usersService.loginAsLibraryUser(user, libraryRepository.getUsers())) {
                        libraryLoop(user);
                    } else {
                        System.out.println("User doesn't exist");
                        outputMessages.printUsersMenu();
                    }
                }
                case 3 -> {
                    User user = usersService.returnCorrectUser(scanner, libraryRepository.getUsers());
                    if (usersService.loginAsLibraryUser(user, libraryRepository.getUsers())) {
                        EBookLoop(user);
                    } else {
                        System.out.println("User doesn't exist");
                        outputMessages.printUsersMenu();
                    }
                }
                case 4 -> isRunning = false;
            }
        }
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
                    libraryService.listPaperBooks(libraryRepository.getPaperBooks());
                    outputMessages.printLibraryMenu();
                }
                case 2 -> {
                    if (!libraryUtils.searchPaperBookByTitle(scanner, user, libraryRepository.getPaperBooks())) {
                        outputMessages.printInvalidBookTitle();
                    }
                    outputMessages.printLibraryMenu();
                }
                case 3 -> {
                    libraryUtils.searchBookByGenre(scanner, libraryRepository.getPaperBooks());
                    outputMessages.printLibraryMenu();
                }
                case 4 -> {
                    libraryUtils.searchBookByDescription(scanner, libraryRepository.getPaperBooks());
                    outputMessages.printLibraryMenu();
                }
                case 5 -> {
                    libraryUtils.searchBookByAuthorFirstName(scanner, libraryRepository.getPaperBooks());
                    outputMessages.printLibraryMenu();
                }
                case 6 -> {
                    libraryUtils.searchBookByAuthorLastName(scanner, libraryRepository.getPaperBooks());
                    outputMessages.printLibraryMenu();
                }
                case 7 -> {
                    libraryService.printBooks(libraryService.getBorrowedBook());
                    outputMessages.printLibraryMenu();
                }
                case 8 -> {
                    if (libraryUtils.askForPostpone(scanner, user, user.getPaperBookList())) {
                        outputMessages.printLibraryMenu();
                    } else {
                        outputMessages.printBookNotAvailableOrPostponeDateTooLong();
                        outputMessages.printLibraryMenu();
                    }
                }

                case 9 -> {
                    libraryService.listAuthors(libraryRepository.getAuthors());
                    outputMessages.printLibraryMenu();
                }

                case 10 -> {
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
                    libraryService.listEBooks(libraryRepository.getEBooks());
                    outputMessages.printEBookMenu();
                }
                case 2 -> {
                    libraryService.listReadableEBooks(libraryRepository.getEBooks());
                    outputMessages.printEBookMenu();
                }

                case 3 -> {
                    libraryService.listDownloadableEBooks(libraryRepository.getEBooks());
                    outputMessages.printEBookMenu();
                }

                case 4 -> {
                    if (!libraryUtils.searchReadEBookByTitle(scanner, user, libraryRepository.getEBooks())) {
                        outputMessages.printInvalidBookTitle();
                    }
                    outputMessages.printEBookMenu();
                }

                case 5 -> {
                    if (!libraryUtils.searchDownloadEBookByTitle(scanner, user, libraryRepository.getEBooks())) {
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
