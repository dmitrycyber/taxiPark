package com.ivoninsky.taxipark.interfaces;

import com.ivoninsky.taxipark.cars.Car;

import java.util.List;
import java.util.Map;

public interface TaxiPark {
    void addCarToPark(Car car);
    Map<Car, Integer> getMapOfCars();
    List<Car> getListOfCars();
    double getCostOfCars();
    void writeCarsToJSON(String pathToFile);
    int calculateOrderCost();
    Car getOfferACar();
    Map<Car, Integer> orderCarByFuelConsumption();
    Map<Car, Integer> getTopExpensiveCars();

}
