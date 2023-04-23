package com.BeginnerLevelFundamentals.AcademyOceanAssignment;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter a value for P:");
            int p = scanner.nextInt();
            System.out.println("Enter a value for Q:");
            int q = scanner.nextInt();

            System.out.println(Arrays.toString(getArray(p ,q)));
        } catch (InputMismatchException e) {
            System.out.println("You didn't enter a number");
        }
    }

    public static int[] getArray(int p, int q) {
        if (p <= q) {
            return new int[] {p, q};
        } else {
            return new int[] {q, p};
        }
    }
}
