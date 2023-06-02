package com.FoundationProgramPhase1.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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

    /**
     * Method under test: {@link UserUtils#returnCorrectName(Scanner)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testReturnCorrectName2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.OutOfMemoryError: Java heap space
        //       at java.util.Arrays.copyOf(Arrays.java:3481)
        //       at java.util.ArrayList.grow(ArrayList.java:237)
        //       at java.util.ArrayList.grow(ArrayList.java:244)
        //       at java.util.ArrayList.add(ArrayList.java:454)
        //       at java.util.ArrayList.add(ArrayList.java:467)
        //       at com.FoundationProgramPhase1.utils.OutputMessages.enterName(OutputMessages.java:9)
        //       at com.FoundationProgramPhase1.utils.UserUtils.returnCorrectName(UserUtils.java:15)
        //   See https://diff.blue/R013 to resolve this issue.

        Scanner scanner = new Scanner("Please enter your full name: ");
        (new UserUtils()).returnCorrectName(scanner);
    }

    @Test
    void testReturnCorrectPostponeDays() {
        Scanner scanner = new Scanner(String.valueOf(12));
        Assertions.assertEquals(12, userUtils.returnCorrectPostponeDays(scanner));
    }

    /**
     * Method under test: {@link UserUtils#returnCorrectPostponeDays(Scanner)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testReturnCorrectPostponeDays2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        UserUtils userUtils = null;
        Scanner scanner = null;

        // Act
        int actualReturnCorrectPostponeDaysResult = userUtils.returnCorrectPostponeDays(scanner);

        // Assert
        // TODO: Add assertions on result
    }
}

