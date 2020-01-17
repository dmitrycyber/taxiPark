package com.ivoninsky.taxipark.consoleNavigation.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
    private Map<String, Command> commandMap;

    public CommandContainer(){
        commandMap = new HashMap<>();
        commandMap.put("1", new AddCarsCommand());
        commandMap.put("2", new PrintCarsCommand());
        commandMap.put("3", new GetCarsCostCommand());

    }

    public Map<String, Command> getCommandMap(){
        return commandMap;
    }
}
