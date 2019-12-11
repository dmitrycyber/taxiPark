package com.ivoninsky.taxipark.taxiparks;

import com.ivoninsky.taxipark.cars.Car;
import com.ivoninsky.taxipark.sorters.CarFuelComparator;
import com.ivoninsky.taxipark.interfaces.TaxiPark;
import com.ivoninsky.taxipark.json.JSONWriter;

import java.util.*;

public class Uber implements TaxiPark {
    private Map<Car, Integer> mapOfCars = new HashMap<>();
    private double costOfCars;
    private List<Car> listOfCars = new ArrayList<>();


    @Override
    public void addCarToPark(Car car) {
        Integer countOfCars = mapOfCars.get(car);
        if (countOfCars == null){
            countOfCars = 0;
        }
        mapOfCars.put(car, countOfCars + 1);
        listOfCars.add(car);
        costOfCars += car.getCost();
    }

    public List<Car> getListOfCars() {
        return new ArrayList<>(listOfCars);
    }

    public Map<Car, Integer> getMapOfCars() {
        return new HashMap<>(mapOfCars);
    }

    @Override
    public double getCostOfCars() {
        return new Double(costOfCars);
    }

    @Override
    public void writeCarsToJSON(String pathToFile) {
        JSONWriter jsonWriter = new JSONWriter();
        jsonWriter.writeToJSON(pathToFile, getMapOfCars());
    }

    @Override
    public int calculateOrderCost() {
        return 0;
    }

    @Override
    public Car getOfferACar() {
        return null;
    }

    @Override
    public Map<Car, Integer> orderCarByFuelConsumption() {
        CarFuelComparator carFuelComparator = new CarFuelComparator();
        Map<Car, Integer> sortedMap = new TreeMap<>(carFuelComparator);
        sortedMap.putAll(getMapOfCars());
        return sortedMap;
    }

    @Override
    public Map<Car, Integer> getTopExpensiveCars() {
        return null;
    }
}
