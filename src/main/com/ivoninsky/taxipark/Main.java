package com.ivoninsky.taxipark;

import com.ivoninsky.taxipark.consoleNavigation.MainMenu;
import com.ivoninsky.taxipark.json.JSONReader;
import com.ivoninsky.taxipark.json.JSONWriter;
import com.ivoninsky.taxipark.taxiparks.Uber;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MainMenu mainMenu = new MainMenu();
        mainMenu.start();

        /*Uber uber = new Uber();
        JSONReader jsonReader = new JSONReader();
        jsonReader.addCarsFromFileToTaxiPark("cars.json", uber);

        uber.printListOfCars(uber.getListOfCars());
        System.out.println();

        uber.getTopExpensiveCars(2);*/
    }
}
