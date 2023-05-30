package com.FoundationProgramPhase1;

import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        ManageUsers manageUsers = new ManageUsers();
        manageUsers.createUser(new Scanner(System.in));
    }
}
