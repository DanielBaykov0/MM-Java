package com.FoundationProgramPhase1.utils;

public class OutputMessages {

    public OutputMessages() {
    }

    public void enterName() {
        System.out.println("Please enter your full name: ");
    }

    public void enterPostponeDays() {
        System.out.println("Please enter how many days do you want to postpone the final date with: ");
    }

    public void enterBookTitle() {
        System.out.println("Please enter book title: ");
    }

    public void enterBookGenre() {
        System.out.println("Please enter book genre: ");
    }

    public void enterBookDescription() {
        System.out.println("Please enter book description: ");
    }

    public void enterAuthorFirstName() {
        System.out.println("Please enter author's first name: ");
    }

    public void enterAuthorLastName() {
        System.out.println("Please enter author's last name: ");
    }

    public void enterBookId() {
        System.out.println("Please enter paper book id: ");
    }

    public void printBookNotAvailable() {
        System.out.println("Sorry this book is not available");
    }

    public void printInvalidBookTitle() {
        System.out.println("Invalid book title");
    }

    public void printInvalidPostponeDays() {
        System.out.println("You can only postpone up to 14 days max");
    }

    public void printWouldYouBorrowBook() {
        System.out.println("Would you like to borrow this book?(yes/no)");
    }

    public void printWouldYouReturnBook() {
        System.out.println("Would you like to return this book?(yes/no)");
    }

    public void printWouldYouReadBook() {
        System.out.println("Would you like to read this book?(yes/no)");
    }

    public void printWouldYouDownloadBook() {
        System.out.println("Would you like to download this book?(yes/no)");
    }

    public void printCantAddBook() {
        System.out.println("Can not add this book");
    }

    public void printBookNotAvailableOrPostponeDateTooLong() {
        System.out.println("This book is not available or the postpone date is incorrect(up to 14 days)");
    }

    public void printLibraryMenu() {
        System.out.println("Welcome to the Library!");
        System.out.println("Choose:");
        System.out.println("\t 1 - List all paper books.");
        System.out.println("\t 2 - Search a paper book by title.");
        System.out.println("\t 3 - Search a paper book by genre.");
        System.out.println("\t 4 - Search a paper book by description.");
        System.out.println("\t 5 - Search a paper book by author first name.");
        System.out.println("\t 6 - Search a paper book by author last name.");
        System.out.println("\t 7 - Print all your books.");
        System.out.println("\t 8 - Ask for postpone.");
        System.out.println("\t 9 - Ask to return a book.");
        System.out.println("\t 10 - Print all authors.");
        System.out.println("\t 11 - Go back to main menu.");
    }

    public void printEBookMenu() {
        System.out.println("Welcome to the EBooks Paradise!");
        System.out.println("Choose:");
        System.out.println("\t 1 - List all Ebooks.");
        System.out.println("\t 2 - Print all readable Ebooks.");
        System.out.println("\t 3 - Print all downloadable Ebooks.");
        System.out.println("\t 4 - Choose an ebook to read online.");
        System.out.println("\t 5 - Choose an ebook to download.");
        System.out.println("\t 6 - Print all your books.");
        System.out.println("\t 7 - Go back to main menu.");
    }

    public void printUsersMenu() {
        System.out.println("Welcome!");
        System.out.println("Choose:");
        System.out.println("\t 1 - List all library users.");
        System.out.println("\t 2 - Go to the library.");
        System.out.println("\t 3 - Go to the ebook heaven.");
        System.out.println("\t 4 - Quit.");
    }
}
