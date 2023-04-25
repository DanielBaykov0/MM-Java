package com.ExpertLevel.maps.treemap;

import java.util.TreeMap;

public class TreeMapExtraFunctionsApp {

    public static void main(String[] args) {

        TreeMap<String, Double> productPricesTreeMap = new TreeMap<>();
        productPricesTreeMap.put("Chocolate bar", 1.5);
        productPricesTreeMap.put("Pasta", 1.1);
        productPricesTreeMap.put("Cereals", 1.7);
        productPricesTreeMap.put("Apple", 0.15);
        productPricesTreeMap.put("Orange", 0.25);
        productPricesTreeMap.put("Teabox", 3.2);

        System.out.println("The first product in the map: " + productPricesTreeMap.firstKey());
        for (String product : productPricesTreeMap.keySet()) {
            System.out.println(product + " $" + productPricesTreeMap.get(product));
        }
    }
}
