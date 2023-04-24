package com.AdvancedLevel.filehandling;

import java.io.File;
import java.io.IOException;

public class FileHandlingApp {

    public static void main(String[] args) {

        File famousQuotesFile = new File("src/com\\AdvancedLevel\\filehandling\\famousQuotes.txt");

        try {
            if (famousQuotesFile.createNewFile()) {
                System.out.println("The file is created");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
