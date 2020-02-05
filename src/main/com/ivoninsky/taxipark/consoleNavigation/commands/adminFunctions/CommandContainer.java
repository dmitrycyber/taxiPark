package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions;

import com.ivoninsky.taxipark.consoleNavigation.commands.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
    private Map<String, Command> commandMap;

    public CommandContainer() {
        commandMap = new HashMap<>();
        commandMap.put("1", new AddCarsToParkCommand());
        commandMap.put("2", new PrintCarsCommand());
        commandMap.put("3", new GetCarsCostCommand());
        commandMap.put("4", new OrderCarsCommand());
        commandMap.put("5", new SearchCarCommand());
        commandMap.put("6", new GetTopExpensiveCarCommand());
        commandMap.put("7", new AddCarsToFileCommand());

    }

    public Map<String, Command> getCommandMap() {
        return commandMap;
    }
}
