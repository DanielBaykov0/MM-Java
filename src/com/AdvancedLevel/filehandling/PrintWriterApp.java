package com.AdvancedLevel.filehandling;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterApp {

    public static void main(String[] args) {

        try (PrintWriter bookWriter = new PrintWriter(new FileWriter("src/com/AdvancedLevel/filehandling/JuliusCesar.txt", true))) {
            bookWriter.println("Even you, Brutus?");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
