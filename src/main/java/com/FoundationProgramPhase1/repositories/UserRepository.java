package com.FoundationProgramPhase1.repositories;

import com.FoundationProgramPhase1.core.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static List<User> getUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User("bigmarto", "weakOne", "Martin Zabitzer", 24, "male", "123 Street", "Sofia", "Bulgaria", "marto@abv.bg", true));
        list.add(new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", false));
        list.add(new User("malkata", "gameOne", "Silvia Segal", 32, "female", "24 DownStreet", "Ankara", "Turkey", "silvia@abv.bg", true));
        list.add(new User("elenavlad", "letsGoOne", "Elena Vladeva", 27, "female", "1 St.Street", "Moscow", "Russia", "elena@abv.bg", true));
        list.add(new User("fallout", "destroyerOne", "Jimmy Fallon", 20, "male", "24 ImaginaryStreet", "New York", "USA", "jimmy@abv.bg", false));
        return list;
    }
}
