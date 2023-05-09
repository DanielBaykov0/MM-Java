package com.ExpertLevel.streams.flatmap;

import java.util.List;
import java.util.Objects;

public class CarDealership {

    private final String name;
    private final List<String> carModels;

    public CarDealership(String name, List<String> carModels) {
        this.name = name;
        this.carModels = carModels;
    }

    public String getName() {
        return name;
    }

    public List<String> getCarModels() {
        return carModels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDealership that = (CarDealership) o;
        return Objects.equals(name, that.name) && Objects.equals(carModels, that.carModels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, carModels);
    }

    @Override
    public String toString() {
        return "CarDealership{" +
                "name='" + name + '\'' +
                ", carModels=" + carModels +
                '}';
    }
}
