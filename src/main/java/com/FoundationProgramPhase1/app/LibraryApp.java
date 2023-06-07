package com.FoundationProgramPhase1.app;

import com.FoundationProgramPhase1.repositories.LibraryRepository;
import com.FoundationProgramPhase1.service.LibraryService;
import com.FoundationProgramPhase1.service.UsersService;
import com.FoundationProgramPhase1.utils.LibraryUtils;
import com.FoundationProgramPhase1.utils.OutputMessages;

import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        UsersMenu usersMenu = new UsersMenu(new Scanner(System.in), new UsersService(), new LibraryRepository(), new OutputMessages(),
                new LibraryMenu(new Scanner(System.in), new LibraryService(), new OutputMessages(), new LibraryUtils()));
        usersMenu.userLoop();
    }
}
