package com.FoundationProgramPhase1;

import java.util.Scanner;

public class LibraryMenu {

    private final Scanner scanner;
    private final String[] choices;
    private boolean isRunning;

    private final LibraryRepository libraryRepository;
    private final ManageUsers manageUsers;
    private final OutputMessages outputMessages;

    public LibraryMenu(Scanner scanner, LibraryRepository libraryRepository, ManageUsers manageUsers, OutputMessages outputMessages) {
        this.scanner = scanner;
        this.libraryRepository = libraryRepository;
        this.manageUsers = manageUsers;
        this.outputMessages = outputMessages;
        this.choices = new String[]{"1", "2", "3", "4", " 5"};
    }



}
