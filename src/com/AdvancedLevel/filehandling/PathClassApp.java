package com.AdvancedLevel.filehandling;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathClassApp {

    public static void main(String[] args) {

        Path path = Paths.get("src/com/AdvancedLevel/filehandling/JuliusCesar.txt").toAbsolutePath();

        System.out.println("toString: " + path.toString());
        System.out.println("getFileName: " + path.getFileName());
        System.out.println("getName: " + path.getName(0));
        System.out.println("getNameCount: " + path.getNameCount());
        System.out.println("subpath(0,2): " + path.subpath(0, 2));
        System.out.println("getParent: " + path.getParent());
        System.out.println("getRoot: " + path.getRoot());
    }
}
