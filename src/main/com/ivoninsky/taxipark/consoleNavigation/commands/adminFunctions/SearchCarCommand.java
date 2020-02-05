package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions;

import com.ivoninsky.taxipark.consoleNavigation.commands.Command;
import com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions.searcher.CarSearcher;
import com.ivoninsky.taxipark.interfaces.TaxiPark;

public class SearchCarCommand implements Command {
    private TaxiPark taxiPark;

    public SearchCarCommand(TaxiPark taxiPark) {
        this.taxiPark = taxiPark;
    }

    @Override
    public void execute() {
        CarSearcher carSearcher = new CarSearcher(taxiPark);
        carSearcher.start();
    }
}
