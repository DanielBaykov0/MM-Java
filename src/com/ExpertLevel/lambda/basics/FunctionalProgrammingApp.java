package com.ExpertLevel.lambda.basics;

public class FunctionalProgrammingApp {

    public static void main(String[] args) {

        WelcomeMessageService welcomeMessageService = new WelcomeMessageService();
        Greeter greeter;
        if (isLoggedInUser) {
            greeter = new LoggedInUserGreeter();
        } else {
            greeter = new GuestUserGreeter();
        }

        welcomeMessageService.greet(greeter);
    }
}
