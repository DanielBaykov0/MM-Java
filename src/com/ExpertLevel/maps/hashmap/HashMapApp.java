package com.ExpertLevel.maps.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapApp {

    public static void main(String[] args) {

        Map<String, String> capitals = new HashMap<>();
        capitals.put("England", "London");
        capitals.put("India", "New Delhi");
        capitals.put("Russia", "Moscow");
        capitals.put("England", "Oslo");

        System.out.println("The capital of England is: " + capitals.get("England"));
        capitals.remove("England", "Oslo");
        System.out.println("The capital of England is: " + capitals.get("England"));

        if (capitals.containsValue("Moscow")) {
            System.out.println("Russia is on the list");
        }

        capitals.put(null, "The city is not on the list");
        String userInput = "Denmark";
        if (capitals.containsKey(userInput)) {
            System.out.println(capitals.get(userInput));
        } else {
            System.out.println(capitals.get(null));
        }

        System.out.println(capitals.getOrDefault(userInput, "The city is not on the list"));

        capitals.replace("India", "Ankara", "Mumbai");
        System.out.println("The capital of India is: " + capitals.get("India"));

    }
}
