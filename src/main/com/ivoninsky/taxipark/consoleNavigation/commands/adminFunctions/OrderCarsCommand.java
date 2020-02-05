package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions;

import com.ivoninsky.taxipark.consoleNavigation.commands.Command;
import com.ivoninsky.taxipark.interfaces.TaxiPark;

public class OrderCarsCommand implements Command {
    @Override
    public void execute(TaxiPark taxiPark) {
        taxiPark.orderCarByFuelConsumption();
    }
}
