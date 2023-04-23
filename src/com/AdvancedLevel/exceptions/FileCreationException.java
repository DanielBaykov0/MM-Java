package com.AdvancedLevel.exceptions;

import java.io.*;

public class FileCreationException {

    public static void main(String[] args) {

        createFile("outputFile.txt");
    }

    private static void createFile(String fileName) {
        PrintWriter outputFile = null;

        try {
            outputFile = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {
            System.err.println("Caught an IOException: " + e.getMessage());
        } finally {
            if (outputFile != null) {
                outputFile.close();
                System.out.println("The printWriter is closed");
            } else {
                System.out.println("The printWriter is not open");
            }
        }

        System.out.println("This line comes after we tried to create a file");
    }
}
