package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions.searcher;

import com.ivoninsky.taxipark.cars.Car;

import java.util.List;

public interface SearchCommand {
    List<Car> execute(List<Car> filteredListOfCars);

}
