package com.AdvancedLevel.innerclasses;

import com.AdvancedLevel.enumcoding.PizzaSize;

public class Pizza {

    private String name;
    private PizzaSize pizzaSize;
    private double price;

    public Pizza(String name, PizzaSize pizzaSize) {
        this.name = name;
        this.pizzaSize = pizzaSize;
        this.price = calculatePrice();
    }

    class PizzaSlice {
        public String calculatePizzaSliceArea() {
            switch (pizzaSize) {

                case MEDIUM -> {
                    return "Medium slice";
                }

                case LARGE -> {
                    return "Large slice";
                }

                default -> {
                    return "Small slice";
                }
            }
        }
    }

    public PizzaSlice cutPizzaSlice() {
        return new PizzaSlice();
    }

    private double calculatePrice() {
        switch (pizzaSize) {

            case MEDIUM -> {
                return 7.99;
            }

            case LARGE -> {
                return 10.99;
            }

            default -> {
                return 5.99;
            }
        }
    }

    public String getName() {
        return name;
    }

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public double getPrice() {
        return price;
    }
}
