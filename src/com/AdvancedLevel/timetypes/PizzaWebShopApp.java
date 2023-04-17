package com.AdvancedLevel.timetypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class PizzaWebShopApp {

    public static void main(String[] args) {

        LocalTime openingHour = LocalTime.of(11, 0);
        LocalTime closingTime = LocalTime.of(22, 0);
        System.out.println("The restaurant is open from " + openingHour + " to " + closingTime + " on every day");

        LocalDate orderDate = LocalDate.now().minusDays(3);
        System.out.println("The pizza was ordered on " + orderDate);

        LocalDateTime orderDateTime = LocalDateTime.from(orderDate.atStartOfDay()).withHour(17);
        System.out.println("I submitted the order: " + orderDateTime);

        LocalTime deliveryTime = LocalTime.of(1, 10);
        System.out.println("Delivery time: " + deliveryTime);

        LocalDateTime estimatedDeliveryDateTime = orderDateTime.plusHours(deliveryTime.getHour()).plusMinutes(deliveryTime.getMinute());
        System.out.println("The estimated delivery time: " + estimatedDeliveryDateTime);

        LocalDateTime realDeliveryDateTime = orderDateTime.plusMinutes(90);
        System.out.println("The real delivery time was: " + realDeliveryDateTime);

        long differenceBetweenEstimatedAndReal = ChronoUnit.MINUTES.between(estimatedDeliveryDateTime, realDeliveryDateTime);
        System.out.println("Difference: " + differenceBetweenEstimatedAndReal + " in minutes");

        if (estimatedDeliveryDateTime.isBefore(realDeliveryDateTime)) {
            System.out.println("The pizza didn't arrive in time");
        } else {
            System.out.println("The pizza arrived in time");
        }
    }
}
