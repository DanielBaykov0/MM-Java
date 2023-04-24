package com.AdvancedLevel.filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerApp {

    public static void main(String[] args) {

        String HAMLET_PATH_FILE_PATH = "src\\com\\AdvancedLevel\\filehandling\\Hamlet.txt";

        try (Scanner scanner = new Scanner(new File(HAMLET_PATH_FILE_PATH))) {
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
