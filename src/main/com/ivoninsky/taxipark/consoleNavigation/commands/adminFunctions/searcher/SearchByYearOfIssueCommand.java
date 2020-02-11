package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions.searcher;

import com.ivoninsky.taxipark.cars.Car;

import java.util.List;
import java.util.Scanner;

public class SearchByYearOfIssueCommand implements SearchCommand {
    @Override
    public List<Car> execute(List<Car> filteredListOfCars) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input year of issue from: ");
        int startCost = sc.nextInt();
        System.out.println("Input year of issue to: ");
        int finishCost = sc.nextInt();
        filteredListOfCars = CarSearcher.searchCarsByYearOfIssue(startCost, finishCost, filteredListOfCars);
        CarSearcher.printFilteredListOfCars(filteredListOfCars);
        return filteredListOfCars;
    }
}
