package com.AdvancedLevel.enumcoding;

public class PizzaApp {

    public static void main(String[] args) {

        System.out.println("Available sizes:");
        for (PizzaSize pizzaSize : PizzaSize.values()) {
            System.out.println("-" + pizzaSize.getPizzaSizeText());
        }

        System.out.println("--------------------------------");

        Pizza pizzaOrder = new Pizza("Margarita", PizzaSize.MEDIUM);
        System.out.println("I ordered the following pizza:");
        System.out.println("Name: " + pizzaOrder.getName());
        System.out.println("Size: " + pizzaOrder.getPizzaSize().getPizzaSizeText());
        System.out.println("Price: " + pizzaOrder.getPrice());
    }
}
