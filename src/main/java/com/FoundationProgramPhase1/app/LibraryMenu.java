package com.FoundationProgramPhase1.app;

import com.FoundationProgramPhase1.core.PaperBook;
import com.FoundationProgramPhase1.core.User;
import com.FoundationProgramPhase1.repositories.EBookRepository;
import com.FoundationProgramPhase1.repositories.PaperBookRepository;
import com.FoundationProgramPhase1.repositories.UserRepository;
import com.FoundationProgramPhase1.service.LibraryService;
import com.FoundationProgramPhase1.service.UsersService;
import com.FoundationProgramPhase1.utils.OutputMessages;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class LibraryMenu {

    private final Scanner scanner;

    private final UsersService usersService;
    private final LibraryService libraryService;
    private final OutputMessages outputMessages;
    private Map<LocalDate, Map<User, PaperBook>> borrowedBook = new HashMap<>();

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
            }
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    usersService.listAllUsers();
                    outputMessages.printUsersMenu();
                }
                case 2 -> {
                    User user = usersService.returnCorrectUser(scanner, UserRepository.getUsers());
                    if (usersService.loginAsLibraryUser(user)) {
                        libraryLoop(user);
                    } else {
                        System.out.println("User doesn't exist");
                    }
                }
                case 3 -> {
                    User user = usersService.returnCorrectUser(scanner, UserRepository.getUsers());
                    if (usersService.loginAsLibraryUser(user)) {
                        EBookLoop(user);
                    } else {
                        System.out.println("User doesn't exist");
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
            }
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    libraryService.listPaperBooks(PaperBookRepository.getPaperBooks());
                    outputMessages.printLibraryMenu();
                }
                case 2 -> {
                    libraryService.searchBookByTitle(scanner, PaperBookRepository.getPaperBooks());
                    outputMessages.printLibraryMenu();
                }
                case 3 -> {
                    libraryService.searchBookByGenre(scanner, PaperBookRepository.getPaperBooks());
                    outputMessages.printLibraryMenu();
                }
                case 4 -> {
                    libraryService.searchBookByDescription(scanner, PaperBookRepository.getPaperBooks());
                    outputMessages.printLibraryMenu();
                }
                case 5 -> {
                    libraryService.searchBookByAuthorFirstName(scanner, PaperBookRepository.getPaperBooks());
                    outputMessages.printLibraryMenu();
                }
                case 6 -> {
                    libraryService.searchBookByAuthorLastName(scanner, PaperBookRepository.getPaperBooks());
                    outputMessages.printLibraryMenu();
                }
                case 7 -> {
                    borrowedBook.put(LocalDate.now(), libraryService.borrowPaperBook(scanner, user, PaperBookRepository.getPaperBooks()));
                    System.out.println(borrowedBook);
                }
                case 8 -> {
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
            }
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    libraryService.listEBooks(EBookRepository.getEBooks());
                    outputMessages.printEBookMenu();
                }
//                case 2 -> {
//                    libraryService.readEBook(scanner, PaperBookRepository.getPaperBooks());
//                    outputMessages.printEBookMenu();
//                }
//                case 3 -> {
//                    libraryService.downloadEBook(scanner, PaperBookRepository.getPaperBooks());
//                    outputMessages.printEBookMenu();
//                }
                case 4 -> {
                    isRunning = false;
                    outputMessages.printUsersMenu();
                }
            }
        }
    }
}
