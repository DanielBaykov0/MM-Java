package com.FoundationProgramPhase1.utils;

import com.FoundationProgramPhase1.core.PaperBook;
import com.FoundationProgramPhase1.core.User;

import java.util.Scanner;

public class LibraryUtils {

    private final OutputMessages outputMessages = new OutputMessages();

    public LibraryUtils() {
    }

    public String returnCorrectBookTitle(Scanner scanner) {
        String title = "";
        do {
            outputMessages.enterBookTitle();
            try {
                title = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (!title.matches("[a-zA-Z\\s]*$"));

        return title;
    }

    public String returnCorrectBookGenre(Scanner scanner) {
        String username = "";
        do {
            outputMessages.enterBookGenre();
            try {
                username = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (!username.matches("[a-zA-Z\\s]*$"));

        return username;
    }

    public String returnCorrectBookDescription(Scanner scanner) {
        String username = "";
        do {
            outputMessages.enterBookDescription();
            try {
                username = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (!username.matches("[a-zA-Z\\s]*$"));

        return username;
    }

    public String returnCorrectAuthorFirstName(Scanner scanner) {
        String username = "";
        do {
            outputMessages.enterAuthorFirstName();
            try {
                username = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (!username.matches("[a-zA-Z\\s]*$"));

        return username;
    }

    public String returnCorrectAuthorLastName(Scanner scanner) {
        String username = "";
        do {
            outputMessages.enterAuthorLastName();
            try {
                username = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (!username.matches("[a-zA-Z\\s]*$"));

        return username;
    }

    public int askForBookISBN(Scanner scanner, User user) {
        outputMessages.enterBookISBN();
        int input = scanner.nextInt();

        for (PaperBook paperBook : user.getPaperBookList()) {
            if (paperBook.getISBN() == input) {
                return paperBook.getISBN();
            }
        }

        return 0;
    }
}
