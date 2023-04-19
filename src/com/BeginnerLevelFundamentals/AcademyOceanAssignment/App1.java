package com.BeginnerLevelFundamentals.AcademyOceanAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class App1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int q = scanner.nextInt();

        System.out.println(Arrays.toString(getArray(p ,q)));
    }

    public static int[] getArray(int p, int q) {
        if (p <= q) {
            return new int[] {p, q};
        } else {
            return new int[] {q, p};
        }
    }
}