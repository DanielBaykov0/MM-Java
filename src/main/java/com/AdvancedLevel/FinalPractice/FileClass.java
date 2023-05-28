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
import java.util.regex.Pattern;

public class FileClass {

    private final Set<String> fileSet;

    public FileClass() {
        this.fileSet = new HashSet<>();
    }

    public void listAllFiles(Set<String> fileSet) {
        addFilesToDirectory();

        for (String file : fileSet) {
            System.out.println("- " + file);
        }
    }

    public String chooseFile(Scanner scanner) {
        System.out.println("Please enter a file name: ");
        return scanner.nextLine();
    }


    private Set<String> addFilesToDirectory() {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(getFINAL_PRACTICE_DIRECTORY_PATH()))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    fileSet.add(path.getFileName().toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileSet;
    }

    public void createNewFile(File wordsFile) {
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

    private String enterFileName(Scanner scanner) {
        System.out.println("Please specify txt file name: ");
        return scanner.nextLine();
    }

    public void writeWordsToFile(Scanner scanner) {
        System.out.println("Choose a txt file from this directory: ");
        String file = scanner.nextLine();
        File fileName = new File(getFINAL_PRACTICE_DIRECTORY_PATH() + file);
        isCorrectFileName(new Scanner(System.in), file, fileName);
    }

    private void isCorrectFileName(Scanner scanner, String file, File fileName) {
        if (fileName.exists()) {
            System.out.println("Correct file name");
            String word = "";
            String digitsRegex = "\\d*.\\d*";
            Pattern pattern = Pattern.compile(digitsRegex);

            while (true) {
                System.out.println("Please enter a word to write it to the txt file: ");
                word = scanner.nextLine();
                if (!pattern.matcher(word).matches()) {
                    System.out.println("word added: " + word);
                    break;
                } else {
                    System.out.println("Please use only letters!");
                }
            }

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

    public Set<String> getFileSet() {
        return addFilesToDirectory();
    }

    public File getWordsFile() {
        return new File(getFINAL_PRACTICE_DIRECTORY_PATH() + enterFileName(new Scanner(System.in)));
    }
}
