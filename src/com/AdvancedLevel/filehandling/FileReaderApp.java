package com.AdvancedLevel.filehandling;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderApp {

    public static void main(String[] args) {

        String HAMLET_PATH_FILE_PATH = "src\\com\\AdvancedLevel\\filehandling\\Hamlet.txt";

        char[] firstHundredCharacters = new char[100];

        try (FileReader hamletReader = new FileReader(HAMLET_PATH_FILE_PATH)) {
            hamletReader.read(firstHundredCharacters);
            System.out.println(firstHundredCharacters);
            System.out.println("Read more");
            hamletReader.read(firstHundredCharacters);
            System.out.println(firstHundredCharacters);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
