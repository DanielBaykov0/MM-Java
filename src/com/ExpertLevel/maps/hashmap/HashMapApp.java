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

    }
}
