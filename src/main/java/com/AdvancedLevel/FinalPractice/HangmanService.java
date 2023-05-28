package com.AdvancedLevel.FinalPractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
        after winning or losing the game print the menu -> done
        add constant for the base path of the file -> done
        list all available txt files -> done
        put code blocks in smaller functions -> done
        use String.contains()
        move the exceptions to the lowest part of the pack -> done
        if you input the same letter over and over again that is in the word -> StringIndexOutOfBoundsException -> done
 */

public class HangmanService {

    private final Scanner SCANNER;
    private final FileClass fileClass;

    public HangmanService(Scanner scanner, FileClass fileClass) {
        this.SCANNER = scanner;
        this.fileClass = fileClass;
    }

    public void startGame() {
        boolean quit = false;
        int choice = 0;

        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice:");
            try {
                choice = 0;
                choice = SCANNER.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input");
            }
            SCANNER.nextLine();

            switch (choice) {
                case 0 -> printInstructions();
                case 1 -> fileClass.createNewFile();
                case 2 -> fileClass.listAllFiles();
                case 3 -> fileClass.writeWordsToFile();
                case 4 -> start();
                case 5 -> quit = true;
            }
        }
    }

    private void start() {
        String randomWord = null;
        try {
            randomWord = getRandomWord();
        } catch (FileNotFoundException e) {
            System.out.println("Wrong input");
            printInstructions();
        }

        if (randomWord != null) {
            char[] randomWordArray = randomWord.toCharArray();
            char[] guessingArray = new char[randomWord.length()];
            int numberOfChances = randomWord.length();

            Arrays.fill(guessingArray, '_');

            System.out.println("Starting the game...");
            System.out.println("The word you got has " + numberOfChances + " letters");
            System.out.println("You have " + numberOfChances + " chances to guess it");

            while (true) {
                System.out.println("------------------------------------");
                System.out.print("Please enter a letter:");
                char letter = ' ';
                try {
                    letter = SCANNER.nextLine().toLowerCase().charAt(0);
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }

                boolean isRightGuess = false;
                for (int i = 0; i < randomWordArray.length; i++) {
                    if (letter == randomWordArray[i]) {
                        guessingArray[i] = letter;
                        isRightGuess = true;
                    }
                }

                if (isRightGuess) {
                    System.out.println("You guessed right");
                    if (isGameFinished(guessingArray)) {
                        System.out.println("The word is " + new String(guessingArray));
                        System.out.println("Congratulations! You won!");
                        printInstructions();
                        break;
                    }
                } else {
                    numberOfChances--;
                    if (numberOfChances == 0) {
                        System.out.println("You don't have more guesses. You lost!");
                        System.out.println("The word was " + randomWord);
                        printInstructions();
                        break;
                    }
                    System.out.println("You guessed wrong. You have " + numberOfChances + " guesses left");
                    System.out.println("Try again!");
                }

                System.out.println("The word: " + new String(guessingArray));
            }
        }
    }

    private String getRandomWord() throws FileNotFoundException {
        List<String> words = getWords();
        Random randomNumberGenerator = new Random();

        int index = randomNumberGenerator.nextInt(words.size());
        return words.get(index);
    }

    private List<String> getWords() throws FileNotFoundException {
        List<String> words = new ArrayList<>();

        File wordsFile = new File(fileClass.getFINAL_PRACTICE_DIRECTORY_PATH() + fileClass.chooseFile());

        Scanner scanner = new Scanner(wordsFile);
        while (scanner.hasNextLine()) {
            words.add(scanner.nextLine());
        }

        return words;
    }

    private boolean isGameFinished(char[] guessingArray) {
        for (char charFromArray : guessingArray) {
            if (charFromArray == '_') {
                return false;
            }
        }

        return true;
    }

    private static void printInstructions() {
        System.out.println("Press:");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To crete a new txt file in this directory.");
        System.out.println("\t 2 - To list all files in the directory.");
        System.out.println("\t 3 - Chose a txt file to add words to it.");
        System.out.println("\t 4 - Chose a txt file to play with and start the game.");
        System.out.println("\t 5 - To quit the application.");
    }
}
