package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions.searcher;

import com.ivoninsky.taxipark.cars.Car;
import java.util.List;
import java.util.Scanner;

public class SearchByModelCommand implements SearchCommand {

    @Override
    public List<Car> execute(List<Car> filteredListOfCars) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input model: ");
        filteredListOfCars = CarSearcher.searchCarsByModel(sc.next(), filteredListOfCars);
        CarSearcher.printFilteredListOfCars(filteredListOfCars);
        return filteredListOfCars;
    }
}
