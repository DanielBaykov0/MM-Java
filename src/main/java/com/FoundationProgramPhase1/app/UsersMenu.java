package com.FoundationProgramPhase1.app;

import com.FoundationProgramPhase1.core.User;
import com.FoundationProgramPhase1.repositories.LibraryRepository;
import com.FoundationProgramPhase1.service.UsersService;
import com.FoundationProgramPhase1.utils.OutputMessages;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UsersMenu {

    private final Scanner scanner;

    private final UsersService usersService;
    private final OutputMessages outputMessages;
    private final LibraryMenu libraryMenu;

    public UsersMenu(Scanner scanner, UsersService usersService, OutputMessages outputMessages, LibraryMenu libraryMenu) {
        this.scanner = scanner;
        this.usersService = usersService;
        this.outputMessages = outputMessages;
        this.libraryMenu = libraryMenu;
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
                    usersService.listAllUsers(LibraryRepository.getUsers());
                    outputMessages.printUsersMenu();
                }
                case 2 -> {
                    User user = usersService.returnCorrectUser(scanner, LibraryRepository.getUsers());
                    if (usersService.loginAsLibraryUser(user, LibraryRepository.getUsers())) {
                        libraryMenu.libraryLoop(user);
                    } else {
                        System.out.println("User doesn't exist");
                        outputMessages.printUsersMenu();
                    }
                }
                case 3 -> {
                    User user = usersService.returnCorrectUser(scanner, LibraryRepository.getUsers());
                    if (usersService.loginAsLibraryUser(user, LibraryRepository.getUsers())) {
                        libraryMenu.EBookLoop(user);
                    } else {
                        System.out.println("User doesn't exist");
                        outputMessages.printUsersMenu();
                    }
                }
                case 4 -> isRunning = false;
            }
        }
    }
}
