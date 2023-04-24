package com.AdvancedLevel.FinalPractice;

import java.io.*;
import java.util.*;

public class HangmanService {

    //    public static List<String> FILES_PATHS = new ArrayList<>();
    private static final String WORDS_FILE_PATH = "src/com/AdvancedLevel/FinalPractice/words.txt";

    public void start() throws FileNotFoundException {
        String randomWord = getRandomWord();
        char[] randomWordArray = randomWord.toCharArray();
        char[] guessingArray = new char[randomWord.length()];
        Arrays.fill(guessingArray, '_');
        int numberOfChances = randomWord.length();

        System.out.println("Starting the game...");
        System.out.println("The word you got has " + numberOfChances + " letters");
        System.out.println("You have " + numberOfChances + " chances to guess it");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------------------------------");
            System.out.print("Please enter a letter:");
            char letter = scanner.nextLine().toLowerCase().charAt(0);

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
                    break;
                }
            } else {
                numberOfChances--;
                if (numberOfChances == 0) {
                    System.out.println("You don't have more guesses. You lost!");
                    System.out.println("The word was " + randomWord);
                    break;
                }
                System.out.println("You guessed wrong. You have " + numberOfChances + " guesses left");
                System.out.println("Try again!");
            }

            System.out.println("The word: " + new String(guessingArray));
        }
    }

    private boolean isGameFinished(char[] guessingArray) {
        for (char charFromArray : guessingArray) {
            if (charFromArray == '_') {
                return false;
            }
        }

        System.out.println("The word is " + new String(guessingArray));
        System.out.println("Congratulations! You won!");
        return true;
    }

    private String getRandomWord() throws FileNotFoundException {
        List<String> words = getWords();
        Random randomNumberGenerator = new Random();

        int index = randomNumberGenerator.nextInt(words.size());
        return words.get(index);
    }

    private List<String> getWords() throws FileNotFoundException {
        List<String> words = new ArrayList<>();

        File wordsFile = new File(WORDS_FILE_PATH);

        Scanner scanner = new Scanner(wordsFile);
        while (scanner.hasNextLine()) {
            words.add(scanner.nextLine());
        }

        return words;
    }
//
//    public static void createFile() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Do you want to create a new file?");
//        String decision = scanner.nextLine();
//
//        File wordsFile;
//        if (decision.equalsIgnoreCase("yes")) {
//            System.out.println("Please specify the file path: ");
//            String filePath = scanner.nextLine();
//            wordsFile = new File(filePath);
//            try {
//                if (wordsFile.createNewFile()) {
//                    System.out.println("File created: " + wordsFile.getName());
//                    writeWordsToFile();
//                } else {
//                    System.out.println("Can't create the file");
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else if (decision.equalsIgnoreCase("no")) {
//            writeWordsToFile();
//        }
//    }
//
//    private static void writeWordsToFile() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Choose a file from this directory: ");
//        String file = scanner.nextLine();
//
//        System.out.println("Please enter a word to write it to the file: ");
//        String word = scanner.nextLine();
//
//        try (PrintWriter printWriter = new PrintWriter(new FileWriter("src/com/AdvancedLevel/FinalPractice/" + file, true))) {
//            printWriter.println(word);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
