package com.BeginnerLevelFundamentals.AcademyOceanAssignment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App2 {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter how many numbers to display: ");

        try {
            int numbers = scanner.nextInt();
            fibonacciSeries(numbers);
        } catch (InputMismatchException e) {
            System.out.println("You didn't enter a number");
        }
    }

    // Bogdan suggested to put my code in a separate method, have a validation for 0 entered numbers
    // and catch an exception for String input

    public static void fibonacciSeries(int numbers) {

        int number1 = 0;
        int number2 = 1;
        int number3;


        if (numbers == 0) {
            System.out.println("Please enter a higher number");
        } else {
            System.out.print(number1 + " " + number2);
            for (int i = 2; i < numbers; i++) {
                number3 = number1 + number2;
                System.out.print(" " + number3);
                number1 = number2;
                number2 = number3;
            }
        }
    }
}
