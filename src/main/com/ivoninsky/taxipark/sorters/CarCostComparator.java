package com.ivoninsky.taxipark.sorters;

import com.ivoninsky.taxipark.cars.Car;

import java.util.Comparator;

public class CarCostComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        return (int) (car2.getCost() - car1.getCost());
    }
}
