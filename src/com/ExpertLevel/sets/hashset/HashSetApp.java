package com.ExpertLevel.sets.hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetApp {

    public static void main(String[] args) {

        Set<String> carModels = new HashSet<>();
        carModels.add("Toyota");
        carModels.add("Nissan");
        carModels.add("Ford");
        carModels.add("Kia");
        carModels.add("Toyota");

        carModels.clear();
        carModels.remove("Ford");

        System.out.println(carModels);
        System.out.println("Kia is in the set: " + carModels.contains("Kia"));
        System.out.println("The size of the set: " + carModels.size());

        System.out.println();
        System.out.println("We have the following car models:");
        for (String carModel : carModels) {
            System.out.println("- " + carModel.toUpperCase());
        }
    }
}
