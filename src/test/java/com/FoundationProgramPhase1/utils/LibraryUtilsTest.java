package com.FoundationProgramPhase1.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class LibraryUtilsTest {

    LibraryUtils libraryUtils;

    @BeforeEach
    void setLibraryUtils() {
        libraryUtils = new LibraryUtils();
    }

    @Test
    void testReturnCorrectBookTitle() {
        Scanner scanner = new Scanner("My man");
        Assertions.assertEquals("My man", libraryUtils.returnCorrectBookTitle(scanner));
    }

    @Test
    void testReturnCorrectBookGenre() {
        Scanner scanner = new Scanner("Fantasy");
        Assertions.assertEquals("Fantasy", libraryUtils.returnCorrectBookGenre(scanner));
    }

    @Test
    void testReturnCorrectBookDescription() {
        Scanner scanner = new Scanner("Amazing book");
        Assertions.assertEquals("Amazing book", libraryUtils.returnCorrectBookDescription(scanner));
    }

    @Test
    void testReturnCorrectAuthorFirstName() {
        Scanner scanner = new Scanner("Daniel");
        Assertions.assertEquals("Daniel", libraryUtils.returnCorrectAuthorFirstName(scanner));
    }

    @Test
    void testReturnCorrectAuthorLastName() {
        Scanner scanner = new Scanner("Georgiev");
        Assertions.assertEquals("Georgiev", libraryUtils.returnCorrectAuthorLastName(scanner));
    }
}

