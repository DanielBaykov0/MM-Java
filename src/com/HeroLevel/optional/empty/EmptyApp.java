package com.HeroLevel.optional.empty;

import java.util.Optional;

public class EmptyApp {

    public static void main(String[] args) {

//        Optional<String> nullStringOptional = null;
//        nullStringOptional.ifPresentOrElse(System.out::println, () -> System.out.println("Empty"));

        Optional<String> emptyOptionalString = Optional.empty();
        emptyOptionalString.ifPresentOrElse(System.out::println, () -> System.out.println("Empty"));
    }
}
