package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions;

import com.ivoninsky.taxipark.cars.Bus;
import com.ivoninsky.taxipark.cars.Car;
import com.ivoninsky.taxipark.cars.Minivan;
import com.ivoninsky.taxipark.cars.Sedan;

public class CarTypeContainer {

    public CarTypeContainer() {
    }

    public static Car getCarFromType(String model, String make, double fuelConsumption, int countOfSeatingPositions, double cost, int yearOfIssue, String type){
        if (type.equals("Sedan")){
            return new Sedan(model, make, fuelConsumption, countOfSeatingPositions, cost, yearOfIssue, type);
        }
        else if (type.equals("Minivan")){
            return new Minivan(model, make, fuelConsumption, countOfSeatingPositions, cost, yearOfIssue, type);
        }
        return new Bus(model, make, fuelConsumption, countOfSeatingPositions, cost, yearOfIssue, type);
    }
}
