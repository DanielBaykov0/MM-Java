package com.FoundationProgramPhase1.utils;

import com.FoundationProgramPhase1.core.PaperBook;
import com.FoundationProgramPhase1.repositories.PaperBookRepository;

import java.util.Scanner;

public class LibraryUtils {

    private final OutputMessages outputMessages = new OutputMessages();

    public LibraryUtils() {
    }

    public String returnCorrectBookTitle(Scanner scanner) {
        String username = "";
        do {
            outputMessages.enterBookTitle();
            try {
                username = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (!username.matches("[a-zA-Z\\s]*$"));

        return username;
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

    public PaperBook returnPaperBookByTitle(String title) {
        PaperBook returnPaperBook = null;
        for (PaperBook paperBook : PaperBookRepository.getPaperBooks()) {
            if (paperBook.getBookTitle().equals(title)) {
                returnPaperBook = paperBook;
            }
        }

        return returnPaperBook;
    }
}
