package com.HeroLevel.optional.orelsethrow;

import com.HeroLevel.optional.ifpresent.User;
import com.HeroLevel.optional.ifpresent.UserRepository;

import java.util.ArrayList;

public class OrElseThrowApp {

    public static void main(String[] args) {

        ArrayList<User> users = UserRepository.getUsers();
        users.forEach(EmailServiceOrElseThrow::sendPromotion);
    }
}
