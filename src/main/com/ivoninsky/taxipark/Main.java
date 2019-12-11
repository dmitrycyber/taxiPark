package com.ivoninsky.taxipark;

import com.ivoninsky.taxipark.cars.Car;
import com.ivoninsky.taxipark.interfaces.TaxiPark;
import com.ivoninsky.taxipark.json.JSONReader;
import com.ivoninsky.taxipark.taxiparks.Uber;
import com.ivoninsky.taxipark.taxiparks.UberCarSearcher;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaxiPark taxiPark = new Uber();
        JSONReader jsonReader = new JSONReader();

        jsonReader.addCarsFromFileToTaxiPark("cars.json", taxiPark);

        UberCarSearcher uberCarSearcher = new UberCarSearcher(taxiPark);

        uberCarSearcher.init();








    }
}
