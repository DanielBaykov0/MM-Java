package com.FoundationProgramPhase1.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class UserUtilsTest {

    UserUtils userUtils;
    @BeforeEach
    void setUserUtils() {
        userUtils = new UserUtils();
    }

    @Test
    void testReturnCorrectName() {
        Scanner scanner = new Scanner("My man");
        Assertions.assertEquals("My man", userUtils.returnCorrectName(scanner));
    }

    @Test
    void testReturnCorrectPostponeDays() {
        Scanner scanner = new Scanner(String.valueOf(12));
        Assertions.assertEquals(12, userUtils.returnCorrectPostponeDays(scanner));
    }
}

