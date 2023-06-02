package com.FoundationProgramPhase1.utils;

import java.util.Scanner;

public class UserUtils {

    private final OutputMessages outputMessages = new OutputMessages();

    public UserUtils() {
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

    public int returnCorrectPostponeDays(Scanner scanner) {
        String delayDays = "";
        do {
            outputMessages.enterPostponeDays();
            try {
                delayDays = scanner.next();
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (!delayDays.matches("[0-9]+") || (Integer.parseInt(delayDays) < 1 || Integer.parseInt(delayDays) > 15));

        return Integer.parseInt(delayDays);
    }
}
