package com.FoundationProgramPhase1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        ManageUsers manageUsers = new ManageUsers();
        User user = manageUsers.createUser(new Scanner(System.in));
        List<User> list = new ArrayList<>();
        list.add(user);

        System.out.println(list);
    }
}
