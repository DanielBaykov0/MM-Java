package com.FoundationProgramPhase1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageUsers {

    private List<User> users;
    private OutputMessages outputMessages = new OutputMessages();

    public ManageUsers() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        if (user.isGDPR()) {
            users.add(user);
            System.out.println("User successfully added! Welcome: " + user.getName());
        } else {
            System.out.println("You didn't agree to our privacy policy.");
        }
    }

    public void removeUser(String str) {
        for (User user : users) {
            if (user.getName().equals(str)) {
                users.remove(user);
                System.out.println("User " + user.getName() + " successfully removed!");
            }
        }

        System.out.println("Could not remove the user.");
    }

    public void listAllUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    private boolean isUserCreated(User user) {
        if (!user.isGDPR()) {
            System.out.println("User was not created.");
            System.out.println("You didn't agree to our privacy policy.");
            return false;
        }

        System.out.println("New User successfully created:");
        System.out.println(user);
        return true;
    }

    public User createUser(Scanner scanner) {
        String username = "";
        String password = "";
        String name = "";
        int userAge = 0;
        String userGender = "";
        String userAddress = "";
        String userCity = "";
        String userCounty = "";
        String userEmail = "";
        boolean GDPR;

        while (true) {
            outputMessages.enterUsername();
            username = scanner.nextLine();
            if (!username.matches("[a-zA-Z_]+")) {
                System.out.println("Invalid input");
            }
            outputMessages.enterPassword();
            password = scanner.nextLine();
            outputMessages.enterName();
            name = scanner.nextLine();
            outputMessages.enterUserAge();
            String userAgeInput = scanner.nextLine();
            if (!userAgeInput.matches("[0-9]+")) {
                System.out.println("Invalid number");
            } else {
                userAge = Integer.parseInt(userAgeInput);
            }
            outputMessages.enterUserGender();
            userGender = scanner.nextLine();
            outputMessages.enterUserAddress();
            userAddress = scanner.nextLine();
            outputMessages.enterUserCity();
            userCity = scanner.nextLine();
            outputMessages.enterUserCountry();
            userCounty = scanner.nextLine();
            outputMessages.enterUserEmail();
            userEmail = scanner.nextLine();
            outputMessages.askGDPR();
            String askGDPR = scanner.nextLine();
            GDPR = "yes".equalsIgnoreCase(askGDPR);
            break;
        }
        User user = new User(username, password, name, userAge, userGender, userAddress, userCity, userCounty, userEmail, GDPR);
        isUserCreated(user);
        return user;
    }
}
