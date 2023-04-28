package com.ExpertLevel.lambda.basics;

public class FunctionalProgrammingApp {

    public static void main(String[] args) {

        WelcomeMessageService welcomeMessageService = new WelcomeMessageService();
        Greeter greeter = new GuestUserGreeter();
        welcomeMessageService.greet(greeter);

        MyFunctionType loggedInUserGreeter = () -> System.out.println("Welcome back");
    }
}

interface MyFunctionType {

    void myFunction();
}
