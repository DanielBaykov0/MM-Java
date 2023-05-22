package com.HeroLevel.optional.filter;

import com.HeroLevel.optional.ifpresent.User;
import com.HeroLevel.optional.ifpresent.UserRepository;

import java.util.ArrayList;

public class FilterApp {

    public static void main(String[] args) {

        ArrayList<User> users = UserRepository.getUsers();
        users.forEach(EmailServiceFilter::sendPromotion);
    }
}
