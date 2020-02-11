package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions.searcher;

import com.ivoninsky.taxipark.cars.Car;

import java.util.List;
import java.util.Scanner;

public class SearchByCarTypeCommand implements SearchCommand {
    @Override
    public List<Car> execute(List<Car> filteredListOfCars) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input type: ");
        filteredListOfCars = CarSearcher.searchCarsByType(sc.next(), filteredListOfCars);
        CarSearcher.printFilteredListOfCars(filteredListOfCars);
        return filteredListOfCars;
    }
}
