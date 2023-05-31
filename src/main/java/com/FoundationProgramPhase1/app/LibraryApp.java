package com.FoundationProgramPhase1.app;

import com.FoundationProgramPhase1.service.UsersService;
import com.FoundationProgramPhase1.core.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        UsersService usersService = new UsersService();
        User user = usersService.createUser(new Scanner(System.in));
        List<User> list = new ArrayList<>();
        list.add(user);

        System.out.println(list);
    }
}
