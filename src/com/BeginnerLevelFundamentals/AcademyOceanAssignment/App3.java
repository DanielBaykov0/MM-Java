package com.BeginnerLevelFundamentals.AcademyOceanAssignment;

import java.util.Scanner;

public class App3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a number: ");
        int n = scanner.nextInt();

        // nested loops for the first triangle
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            // 1 space for the first row
            System.out.print(" ");

            // 4 spaces between the two triangles
            int l = n;
            while (i < l) {
                System.out.print("    ");
                l--;
            }

            // nested loops for the second triangle
            int k = n;
            for (int j = k + 1 - i; j <= n; j++) {
                System.out.print(j + " ");
                k--;
            }
            // empty line between rows
            System.out.println();
        }
    }
}
