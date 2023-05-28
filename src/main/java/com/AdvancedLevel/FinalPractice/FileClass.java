package com.AdvancedLevel.FinalPractice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FileClass {

    private final Scanner SCANNER;

    public FileClass(Scanner scanner) {
        this.SCANNER = scanner;
    }

    public void listAllFiles() {
        Set<String> fileSet = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(getFINAL_PRACTICE_DIRECTORY_PATH()))) {
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

    public String chooseFile() {
        System.out.println("Please enter a file name: ");
        return SCANNER.nextLine();
    }

    public void createNewFile() {
        System.out.println("Please specify txt file name: ");
        String fileName = SCANNER.nextLine();
        isFileCreated(fileName);
    }

    public void writeWordsToFile() {
        System.out.println("Choose a txt file from this directory: ");
        String file = SCANNER.nextLine();
        File fileName = new File(getFINAL_PRACTICE_DIRECTORY_PATH() + file);
        isCorrectFileName(file, fileName);
    }

    private void isFileCreated(String fileName) {
        File wordsFile = new File(getFINAL_PRACTICE_DIRECTORY_PATH() + fileName);
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

    private void isCorrectFileName(String file, File fileName) {
        if (fileName.exists()) {
            System.out.println("Correct file name");
            System.out.println("Please enter a word to write it to the txt file: ");
            String word = SCANNER.nextLine();

            try (PrintWriter printWriter = new PrintWriter(new FileWriter(getFINAL_PRACTICE_DIRECTORY_PATH() + file, true))) {
                printWriter.println(word);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Wrong file name");
        }
    }

    public String getFINAL_PRACTICE_DIRECTORY_PATH() {
        return "src/main/java/com/AdvancedLevel/FinalPractice/";
    }
}
