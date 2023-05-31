package com.FoundationProgramPhase1;

import com.FoundationProgramPhase1.repositories.LibraryRepository;
import com.FoundationProgramPhase1.service.UsersService;
import com.FoundationProgramPhase1.utils.OutputMessages;

import java.util.Scanner;

public class LibraryMenu {

    private final Scanner scanner;
    private final String[] choices;
    private boolean isRunning;

    private final LibraryRepository libraryRepository;
    private final UsersService usersService;
    private final OutputMessages outputMessages;

    public LibraryMenu(Scanner scanner, LibraryRepository libraryRepository, UsersService usersService, OutputMessages outputMessages) {
        this.scanner = scanner;
        this.libraryRepository = libraryRepository;
        this.usersService = usersService;
        this.outputMessages = outputMessages;
        this.choices = new String[]{"1", "2", "3", "4", " 5"};
    }



}
