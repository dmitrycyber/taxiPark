package com.ivoninsky.taxipark.taxiparks;

import com.ivoninsky.taxipark.cars.Car;
import com.ivoninsky.taxipark.interfaces.TaxiPark;
import com.ivoninsky.taxipark.taxiparks.Uber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UberCarSearcher {
    List<Car> listOfCars;

    public UberCarSearcher(TaxiPark taxiPark) {
        this.listOfCars = taxiPark.getListOfCars();
    }

    public void init(){
        List<Car> filteredListOfCars = new ArrayList<>(listOfCars);
        Scanner sc = new Scanner(System.in);
        String isContinue = "yes";

        do {
            System.out.println("Input filter criteria: ");
            switch (sc.next()){
                case ("model"):
                    System.out.println("Input model: ");
                    filteredListOfCars =  searchCarsByModel(sc.next(), filteredListOfCars);
                    System.out.println(filteredListOfCars);
                    break;
                case ("make"):
                    System.out.println("Input make: ");
                    filteredListOfCars =  searchCarsByMake(sc.next(), filteredListOfCars);
                    System.out.println(filteredListOfCars);
                    break;
            }
            System.out.println("Do y want to continue? (yes/no)");
            isContinue = sc.next();
        }

        while (isContinue.equals("yes"));

        System.out.println(filteredListOfCars);



    }

    public List<Car> getListOfCars() {
        return listOfCars;
    }

    public List<Car> searchCarsByModel(String model, List<Car> listOfCars) {
        List<Car> filteredListOfCars = new ArrayList<>();
        for (int i = 0; i < listOfCars.size(); i++) {
            if (listOfCars.get(i).getModel().contains(model)){
                filteredListOfCars.add(listOfCars.get(i));
            }
        }
        return filteredListOfCars;
    }


    public List<Car> searchCarsByMake(String make, List<Car> listOfCars) {
        List<Car> filteredListOfCars = new ArrayList<>();
        for (int i = 0; i < listOfCars.size(); i++) {
            if (listOfCars.get(i).getMake().contains(make)){
                filteredListOfCars.add(listOfCars.get(i));
            }
        }
        return filteredListOfCars;
    }


    public List<Car> searchCarsByFuelConsumption(double startFuelConsumption, double finishFuelConsumption, List<Car> listOfCars) {
        List<Car> filteredListOfCars = new ArrayList<>();
        for (int i = 0; i < listOfCars.size(); i++) {
            if (listOfCars.get(i).getFuelConsumption() >= startFuelConsumption &&
                    listOfCars.get(i).getFuelConsumption() <= finishFuelConsumption){
                filteredListOfCars.add(listOfCars.get(i));
            }
        }
        return filteredListOfCars;
    }


    public List<Car> searchCarsByCountOfSeatingPositions(int startCountOfSeatingPositions,int finishCountOfSeatingPositions, List<Car> listOfCars) {
        List<Car> filteredListOfCars = new ArrayList<>();
        for (int i = 0; i < listOfCars.size(); i++) {
            if (listOfCars.get(i).getCountOfSeatingPositions() >= startCountOfSeatingPositions &&
                    listOfCars.get(i).getCountOfSeatingPositions() <= finishCountOfSeatingPositions){
                filteredListOfCars.add(listOfCars.get(i));
            }
        }
        return filteredListOfCars;
    }


    public List<Car> searchCarsByCost(double startCost, double finishCost, List<Car> listOfCars) {
        List<Car> filteredListOfCars = new ArrayList<>();
        for (int i = 0; i < listOfCars.size(); i++) {
            if (listOfCars.get(i).getCost() >= startCost &&
                    listOfCars.get(i).getCost() <= finishCost){
                filteredListOfCars.add(listOfCars.get(i));
            }
        }
        return filteredListOfCars;
    }


    public List<Car> searchCarsByYearOfIssue(int startYearOfIssue, int finishYearOfIssue,  List<Car> listOfCars) {
        List<Car> filteredListOfCars = new ArrayList<>();
        for (int i = 0; i < listOfCars.size(); i++) {
            if (listOfCars.get(i).getYearOfIssue() >= startYearOfIssue &&
                    listOfCars.get(i).getYearOfIssue() <= finishYearOfIssue){
                filteredListOfCars.add(listOfCars.get(i));
            }
        }
        return filteredListOfCars;
    }


    public List<Car> searchCarsByType(String type, List<Car> listOfCars) {
        List<Car> filteredListOfCars = new ArrayList<>();
        for (int i = 0; i < listOfCars.size(); i++) {
            if (listOfCars.get(i).getType().contains(type)){
                filteredListOfCars.add(listOfCars.get(i));
            }
        }
        return filteredListOfCars;
    }

}
