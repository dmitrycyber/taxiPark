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
    private List<Car> economClass = new ArrayList<>();
    private List<Car> comfortClass = new ArrayList<>();
    private List<Car> businessClass = new ArrayList<>();

    @Override
    public void addCarToPark(Car car) {
        if (car == null){
            return;
        }
        Integer countOfCars = mapOfCars.get(car);
        if (countOfCars == null){
            countOfCars = 0;
        }
        mapOfCars.put(car, countOfCars + 1);
        listOfCars.add(car);
        if (car.getCost() <= 10000){
            economClass.add(car);
        }
        else if (car.getCost() > 10000 && car.getCost() <= 15000){
            comfortClass.add(car);
        }
        else{
            businessClass.add(car);
        }
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

    private int calculateKilometerCost(Car car) {
        if (economClass.contains(car)){
            return 1;
        }
        else if (comfortClass.contains(car)){
            return 2;
        }
        else {
            return 3;
        }
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
        printSortedMap(sortedMap);
        return sortedMap;
    }

    @Override
    public Map<Car, Integer> getTopExpensiveCars() {
        return null;
    }

    public void printSortedMap(Map<Car, Integer> givenMap){
        if (givenMap.size() != 0){
            for (Map.Entry<Car, Integer> entry : givenMap.entrySet()){
                System.out.println(entry.getKey() + " count: " + entry.getValue());
            }
        }
        System.out.println("No added cars to taxi park");

    }
}
