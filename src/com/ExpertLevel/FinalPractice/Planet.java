package com.ExpertLevel.FinalPractice;

import java.util.Objects;

public class Planet {

    private PlanetName name;
    private int size;
    private double distanceFromTheClosestStar;
    private double temperature;
    private PlanetType type;
    private double distanceFromEarth;

    public Planet(PlanetName name, int size, double distanceFromTheClosestStar, double temperature, PlanetType type, double distanceFromEarth) {
        this.name = name;
        this.size = size;
        this.distanceFromTheClosestStar = distanceFromTheClosestStar;
        this.temperature = temperature;
        this.type = type;
        this.distanceFromEarth = distanceFromEarth;
    }

    public PlanetName getName() {
        return name;
    }

    public void setName(PlanetName name) {
        this.name = name;
    }

    public PlanetType getType() {
        return type;
    }

    public void setType(PlanetType type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getDistanceFromTheClosestStar() {
        return distanceFromTheClosestStar;
    }

    public void setDistanceFromTheClosestStar(double distanceFromTheClosestStar) {
        this.distanceFromTheClosestStar = distanceFromTheClosestStar;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getDistanceFromEarth() {
        return distanceFromEarth;
    }

    public void setDistanceFromEarth(double distanceFromEarth) {
        this.distanceFromEarth = distanceFromEarth;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name=" + name +
                ", size=" + size +
                ", distanceFromTheClosestStar=" + distanceFromTheClosestStar +
                ", averageTemperature=" + temperature +
                ", type=" + type +
                ", distanceFromEarth=" + distanceFromEarth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return size == planet.size && Double.compare(planet.distanceFromTheClosestStar, distanceFromTheClosestStar) == 0 && Double.compare(planet.temperature, temperature) == 0 && Double.compare(planet.distanceFromEarth, distanceFromEarth) == 0 && Objects.equals(name, planet.name) && Objects.equals(type, planet.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, distanceFromTheClosestStar, temperature, type, distanceFromEarth);
    }
}
