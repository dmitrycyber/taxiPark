package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions;

import com.ivoninsky.taxipark.consoleNavigation.commands.Command;
import com.ivoninsky.taxipark.interfaces.TaxiPark;

public class GetCarsCostCommand implements Command {
    private TaxiPark taxiPark;

    public GetCarsCostCommand(TaxiPark taxiPark) {
        this.taxiPark = taxiPark;
    }

    @Override
    public void execute() {
        System.out.println("Cost of cars: $" + taxiPark.getCostOfCars());
    }
}
