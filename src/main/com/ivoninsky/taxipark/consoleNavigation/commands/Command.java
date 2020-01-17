package com.ivoninsky.taxipark.consoleNavigation.commands;

import com.ivoninsky.taxipark.interfaces.TaxiPark;

public interface Command {
    void execute(TaxiPark taxiPark);
}
