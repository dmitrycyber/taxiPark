package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions.searcher;

import com.ivoninsky.taxipark.consoleNavigation.commands.Command;

import java.util.HashMap;
import java.util.Map;

public class SearchCommandContainer {
    private Map<String, Command> commandMap;

    public SearchCommandContainer() {
        commandMap = new HashMap<>();
        commandMap.put("model", new SearchByModelCommand());
    }

    public Map<String, Command> getCommandMap() {
        return commandMap;
    }
}
