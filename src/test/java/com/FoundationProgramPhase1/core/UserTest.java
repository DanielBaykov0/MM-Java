package com.FoundationProgramPhase1.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserConstructor() {

        String username = "";
        String password = "";
        String name = "";
        int userAge = 0;
        String userGender = "";
        String userAddress = "";
        String userCity = "";
        String userCounty = "";
        String userEmail = "";
        boolean GDPR = false;

        // Act
        User actualUser = new User(username, password, name, userAge, userGender, userAddress, userCity, userCounty,
                userEmail, GDPR);
        assertEquals(username, actualUser.getUsername());
        assertEquals(password, actualUser.getPassword());
        assertEquals(name, actualUser.getName());
        assertEquals(userAge, actualUser.getUserAge());
        assertEquals(userGender, actualUser.getUserGender());
        assertEquals(userAddress, actualUser.getUserAddress());
        assertEquals(userCity, actualUser.getUserCity());
        assertEquals(userCounty, actualUser.getUserCounty());
        assertEquals(userEmail, actualUser.getUserEmail());
        assertEquals(GDPR, actualUser.getGDPR());
    }

    @Test
    void testUserEquals() {
        User user1 = new User("janedoe", "iloveyou", "Name", 1, "User Gender", "42 Main St", "User City", "Country",
                "jane.doe@example.org", true);
        User user2 = new User("janedoe", "iloveyou", "Name", 1, "User Gender", "42 Main St", "User City", "Country",
                "jane.doe@example.org", true);
        assertNotEquals(user1, null);
        assertEquals(user1, user2);
    }

    @Test
    void testUserNotEquals() {
        User user1 = new User("janedoe", "iloveyou", "Name", 1, "User Gender", "42 Main St", "User City", "Country",
                "jane.doe@example.org", true);
        User user2 = new User("janedoe", "iloveyou", "Name", 1, "User Gender", "42 Main St", "User City", "Country",
                "jane.doe@example.org", false);
        assertNotEquals(user1, user2);
    }

    @Test
    void testUserHashcode() {
        User user1 = new User("janedoe", "iloveyou", "Name", 1, "User Gender", "42 Main St", "User City", "Country",
                "jane.doe@example.org", true);
        User user2 = new User("janedoe", "iloveyou", "Name", 1, "User Gender", "42 Main St", "User City", "Country",
                "jane.doe@example.org", true);
        assertTrue(user1.equals(user2) && user2.equals(user1));
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    void testUserToString() {
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", false);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.out.println(user);
        String expectedOutput = "User{username='ivanivan', password='longOne', name='Ivan Georgiev', userAge=54, userGender='male', userAddress='123 Washington', userCity='Munich', userCounty='Germany', userEmail='ivan@abv.bg', GDPR=false,\n" +
                " paperBookList=[],\n" +
                " eBookReadList=[],\n" +
                " eBookDownloadedList=[]}\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }
}

