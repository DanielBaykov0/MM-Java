package com.HeroLevel.optional.orelse;

import com.HeroLevel.optional.ifpresent.User;
import com.HeroLevel.optional.ifpresent.UserRepository;

import java.util.ArrayList;

public class OrElseApp {

    public static void main(String[] args) {

        ArrayList<User> users = UserRepository.getUsers();
        users.forEach(EmailServiceOrElse::sendPromotion);
    }
}
