package com.HeroLevel.optional.orelseget;

import com.HeroLevel.optional.ifpresent.User;

public class EmailServiceOrElseGet {

    public static void sendPromotion(User user) {
       String email = user.getEmail().orElseGet(() -> user.getName().toLowerCase() + "@example.com");
        System.out.println("Promotion email is sent to: " + email);
    }
}
