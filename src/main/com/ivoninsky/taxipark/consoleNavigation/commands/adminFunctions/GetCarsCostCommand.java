package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions;

import com.ivoninsky.taxipark.consoleNavigation.commands.Command;
import com.ivoninsky.taxipark.interfaces.TaxiPark;

public class GetCarsCostCommand implements Command {
    @Override
    public void execute(TaxiPark taxiPark) {
        System.out.println("Cost of cars: $" + taxiPark.getCostOfCars());
    }
}
