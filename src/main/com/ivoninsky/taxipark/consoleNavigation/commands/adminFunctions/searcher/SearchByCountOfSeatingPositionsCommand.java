package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions.searcher;

import com.ivoninsky.taxipark.cars.Car;

import java.util.List;
import java.util.Scanner;

public class SearchByCountOfSeatingPositionsCommand implements SearchCommand {
    @Override
    public List<Car> execute(List<Car> filteredListOfCars) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input countOfSeatingPositions from: ");
        int startCountOfSeatingPositions = sc.nextInt();
        System.out.println("Input countOfSeatingPositions to: ");
        int finishCountOfSeatingPositions = sc.nextInt();
        filteredListOfCars = CarSearcher.searchCarsByCountOfSeatingPositions(startCountOfSeatingPositions, finishCountOfSeatingPositions, filteredListOfCars);
        CarSearcher.printFilteredListOfCars(filteredListOfCars);
        return filteredListOfCars;
    }
}
