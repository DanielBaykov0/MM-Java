package com.AdvancedLevel.exceptions;

import java.io.*;

public class FileCreationException {

    public static void main(String[] args) {

        createFile("outputFile.txt");
    }

    private static void createFile(String fileName) {
//        PrintWriter outputFile = null;

        try (PrintWriter outputFile = new PrintWriter(new FileWriter(fileName))) {
            outputFile.println("Hello");
        } catch (IOException e) {
            System.err.println("Caught an IOException: " + e.getMessage());
        }

        System.out.println("This line comes after we tried to create a file");
    }
}
