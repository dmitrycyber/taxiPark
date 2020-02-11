package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions.searcher;

import com.ivoninsky.taxipark.cars.Car;

import java.util.List;
import java.util.Scanner;

public class SearchByCostCommand implements SearchCommand {
    @Override
    public List<Car> execute(List<Car> filteredListOfCars) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input cost from: ");
        double startCost = sc.nextDouble();
        System.out.println("Input cost to: ");
        double finishCost = sc.nextDouble();
        filteredListOfCars = CarSearcher.searchCarsByCost(startCost, finishCost, filteredListOfCars);
        CarSearcher.printFilteredListOfCars(filteredListOfCars);
        return filteredListOfCars;
    }
}
