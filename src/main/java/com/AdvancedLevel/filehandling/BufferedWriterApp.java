package com.AdvancedLevel.filehandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterApp {

    public static void main(String[] args) {

        try (BufferedWriter bufferedBookWriter = new BufferedWriter(new FileWriter("src/com/AdvancedLevel/filehandling/JuliusCesar.txt", true))) {
            bufferedBookWriter.write("Even you, Brutus?");
            bufferedBookWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
