package com.BeginnerLevelFundamentals.AcademyOceanAssignment;

import java.util.Scanner;

public class App2 {

    public static void main(String[] args) {

        int number1 = 0;
        int number2 = 1;
        int number3;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter how many numbers to display: ");
        int numbers = scanner.nextInt();

        System.out.print(number1 + " " + number2);
        for (int i = 2; i < numbers; i++) {
            number3 = number1 + number2;
            System.out.print(" " + number3);
            number1 = number2;
            number2 = number3;
        }
    }
}
