package com.FoundationProgramPhase1.utils;

import com.FoundationProgramPhase1.core.PaperBook;
import com.FoundationProgramPhase1.repositories.LibraryRepository;

import java.util.Map;
import java.util.Scanner;

public class LibraryHelper {

    private final OutputMessages outputMessages = new OutputMessages();

    public LibraryHelper() {
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

    public int askForBookId(Scanner scanner, Map<Integer, PaperBook> paperBooks) {
        outputMessages.enterBookId();
        int input = scanner.nextInt();

        for (Map.Entry<Integer, PaperBook> entry : paperBooks.entrySet()) {
            if (entry.getKey() == input) {
                return entry.getKey();
            }
        }

        return 0;
    }

    public void updatePaperBookTotalCopies(String bookName) {
        for (Map.Entry<Integer, PaperBook> entry1 : LibraryRepository.getPaperBooks().entrySet()) {
            if (entry1.getValue().getBookTitle().equals(bookName)) {
                entry1.getValue().setPaperBookNumberOfCopiesTotal(entry1.getValue().getPaperBookNumberOfCopiesTotal() - 1);
            }
            System.out.println(entry1.getValue().getBookTitle() + " total copies = " + entry1.getValue().getPaperBookNumberOfCopiesTotal());
        }
    }
}
