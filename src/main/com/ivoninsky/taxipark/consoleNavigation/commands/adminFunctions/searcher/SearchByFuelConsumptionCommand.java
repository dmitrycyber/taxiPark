package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions.searcher;

import com.ivoninsky.taxipark.cars.Car;

import java.util.List;
import java.util.Scanner;

public class SearchByFuelConsumptionCommand implements SearchCommand {

    @Override
    public List<Car> execute(List<Car> filteredListOfCars) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input fuelConsumption from: ");
        double startFuelConsumption = sc.nextDouble();
        System.out.println("Input fuelConsumption to: ");
        double finishFuelConsumption = sc.nextDouble();
        filteredListOfCars = CarSearcher.searchCarsByFuelConsumption(startFuelConsumption, finishFuelConsumption, filteredListOfCars);
        CarSearcher.printFilteredListOfCars(filteredListOfCars);
        return filteredListOfCars;
    }
}
