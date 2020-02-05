package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions;

import com.ivoninsky.taxipark.cars.Car;
import com.ivoninsky.taxipark.consoleNavigation.commands.Command;
import com.ivoninsky.taxipark.interfaces.TaxiPark;
import com.ivoninsky.taxipark.json.JSONReader;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddCarsToParkCommand implements Command {
    private TaxiPark taxiPark;

    public AddCarsToParkCommand(TaxiPark taxiPark) {
        this.taxiPark = taxiPark;
    }

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        JSONReader jsonReader = new JSONReader();
        ManuallyCreateCarCommand manuallyCreateCarCommand = new ManuallyCreateCarCommand();
        System.out.println("Input file name: ");
        try {
            jsonReader.addCarsFromFileToTaxiPark(sc.next(), taxiPark);
            System.out.println("Cars added to taxi park successfully");
        }
        catch (FileNotFoundException | StringIndexOutOfBoundsException e) {
            System.out.println("File not found! " +
                    "Input \"yes\" to add car manualy and \"any key\" for exit");
            String isManuallyInputCars = sc.next();
            while (!isManuallyInputCars.equals("yes") && !isManuallyInputCars.equals("no")) {
                System.out.println("Input yes or no!");
                isManuallyInputCars = sc.next();
            }
            if (isManuallyInputCars.equals("yes")) {
                manuallyCreateCarCommand.addManuallyCarToTaxiPark(taxiPark);
            }
        }
    }
}
