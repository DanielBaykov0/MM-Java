package com.AdvancedLevel.FinalPractice;

import java.io.IOException;

public class HangmanApp {

    public static void main(String[] args) throws IOException {

        HangmanService hangman = new HangmanService();
//        HangmanService.createFile();
        hangman.start();
    }
}