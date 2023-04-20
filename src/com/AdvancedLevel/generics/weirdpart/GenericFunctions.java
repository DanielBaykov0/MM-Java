package com.AdvancedLevel.generics.weirdpart;

import java.util.ArrayList;

public class GenericFunctions {

    public static <T> void displayToString(T typeData) {
        System.out.println(typeData.toString());
    }

    public static void addNumbers(ArrayList<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

    public static void printList(ArrayList<?> list) {
        for (Object element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
