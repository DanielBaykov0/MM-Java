package com.ExpertLevel.lambda.basics;

public class FunctionalProgrammingApp {

    public static void main(String[] args) {

        WelcomeMessageService welcomeMessageService = new WelcomeMessageService();
        Greeter greeter = new GuestUserGreeter();
        Greeter loggedInUserGreeter = () -> System.out.println("Welcome back");
        welcomeMessageService.greet(() -> System.out.println("Welcome back"));
//        greeter.perform();
//        loggedInUserGreeter.perform();

    }
}

interface MyFunctionType {

    void myFunction();
}
