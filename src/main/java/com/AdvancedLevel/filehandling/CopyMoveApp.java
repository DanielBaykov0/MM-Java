package com.AdvancedLevel.filehandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyMoveApp {

    public static void main(String[] args) {

        Path originalPath = Paths.get("src/com/AdvancedLevel/filehandling/JuliusCesar.txt");
        Path destinationPath = Paths.get("src/com/AdvancedLevel/exceptions/JuliusCesar.txt");

        try {
            if (Files.exists(originalPath)) {
                Files.move(originalPath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
