package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions;

import com.ivoninsky.taxipark.consoleNavigation.commands.Command;
import com.ivoninsky.taxipark.interfaces.TaxiPark;
import com.ivoninsky.taxipark.taxiparks.UberCarSearcher;

public class SearchCarCommand implements Command {
    @Override
    public void execute(TaxiPark taxiPark) {
        UberCarSearcher uberCarSearcher = new UberCarSearcher(taxiPark);
        uberCarSearcher.start();
    }
}
