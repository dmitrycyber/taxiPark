package com.ivoninsky.taxipark.cars;

import java.util.Objects;

public abstract class Car implements Comparable<Car> {
    private String model;
    private String make;
    private double fuelConsumption;
    private int countOfSeatingPositions;
    private double cost;
    private int yearOfIssue;
    private String type;

    public Car(String model, String make, double fuelConsumption, int countOfSeatingPositions, double cost, int yearOfIssue, String type) {
        this.model = model;
        this.make = make;
        this.fuelConsumption = fuelConsumption;
        this.countOfSeatingPositions = countOfSeatingPositions;
        this.cost = cost;
        this.yearOfIssue = yearOfIssue;
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getCountOfSeatingPositions() {
        return countOfSeatingPositions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.fuelConsumption, fuelConsumption) == 0 &&
                countOfSeatingPositions == car.countOfSeatingPositions &&
                model.equals(car.model) &&
                make.equals(car.make);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, make, fuelConsumption, countOfSeatingPositions);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", fuelConsumption=" + fuelConsumption +
                ", countOfSeatingPositions=" + countOfSeatingPositions +
                ", cost=" + cost +
                ", yearOfIssue=" + yearOfIssue +
                ", type=" + type +
                '}';
    }

    @Override
    public int compareTo(Car car) {
        return (int) (this.fuelConsumption - car.getFuelConsumption());
    }
}
