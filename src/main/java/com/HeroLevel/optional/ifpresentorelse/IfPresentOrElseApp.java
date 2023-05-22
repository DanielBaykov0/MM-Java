package com.HeroLevel.optional.ifpresentorelse;

import com.HeroLevel.optional.ifpresent.User;
import com.HeroLevel.optional.ifpresent.UserRepository;

import java.util.ArrayList;

public class IfPresentOrElseApp {

    public static void main(String[] args) {

        ArrayList<User> users = UserRepository.getUsers();
        users.forEach(EmailService::sendPromotion);
    }
}
