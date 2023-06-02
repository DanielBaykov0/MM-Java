package com.FoundationProgramPhase1.service;

import com.FoundationProgramPhase1.core.User;
import com.FoundationProgramPhase1.utils.OutputMessages;

import java.util.List;
import java.util.Scanner;

public class UsersService {

    private final OutputMessages outputMessages = new OutputMessages();

    public UsersService() {
    }

    public void listAllUsers(List<User> users) {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public User returnCorrectUser(Scanner scanner, List<User> users) {
        String name = "";
        User returnUser = null;
        do {
            outputMessages.enterName();
            try {
                name = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (!name.matches("[a-zA-Z\\s]*$"));

        for (User user : users) {
            if (user.getName().equals(name)) {
                returnUser = user;
            }
        }

        return returnUser;
    }

    public boolean loginAsLibraryUser(User inputUser, List<User> users) {
        for (User user : users) {
            if (user.equals(inputUser) && user.getGDPR()) {
                return true;
            }
        }
        return false;
    }
}
