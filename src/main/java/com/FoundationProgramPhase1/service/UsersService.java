package com.FoundationProgramPhase1.service;

import com.FoundationProgramPhase1.core.User;
import com.FoundationProgramPhase1.repositories.UserRepository;
import com.FoundationProgramPhase1.utils.OutputMessages;
import com.FoundationProgramPhase1.utils.UserUtils;

import java.util.List;
import java.util.Scanner;

public class UsersService {

    private List<User> users;
    private final OutputMessages outputMessages = new OutputMessages();
    private final UserUtils userUtils = new UserUtils();

    public UsersService() {
        this.users = UserRepository.getUsers();
    }

    public void addUser(User user) {
        if (user.getGDPR()) {
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

    public User createUser(Scanner scanner) {
        String username = userUtils.returnCorrectUsername(scanner);
        String password = userUtils.returnCorrectPassword(scanner);
        String name = userUtils.returnCorrectName(scanner);
        int userAge = userUtils.returnCorrectUserAge(scanner);
        String userGender = userUtils.returnCorrectUserGender(scanner);
        String userAddress = userUtils.returnCorrectUserAddress(scanner);
        String userCity = userUtils.returnCorrectCity(scanner);
        String userCounty = userUtils.returnCorrectCountry(scanner);
        String userEmail = userUtils.returnCorrectEmail(scanner);
        boolean GDPR = userUtils.returnCorrectGDPR(scanner);
        User user = new User(username, password, name, userAge, userGender, userAddress, userCity, userCounty, userEmail, GDPR);
        outputMessages.printUserCreated(user);
        return user;
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

    public boolean loginAsLibraryUser(User inputUser) {
        for (User user : users) {
            if (user.equals(inputUser) && user.getGDPR()) {
                return true;
            }
        }
        return false;
    }
}
