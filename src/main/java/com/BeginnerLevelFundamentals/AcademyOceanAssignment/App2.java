package com.BeginnerLevelFundamentals.AcademyOceanAssignment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App2 {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int numbers = 0;
        boolean valid = false;

        while (!valid) {
            System.out.println("Enter a number from 1 to 20 to display fibonacci series:");
            try {
                numbers = scanner.nextInt();
                if (numbers >= 1 && numbers <= 20) {
                    valid = true;
                } else {
                    System.out.println("Number out of scope");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number from 1 to 20");
                scanner.nextLine();
            }
        }

        fibonacciSeries(numbers);
    }

    // Bogdan suggested to put my code in a separate method, have a validation for 0 entered numbers
    // and catch an exception for String input

    public static void fibonacciSeries(int numbers) {

        int number1 = 0;
        int number2 = 1;
        int number3;

        System.out.print(number1 + " " + number2);
        for (int i = 2; i < numbers; i++) {
            number3 = number1 + number2;
            System.out.print(" " + number3);
            number1 = number2;
            number2 = number3;
        }
    }
}
