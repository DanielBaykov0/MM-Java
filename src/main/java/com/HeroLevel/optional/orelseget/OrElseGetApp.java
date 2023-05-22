package com.HeroLevel.optional.orelseget;

import com.HeroLevel.optional.ifpresent.User;
import com.HeroLevel.optional.ifpresent.UserRepository;

import java.util.ArrayList;

public class OrElseGetApp {

    public static void main(String[] args) {

        ArrayList<User> users = UserRepository.getUsers();
        users.forEach(EmailServiceOrElseGet::sendPromotion);
    }
}
