package com.AdvancedLevel.innerclasses;

import com.AdvancedLevel.enumcoding.PizzaSize;

public class InnerClassesApp {

    private static boolean isPizzaReady(int waitedInMinutes) {
        class Oven {
            public boolean isPizzaBakedProperly() {
                if (waitedInMinutes > 30) {
                    return true;
                }

                return false;
            }
        }

        Oven oven = new Oven();
        return oven.isPizzaBakedProperly();
    }

    public static void main(String[] args) {

        com.AdvancedLevel.innerclasses.Pizza firstPizza = new com.AdvancedLevel.innerclasses.Pizza("Margherita", PizzaSize.MEDIUM);
        System.out.println("Name: " + firstPizza.getName());

        com.AdvancedLevel.innerclasses.Pizza secondPizza = new com.AdvancedLevel.innerclasses.Pizza("Margherita", PizzaSize.MEDIUM) {
            @Override
            public String getName() {
                return "Anonymous";
            }
        };

        System.out.println("Name: " + secondPizza.getName());

        if (isPizzaReady(40)) {
            System.out.println("The pizza is ready");
        } else {
            System.out.println("The pizza is not ready yet");
        }

        com.AdvancedLevel.innerclasses.Pizza thirdPizza = new com.AdvancedLevel.innerclasses.Pizza("Pizza cake", PizzaSize.LARGE);
        com.AdvancedLevel.innerclasses.Pizza.PizzaSlice pizzaSlice = secondPizza.cutPizzaSlice();
        System.out.println(pizzaSlice.calculatePizzaSliceArea());
    }
}
