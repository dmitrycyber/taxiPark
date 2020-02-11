package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions;

import com.ivoninsky.taxipark.consoleNavigation.commands.Command;
import com.ivoninsky.taxipark.interfaces.TaxiPark;

public class OrderCarsCommand implements Command {
    private TaxiPark taxiPark;

    public OrderCarsCommand(TaxiPark taxiPark) {
        this.taxiPark = taxiPark;
    }

    @Override
    public void execute() {
        taxiPark.orderCarByFuelConsumption();
    }
}
