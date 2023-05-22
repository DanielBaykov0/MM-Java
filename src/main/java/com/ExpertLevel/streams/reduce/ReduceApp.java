package com.ExpertLevel.streams.reduce;

import com.ExpertLevel.streams.collect.Item;

import java.util.List;

public class ReduceApp {

    public static void main(String[] args) {

        List<Item> shoppingCart = List.of(
                new Item("strawberry", 10, 10.0),
                new Item("blueberry", 20, 30.0),
                new Item("pear", 10, 30.0)
        );

        double subTotal = shoppingCart.stream()
                .mapToDouble(Item::getPrice)
                .sum();

        double discount = -10;
        double totalPrice = shoppingCart.stream()
                .map(Item::getPrice)
                .reduce(discount, Double::sum);

        System.out.println("SubTotal: \t\t$" + subTotal);
        System.out.println("Discount: \t\t$" + discount);
        System.out.println("TotalPrice: \t$" + totalPrice);
    }
}
