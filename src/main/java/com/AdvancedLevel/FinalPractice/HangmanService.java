package com.AdvancedLevel.FinalPractice;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String FINAL_PRACTICE_DIRECTORY_PATH = "src/com/AdvancedLevel/FinalPractice/";

    public static void startGame() {
        userChoiceInput();
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

    private static void createNewFile() {
        System.out.println("Please specify txt file name: ");
        String fileName = SCANNER.nextLine();
        isFileCreated(fileName);
    }

    private static void writeWordsToFile() {
        System.out.println("Choose a txt file from this directory: ");
        String file = SCANNER.nextLine();
        File fileName = new File(FINAL_PRACTICE_DIRECTORY_PATH + file);
        isCorrectFileName(file, fileName);
    }

    private static void start() {
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
                char letter = SCANNER.nextLine().toLowerCase().charAt(0);

                boolean isRightGuess = false;
                for (int i = 0; i < randomWordArray.length; i++) {
                    if (letter == randomWordArray[i]) {
                        guessingArray[i] = letter;
                        // if you enter the same letter over and over again, numberOfCounts--
                        randomWordArray[i] = ' ';
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

    private static String getRandomWord() throws FileNotFoundException {
        List<String> words = getWords();
        Random randomNumberGenerator = new Random();

        int index = randomNumberGenerator.nextInt(words.size());
        return words.get(index);
    }

    private static List<String> getWords() throws FileNotFoundException {
        List<String> words = new ArrayList<>();

        File wordsFile = new File(FINAL_PRACTICE_DIRECTORY_PATH + chooseFile());

        Scanner scanner = new Scanner(wordsFile);
        while (scanner.hasNextLine()) {
            words.add(scanner.nextLine());
        }

        return words;
    }

    private static void listAllFiles() {
        Set<String> fileSet = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("src/com/AdvancedLevel/FinalPractice/"))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    fileSet.add(path.getFileName().toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String file : fileSet) {
            System.out.println("- " + file);
        }
    }

    private static String chooseFile() {
        System.out.println("Please enter a file name: ");
        return SCANNER.nextLine();
    }

    private static void userChoiceInput() {
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
                case 1 -> createNewFile();
                case 2 -> listAllFiles();
                case 3 -> writeWordsToFile();
                case 4 -> start();
                case 5 -> quit = true;
            }
        }
    }

    private static boolean isGameFinished(char[] guessingArray) {
        for (char charFromArray : guessingArray) {
            if (charFromArray == '_') {
                return false;
            }
        }

        return true;
    }

    private static void isFileCreated(String fileName) {
        File wordsFile = new File(FINAL_PRACTICE_DIRECTORY_PATH + fileName);
        try {
            if (wordsFile.createNewFile()) {
                System.out.println("File created: " + wordsFile.getName());
            } else {
                System.out.println("Can't create the file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void isCorrectFileName(String file, File fileName) {
        if (fileName.exists()) {
            System.out.println("Correct file name");
            System.out.println("Please enter a word to write it to the txt file: ");
            String word = SCANNER.nextLine();

            try (PrintWriter printWriter = new PrintWriter(new FileWriter(FINAL_PRACTICE_DIRECTORY_PATH + file, true))) {
                printWriter.println(word);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Wrong file name");
        }

    }
}
