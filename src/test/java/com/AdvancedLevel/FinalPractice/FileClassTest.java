package com.AdvancedLevel.FinalPractice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FileClassTest {

    FileClass fileClass;
    ByteArrayOutputStream outContent;

    @BeforeEach
    void setFileClass() {
        fileClass = new FileClass();
        outContent = new ByteArrayOutputStream();
    }

    @Test
    void testConstructor() {

    }

    @Test
    void testListAllFiles() {
        Set<String> fileSet = new HashSet<>(Set.of("first", "second"));

        System.setOut(new PrintStream(outContent));
        fileClass.listAllFiles(fileSet);
        String expectedOutput = "- first\r\n- second\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testChooseFile() {
        String input = "test.txt";
        Scanner scanner = new Scanner(input);
        System.setOut(new PrintStream(outContent));
        fileClass.chooseFile(scanner);
        String expectedOutput = "Please enter a file name: \r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testCreateNewFile_cantCreateTheFile() {
        FileClass fileClassMock = mock(FileClass.class);
        when(fileClassMock.getWordsFile()).thenReturn(new File("src/main/java/com/AdvancedLevel/FinalPractice/test"));
        System.setOut(new PrintStream(outContent));
        fileClass.createNewFile(fileClassMock.getWordsFile());
        String expectedOutput = "Can't create the file\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testCreateNewFile_createTheFile() {
        FileClass fileClassMock = mock(FileClass.class);
        File file = new File("src/main/java/com/AdvancedLevel/FinalPractice/delete");
        when(fileClassMock.getWordsFile()).thenReturn(file);
        System.setOut(new PrintStream(outContent));
        fileClass.createNewFile(fileClassMock.getWordsFile());
        String expectedOutput = "File created: delete\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
        file.deleteOnExit();
    }

    @Test
    void testWriteWordsToFile() {

    }
}

