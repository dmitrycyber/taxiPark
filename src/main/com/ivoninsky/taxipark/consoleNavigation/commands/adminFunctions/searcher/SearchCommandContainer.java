package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions.searcher;

import com.ivoninsky.taxipark.cars.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchCommandContainer {
    private Map<String, SearchCommand> commandMap;
    private List<Car> filteredListOfCars;

    public SearchCommandContainer(List<Car> filteredListOfCars) {
        this.filteredListOfCars = filteredListOfCars;
        commandMap = new HashMap<>();
        commandMap.put("model", new SearchByModelCommand());
        commandMap.put("make", new SearchByMakeCommand());
        commandMap.put("fuelConsumption", new SearchByFuelConsumptionCommand());
        commandMap.put("countOfSeatingPositions", new SearchByCountOfSeatingPositionsCommand());
        commandMap.put("cost", new SearchByCostCommand());
        commandMap.put("yearOfIssue", new SearchByYearOfIssueCommand());
        commandMap.put("type", new SearchByCarTypeCommand());
    }

    public Map<String, SearchCommand> getCommandMap() {
        return commandMap;
    }
}
