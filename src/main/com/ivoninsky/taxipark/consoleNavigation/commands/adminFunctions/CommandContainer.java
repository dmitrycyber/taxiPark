package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions;

import com.ivoninsky.taxipark.consoleNavigation.commands.Command;
import com.ivoninsky.taxipark.interfaces.TaxiPark;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
    private Map<String, Command> commandMap;
    private TaxiPark taxiPark;

    public CommandContainer(TaxiPark taxiPark) {
        this.taxiPark = taxiPark;
        commandMap = new HashMap<>();
        commandMap.put("1", new AddCarsToParkCommand(taxiPark));
        commandMap.put("2", new PrintCarsCommand(taxiPark));
        commandMap.put("3", new GetCarsCostCommand(taxiPark));
        commandMap.put("4", new OrderCarsCommand(taxiPark));
        commandMap.put("5", new SearchCarCommand(taxiPark));
        commandMap.put("6", new GetTopExpensiveCarCommand(taxiPark));
        commandMap.put("7", new AddCarsToFileCommand(taxiPark));

    }

    public Map<String, Command> getCommandMap() {
        return commandMap;
    }
}
