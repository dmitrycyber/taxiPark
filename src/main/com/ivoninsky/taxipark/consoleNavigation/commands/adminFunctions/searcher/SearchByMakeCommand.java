package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions.searcher;

import com.ivoninsky.taxipark.cars.Car;
import com.ivoninsky.taxipark.consoleNavigation.commands.Command;

import java.util.List;
import java.util.Scanner;

public class SearchByMakeCommand implements SearchCommand {
    @Override
    public List<Car> execute(List<Car> filteredListOfCars) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input make: ");
        filteredListOfCars = CarSearcher.searchCarsByMake(sc.next(), filteredListOfCars);
        CarSearcher.printFilteredListOfCars(filteredListOfCars);
        return filteredListOfCars;
    }
}
