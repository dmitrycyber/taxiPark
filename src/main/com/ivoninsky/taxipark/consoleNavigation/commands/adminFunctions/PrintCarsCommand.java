package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions;

import com.ivoninsky.taxipark.cars.Car;
import com.ivoninsky.taxipark.consoleNavigation.commands.Command;
import com.ivoninsky.taxipark.interfaces.TaxiPark;

import java.util.List;

public class PrintCarsCommand implements Command {
    private TaxiPark taxiPark;

    public PrintCarsCommand(TaxiPark taxiPark) {
        this.taxiPark = taxiPark;
    }

    @Override
    public void execute() {
        printListOfCars(taxiPark.getListOfCars());
    }

    private void printListOfCars(List<Car> listOfCars) {
        if (listOfCars.size() != 0) {
            for (int i = 0; i < listOfCars.size(); i++) {
                System.out.println(i + 1 + ". " + listOfCars.get(i));
            }
        } else {
            System.out.println("No added cars to taxi park");
        }
    }
}
