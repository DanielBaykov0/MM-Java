package com.FoundationProgramPhase1.utils;

import java.util.Scanner;

public class UserUtils {

    private final OutputMessages outputMessages = new OutputMessages();

    public UserUtils() {
    }

    public String returnCorrectUsername(Scanner scanner) {
        String username = "";
        do {
            outputMessages.enterUsername();
            try {
                username = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (!username.matches("[a-zA-Z_]+"));

        return username;
    }

    public String returnCorrectPassword(Scanner scanner) {
        String password = "";
        //Geeks@portal20
        do {
            outputMessages.enterPassword();
            try {
                password = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$"));

        return password;
    }

    public String returnCorrectName(Scanner scanner) {
        String name = "";
        do {
            outputMessages.enterName();
            try {
                name = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (!name.matches("[a-zA-Z\\s]*$"));

        return name;
    }

    public int returnCorrectUserAge(Scanner scanner) {
        String userAgeInput = "";
        do {
            outputMessages.enterUserAge();
            try {
                userAgeInput = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (!userAgeInput.matches("[0-9]+"));

        return Integer.parseInt(userAgeInput);
    }

    public String returnCorrectUserGender(Scanner scanner) {
        String userGender = "";
        do {
            outputMessages.enterUserGender();
            try {
                userGender = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (!"male".equalsIgnoreCase(userGender) && !"female".equalsIgnoreCase(userGender));

        return userGender;
    }

    public String returnCorrectUserAddress(Scanner scanner) {
        String userAddress = "";
        do {
            outputMessages.enterUserAddress();
            try {
                userAddress = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (!userAddress.matches("\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)"));

        return userAddress;
    }

    public String returnCorrectCity(Scanner scanner) {
        String userCity = "";
        do {
            outputMessages.enterUserCity();
            try {
                userCity = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (!userCity.matches("[a-zA-Z_]+"));

        return userCity;
    }

    public String returnCorrectCountry(Scanner scanner) {
        String userCounty = "";
        do {
            outputMessages.enterUserCountry();
            try {
                userCounty = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (!userCounty.matches("[a-zA-Z_]+"));

        return userCounty;
    }

    public String returnCorrectEmail(Scanner scanner) {
        String userEmail = "";
        do {
            outputMessages.enterUserEmail();
            try {
                userEmail = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (!userEmail.matches("^(.+)@(\\S+)$"));

        return userEmail;
    }

    public boolean returnCorrectGDPR(Scanner scanner) {
        outputMessages.askGDPR();
        String GDPR = scanner.nextLine();
        if (!"yes".equalsIgnoreCase(GDPR)) {
            System.out.println("Thank you");
            return false;
        }

        return true;
    }

    public int returnCorrectPostponeDays(Scanner scanner) {
        String delayDays = "";
        do {
            outputMessages.enterPostponeDays();
            try {
                delayDays = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (!delayDays.matches("[0-9]+") && (Integer.parseInt(delayDays) < 1 && Integer.parseInt(delayDays) > 14));

        return Integer.parseInt(delayDays);
    }
}
