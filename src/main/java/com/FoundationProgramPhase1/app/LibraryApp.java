package com.FoundationProgramPhase1.app;

import com.FoundationProgramPhase1.service.LibraryService;
import com.FoundationProgramPhase1.service.UsersService;
import com.FoundationProgramPhase1.utils.OutputMessages;

import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        LibraryMenu libraryMenu = new LibraryMenu(new Scanner(System.in), new UsersService(), new LibraryService(), new OutputMessages());
        libraryMenu.userLoop();
    }
}
