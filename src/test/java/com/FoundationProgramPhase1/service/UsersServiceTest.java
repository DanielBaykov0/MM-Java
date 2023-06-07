package com.FoundationProgramPhase1.service;

import com.FoundationProgramPhase1.core.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

class UsersServiceTest {

    UsersService usersService;

    @BeforeEach
    void setUsersService() {
        usersService = new UsersService();
    }

    @Test
    void testListAllUsers() {
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", false);
        List<User> userList = List.of(user);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        usersService.listAllUsers(userList);
        String expectedOutput = "User{username='ivanivan', password='longOne', name='Ivan Georgiev', userAge=54, userGender='male', userAddress='123 Washington', userCity='Munich', userCounty='Germany', userEmail='ivan@abv.bg', GDPR=false,\n" +
                " paperBookList={},\n" +
                " eBookReadList=[],\n" +
                " eBookDownloadedList=[]}\r\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testReturnCorrectUSer() {
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", false);
        List<User> userList = List.of(user);
        Scanner scanner = new Scanner("Ivan Georgiev");

        User actualUser = usersService.returnCorrectUser(scanner, userList);
        Assertions.assertEquals(user, actualUser);
    }

    @Test
    void testLoginAsLibraryUser_ReturnTrue() {
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
        List<User> userList = List.of(user);
        Assertions.assertTrue(usersService.loginAsLibraryUser(user, userList));
    }

    @Test
    void testLoginAsLibraryUser_ReturnFalse() {
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", false);
        List<User> userList = List.of(user);
        Assertions.assertFalse(usersService.loginAsLibraryUser(user, userList));
    }
}

