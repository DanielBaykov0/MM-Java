package com.HeroLevel.optional.orelsethrow;

import com.HeroLevel.optional.ifpresent.User;

import java.util.NoSuchElementException;

public class EmailServiceOrElseThrow {

    public static void sendPromotion(User user) {
        try {
            String email = user.getEmail().orElseThrow(NoSuchElementException::new);
            System.out.println("Promotion email is sent to: " + email);
        } catch (NoSuchElementException e) {
            System.out.println("Something is wrong with the email address");
        }
    }
}
