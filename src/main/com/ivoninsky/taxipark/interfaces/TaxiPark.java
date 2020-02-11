package com.ivoninsky.taxipark.interfaces;

import com.ivoninsky.taxipark.cars.Car;

import java.util.List;
import java.util.Map;

public interface TaxiPark {
    void addCarToPark(Car car);
    Map<Car, Integer> getCarCountMap();
    List<Car> getListOfCars();
    double getCostOfCars();
    void writeCarsToJSON(String pathToFile);
    double calculateTotalCostOrder(Car car, int numberOfKilometers);
    Map<Car, Integer> orderCarByFuelConsumption();
    Map<Car, Integer> getTopExpensiveCars(int count);
    void printListOfCars(List<Car> listOfCars);
    List<Car> getCarsOfClass(String classType);

}
