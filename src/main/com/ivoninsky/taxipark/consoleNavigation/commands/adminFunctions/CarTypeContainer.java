package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions;

import com.ivoninsky.taxipark.cars.Bus;
import com.ivoninsky.taxipark.cars.Car;
import com.ivoninsky.taxipark.cars.Minivan;
import com.ivoninsky.taxipark.cars.Sedan;

import java.util.HashMap;
import java.util.Map;

public class CarTypeContainer {
    private Map<String, Car> carMap;
    private String model;
    private String make;
    private double fuelConsumption;
    private int countOfSeatingPositions;
    private double cost;
    private int yearOfIssue;
    private String type;

    public CarTypeContainer(String model, String make, double fuelConsumption, int countOfSeatingPositions, double cost, int yearOfIssue, String type) {
        carMap = new HashMap<>();
        this.model = model;
        this.make = make;
        this.fuelConsumption = fuelConsumption;
        this.countOfSeatingPositions = countOfSeatingPositions;
        this.cost = cost;
        this.yearOfIssue = yearOfIssue;
        this.type = type;
        carMap.put("Sedan", new Sedan(model, make, fuelConsumption, countOfSeatingPositions, cost, yearOfIssue, type));
        carMap.put("Minivan", new Minivan(model, make, fuelConsumption, countOfSeatingPositions, cost, yearOfIssue, type));
        carMap.put("Bus", new Bus(model, make, fuelConsumption, countOfSeatingPositions, cost, yearOfIssue, type));
    }

    public Map<String, Car> getCarMap() {
        return carMap;
    }
}
