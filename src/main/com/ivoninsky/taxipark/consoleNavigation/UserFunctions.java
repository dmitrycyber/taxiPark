package com.ivoninsky.taxipark.consoleNavigation;

import com.ivoninsky.taxipark.cars.Car;
import com.ivoninsky.taxipark.interfaces.TaxiPark;
import com.ivoninsky.taxipark.taxiparks.Offer;

import java.util.List;
import java.util.Scanner;

public class UserFunctions {
    private TaxiPark taxiPark;
    private Scanner sc;
    private Car car;
    private  int countOfKilometers = 0;

    public UserFunctions(TaxiPark taxiPark){
        this.taxiPark = taxiPark;
    }

    public void userFunctionality(){
        sc = new Scanner(System.in);
        String numberOfFunction;
        do{
            System.out.println("\n" + "Input number of function: ");
            System.out.println("1. Input count of kilometers" + "\n" +
                    "2. Select class of the trip" + "\n" +
                    "3. Make an order" + "\n" +
                    "Input \"~\" for exit");
            numberOfFunction = sc.next();
            switch (numberOfFunction){
                case("1"):
                    System.out.println("Input count of kilometers: ");
                    String s = sc.next();
                    countOfKilometers = Integer.parseInt(s);
                    break;
                case("2"):
                    if (countOfKilometers == 0){
                        System.out.println("Сount of kilometers not indicated");
                        break;
                    }
                    System.out.println("Input class of the trip (Econom/Comfort/Business): ");

                    String classOfTrip = sc.next();
                    selectClassOfTrip(classOfTrip);

                    System.out.println("Cost of trip" + taxiPark.calculateTotalCostOrder(car, countOfKilometers));
                    break;
                case("3"):
                    System.out.println("Type \"confirm\" to confirm an order" +
                            "or type \"exit\" to select new car");
                    if (car == null){
                        System.out.println("No car selected");
                        break;
                    }
                    else if (countOfKilometers == 0){
                        System.out.println("Сount of kilometers not indicated");
                        break;
                    }
                    getOffer();
                    break;
                case("~"):
                    System.out.println("Good luck");
                    break;
                default:
                    System.out.println("Input correct number of function");
            }
        }
        while (!numberOfFunction.equals("~"));
    }

    private void selectClassOfTrip(String classOfTrip) {
        if (classOfTrip.equals("Econom")){
            List<Car> listOfCarsEconomClass = taxiPark.getEconomClass();
            taxiPark.printListOfCars(listOfCarsEconomClass);
            selectCar(listOfCarsEconomClass);
        }
        else if (classOfTrip.equals("Comfort")){
            List<Car> listOfCarsComfortClass = taxiPark.getComfortClass();
            taxiPark.printListOfCars(listOfCarsComfortClass);
            selectCar(listOfCarsComfortClass);
        }
        else if (classOfTrip.equals("Business")){
            List<Car> listOfCarsBusinessClass = taxiPark.getBusinessClass();
            taxiPark.printListOfCars(listOfCarsBusinessClass);
            selectCar(listOfCarsBusinessClass);
        }
    }

    private void selectCar(List<Car> listOfCars){
        System.out.println("Please, input number of car: ");
        String s = sc.next();
        int numberOfCar = Integer.parseInt(s);
        car = listOfCars.get(numberOfCar-1);
    }

    private Offer getOffer() {
        Offer offer = new Offer();


        return null;

    }
}
