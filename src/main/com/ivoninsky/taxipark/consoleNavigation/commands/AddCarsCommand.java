package com.ivoninsky.taxipark.consoleNavigation.commands;

import com.ivoninsky.taxipark.cars.Bus;
import com.ivoninsky.taxipark.cars.Car;
import com.ivoninsky.taxipark.cars.Minivan;
import com.ivoninsky.taxipark.cars.Sedan;
import com.ivoninsky.taxipark.interfaces.TaxiPark;
import com.ivoninsky.taxipark.json.JSONReader;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddCarsCommand implements Command {

    @Override
    public void execute(TaxiPark taxiPark) {
        Scanner sc = new Scanner(System.in);
        JSONReader jsonReader = new JSONReader();
        System.out.println("Input file name: ");
        try {
            jsonReader.addCarsFromFileToTaxiPark(sc.next(), taxiPark);
            System.out.println("Cars added to taxi park successfully");
        }
        catch (FileNotFoundException | StringIndexOutOfBoundsException e) {
            System.out.println("File not found! " +
                    "Input \"yes\" to add car manualy and \"any key\" for exit");
            String isManuallyInputCars = sc.next();
            while (!isManuallyInputCars.equals("yes") && !isManuallyInputCars.equals("no")){
                System.out.println("Input yes or no!");
                isManuallyInputCars = sc.next();
            }
            if (isManuallyInputCars.equals("yes")){
                String isContinue;
                do{
                    taxiPark.addCarToPark(manualyCreateCar());
                    System.out.println("Input \"yes\" to add one more car and \"any symbol\" to exit");
                    isContinue = sc.next();
                }
                while (isContinue.equals("yes"));
            }
        }
    }

    private Car manualyCreateCar(){
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(System.in);
        boolean isReinput = true;

        System.out.println("Input car model: ");
        String model = sc.next();
        System.out.println("Input car make: ");
        String make = sc.next();

        double fuelConsumption = 0;

        while (isReinput){
            try{
                System.out.println("Input car fuel consumption: ");
                String s = sc.next();
                fuelConsumption = Double.parseDouble(s);
                isReinput = false;
            }
            catch (NumberFormatException e){
                System.out.println("Incorrect car fuel consumption, please input again");
            }
        }
        int countOfSeatingPositions = 0;
        isReinput = true;
        while (isReinput){
            try{
                System.out.println("Input count of seating positions in car: ");
                String s = sc.next();
                countOfSeatingPositions = Integer.parseInt(s);
                isReinput = false;
            }
            catch (NumberFormatException e){
                System.out.println("Incorrect count of seating positions, please input again");
            }
        }
        isReinput = true;
        double cost = 0;
        while (isReinput){
            try{
                System.out.println("Input car cost: ");
                String s = sc.next();
                cost = Double.parseDouble(s);
                isReinput = false;
            }
            catch (NumberFormatException e){
                System.out.println("Incorrect cost, please input again");
            }
        }
        int yearOfIssue = 0;
        isReinput = true;
        while (isReinput){
            try{
                System.out.println("Input car year of issue: ");
                String s = sc.next();
                yearOfIssue = Integer.parseInt(s);
                isReinput = false;
            }
            catch (NumberFormatException e){
                System.out.println("Incorrect year of issue, please input again");
            }
        }
        System.out.println("Input car type (Sedan/Minivan/Bus): ");
        String type = sc.next();
        Car car = null;
        while (!type.equals("Sedan") && !type.equals("Minivan") && !type.equals("Bus")){
            System.out.println("Incorrect type, please input again (Sedan/Minivan/Bus): ");
            type = sc.next();
        }
        if(type.equals("Sedan")){
            car = new Sedan(model, make, fuelConsumption, countOfSeatingPositions, cost, yearOfIssue, type);
        }
        else if (type.equals("Minivan")){
            car = new Minivan(model, make, fuelConsumption, countOfSeatingPositions, cost, yearOfIssue, type);
        }
        else if (type.equals("Bus")){
            car = new Bus(model, make, fuelConsumption, countOfSeatingPositions, cost, yearOfIssue, type);
        }
        if (car != null){
            System.out.printf("Added %s%n", car);
        }
        sc.close();
        return car;
    }
}
