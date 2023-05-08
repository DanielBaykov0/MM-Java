package com.ExpertLevel.streams.collect;

import java.util.List;
import java.util.stream.Collectors;

public class CollectUtilFunctionsApp {

    public static void main(String[] args) {

        List<String> playerNames = List.of("Azita", "Lamar", "Maui");
        List<Integer> playerDamage = List.of(12, 20, 15, 120, 30, 16, 40, 20, 100);
        List<Double> playerDamageDouble = List.of(12.0, 20.0, 15.0, 120.0, 30.0, 16.0, 40.0, 20.0, 100.0);

        System.out.println("Player names: " + String.join(", ", playerNames));
        System.out.println("Player damages: " + playerDamage.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ")));

        Long numberOfHits = playerDamage.stream().collect(Collectors.counting());
        System.out.println("Number of hits: " + numberOfHits);
    }
}
