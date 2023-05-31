package com.FoundationProgramPhase1.utils;

import com.FoundationProgramPhase1.core.User;

public class OutputMessages {

    public OutputMessages() {
    }

    public void enterUsername() {
        System.out.println("Please enter a username: ");
    }

    public void enterPassword() {
        System.out.println("Please enter a password between 8 and 20 symbols: ");
    }

    public void enterName() {
        System.out.println("Please enter your full name: ");
    }

    public void enterUserAge() {
        System.out.println("Please enter your age: ");
    }

    public void enterUserGender() {
        System.out.println("Please enter your gender(male/female): ");
    }

    public void enterUserAddress() {
        System.out.println("Please enter your address: ");
    }

    public void enterUserCity() {
        System.out.println("Please enter the city that you live in: ");
    }

    public void enterUserCountry() {
        System.out.println("Please enter the country that you live in: ");
    }

    public void enterUserEmail() {
        System.out.println("Please enter your email: ");
    }

    public void enterPostponeDays() {
        System.out.println("Please enter how many days do you want to postpone the final date with: ");
    }

    public void printUserCreated(User user) {
        System.out.println("User created successfully!");
        System.out.println(user);
    }

    public void askGDPR() {
        System.out.println("Before proceeding please review our privacy policy.");
        System.out.println("It describes how we collect, store and protect your data.");
        System.out.println("Please enter " + "'yes'" + " if you agree or " + "'no'" + " if you don't!");
    }

    public void enterBookType() {
        System.out.println("Please enter book type(paper book/ebook): ");
    }

    public void enterBookTitle() {
        System.out.println("Please enter book title: ");
    }

    public void enterBookAuthor() {
        System.out.println("Please enter book author: ");
    }

    public void enterBookGenre() {
        System.out.println("Please enter book genre: ");
    }

    public void enterBookDescription() {
        System.out.println("Please enter book description: ");
    }

    public void enterBookISBN() {
        System.out.println("Please enter book ISBN: ");
    }

    public void enterPaperBookTotalNumberOfCopies() {
        System.out.println("Please enter paper book total number of copies: ");
    }

    public void enterEBookReadLink() {
        System.out.println("Please enter Ebook online read link: ");
    }

    public void enterEBookDownloadLink() {
        System.out.println("Please enter Ebook online download link: ");
    }

    public void enterAuthorFirstName() {
        System.out.println("Please enter author's first name: ");
    }

    public void enterAuthorLastName() {
        System.out.println("Please enter author's last name: ");
    }

    public void enterAuthorCountryBorn() {
        System.out.println("Please enter author's country born: ");
    }

    public void enterAuthorBirthDate() {
        System.out.println("Please enter author's birth date: ");
    }

    public void enterAuthorIsAlive() {
        System.out.println("Please enter 'yes' if author is alive or 'no' if dead: ");
    }

    public void enterAuthorDeathDate() {
        System.out.println("Please enter author's death date: ");
    }

    public void printBookNotAvailable() {
        System.out.println("Sorry this book is not available");
    }

    public void printLibraryMenu() {
        System.out.println("Welcome to the Library!");
        System.out.println("Choose:");
        System.out.println("\t 1 - List all paper books.");
        System.out.println("\t 2 - Search a paper book by name.");
        System.out.println("\t 3 - Search a paper book by genre.");
        System.out.println("\t 4 - Search a paper book by description.");
        System.out.println("\t 5 - Search a paper book by author first name.");
        System.out.println("\t 6 - Search a paper book by author last name.");
        System.out.println("\t 7 - Choose a book to borrow.");
        System.out.println("\t 8 - Go back to main menu.");
    }

    public void printEBookMenu() {
        System.out.println("Welcome to the EBooks Paradise!");
        System.out.println("Choose:");
        System.out.println("\t 1 - List all Ebooks.");
        System.out.println("\t 2 - Choose an ebook to read online.");
        System.out.println("\t 3 - Choose an ebook to download.");
        System.out.println("\t 4 - Go back to main menu.");
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
