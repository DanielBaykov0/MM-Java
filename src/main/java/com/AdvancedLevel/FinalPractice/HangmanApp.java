package com.AdvancedLevel.FinalPractice;

import java.io.IOException;
import java.util.Scanner;

public class HangmanApp {

    public static void main(String[] args) throws IOException {

        HangmanService hangmanService = new HangmanService(new Scanner(System.in), new FileClass());
        hangmanService.startGame();
    }
}
