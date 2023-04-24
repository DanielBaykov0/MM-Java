package com.BeginnerLevelFundamentals.AcademyOceanAssignment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = 0;
        boolean valid = false;

        while (!valid) {
            System.out.println("Choose a number from 1 to 9: ");
            try {
                n = scanner.nextInt();
                if (n >= 1 && n <= 10) {
                    valid = true;
                } else {
                    System.out.println("Number out of range");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number from 1 to 9");
                scanner.nextLine();
            }
        }

        printTriangles(n);
    }

    private static void printTriangles(int n) {
        // nested loops for the first triangle
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            // spaces between the two triangles
            int l = n;
            while (i < l) {
                System.out.print("    ");
                l--;
            }

            // nested loops for the second triangle
            int k = n;
            for (int j = k + 1 - i; j <= n; j++) {
                System.out.print(" " + j);
                k--;
            }

            // empty line between rows
            System.out.println();
        }
    }
}
