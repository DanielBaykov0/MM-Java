package com.BeginnerLevelFundamentals.loops;

public class Loops {

    public static void main(String[] args) {

        int i = 1;
        while (i <= 0) {
            System.out.println(i + ". Being right sucks");
            i++;
        }

        System.out.println("Value of i: " + i);
        System.out.println();

        int j = 1;
        do {
            System.out.println(j + ". Being right sucks");
            j++;
        } while (j <= 0);

        System.out.println("Value of j: " + j);
        System.out.println();

        for (int k = 1; k <= 5; k++) {
            if (k == 3) {
                break;
            }
            System.out.println(k + ". Being right sucks");
        }
        System.out.println();

        for (int k = 1; k <= 5; k++) {
            for (int l = 1; l <= 2; l++) {
                System.out.println("k = " + k + " l = " + l +" Being right sucks");
            }
        }
    }
}
