package com.AdvancedLevel.generics.weirdpart;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericWeirdPartApp {

    public static void main(String[] args) {

        ArrayList<Integer> lotteryNumbers = new ArrayList<>(Arrays.asList(23, 45, 57, 82, 14));
        GenericFunctions.addNumbers(lotteryNumbers);
        GenericFunctions.printList(lotteryNumbers);
        GenericFunctions.displayToString(lotteryNumbers);
    }
}
