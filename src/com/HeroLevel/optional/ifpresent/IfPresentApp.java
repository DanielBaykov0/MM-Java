package com.HeroLevel.optional.ifpresent;

import java.util.ArrayList;

public class IfPresentApp {

    public static void main(String[] args) {

        ArrayList<User> users = UserRepository.getUsers();
        users.forEach(EmailService::sendPromotion);
    }
}
