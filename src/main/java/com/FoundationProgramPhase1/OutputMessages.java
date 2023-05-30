package com.FoundationProgramPhase1;

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

    public void printUserCreated(User user) {
        System.out.println("User created successfully!");
        System.out.println(user);
    }

    public void askGDPR() {
        System.out.println("Before proceeding please review our privacy policy.");
        System.out.println("It describes how we collect, store and protect your data.");
        System.out.println("Please enter " + "'yes'" + " if you agree or " + "'no'" + " if you don't!");
    }

    public void printMenu() {
        System.out.println("Press:");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To crete a new txt file in this directory.");
        System.out.println("\t 2 - To list all files in the directory.");
        System.out.println("\t 3 - Chose a txt file to add words to it.");
        System.out.println("\t 4 - Chose a txt file to play with and start the game.");
        System.out.println("\t 5 - To quit the application.");
    }
}
