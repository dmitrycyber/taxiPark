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
//    double calculateKilometerCost(Car car);
//    double calculateCarFee(Car car);
    double calculateTotalCostOrder(Car car, int numberOfKilometers);
    Car getOfferACar();
    Map<Car, Integer> orderCarByFuelConsumption();
    Map<Car, Integer> getTopExpensiveCars(int count);
    void printListOfCars(List<Car> listOfCars);
    List<Car> getEconomClass();
    List<Car> getComfortClass();
    List<Car> getBusinessClass();

}
