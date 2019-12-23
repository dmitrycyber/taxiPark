package com.ivoninsky.taxipark.taxiparks;

import com.ivoninsky.taxipark.cars.Car;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Offer {
    private double offerCost;
    private Car car;

    public Offer(Car car, double offerCost) {
        this.car = car;
        this.offerCost = offerCost;
    }

    public void writeOfferToFile() {
        try (FileWriter fileWriter = new FileWriter("/home/dmitry/Projects/taxiPark/offers/offer.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            String start = "--------------OFFER----------------\n";
            bufferedWriter.write(start);
            bufferedWriter.write(car.getMake() + " " + car.getModel() + "\n");
            bufferedWriter.write("Order cost: $" + offerCost);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
