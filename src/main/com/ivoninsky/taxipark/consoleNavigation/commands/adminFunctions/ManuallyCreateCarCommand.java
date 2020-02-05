package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions;

import com.ivoninsky.taxipark.cars.Bus;
import com.ivoninsky.taxipark.cars.Car;
import com.ivoninsky.taxipark.cars.Minivan;
import com.ivoninsky.taxipark.cars.Sedan;

import java.util.Scanner;

public class ManuallyCreateCarCommand {
    private String model;
    private String make;
    private double fuelConsumption;
    private int countOfSeatingPositions;
    private double cost;
    private int yearOfIssue;
    private String type;
    private Scanner sc;
    private Car car;
    CarTypeContainer carTypeContainer;

    public ManuallyCreateCarCommand() {
        sc = new Scanner(System.in);
    }

    public Car createCar() {
        model = validateModel();
        make = validateMake();
        fuelConsumption = validateFuelConsumption();
        countOfSeatingPositions = validateCountOfSeatingPositions();
        cost = validateCarCost();
        yearOfIssue = validateYearOfIssue();
        type = validateCarType();
        carTypeContainer = new CarTypeContainer(model, make, fuelConsumption, countOfSeatingPositions, cost, yearOfIssue, type);
        car = carTypeContainer.getCarMap().get(type);
        return car;
    }


    private String validateModel() {
        System.out.println("Input car model: ");
        return sc.next();
    }

    private String validateMake() {
        System.out.println("Input car make: ");
        return sc.next();
    }

    private double validateFuelConsumption() {
        boolean isReinput = true;
        double fuelConsumption = 0;

        while (isReinput) {
            try {
                System.out.println("Input car fuel consumption: ");
                String s = sc.next();
                fuelConsumption = Double.parseDouble(s);
                isReinput = false;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect car fuel consumption, please input again");
            }
        }
        return fuelConsumption;
    }

    private int validateCountOfSeatingPositions() {
        boolean isReinput = true;
        int countOfSeatingPositions = 0;
        while (isReinput) {
            try {
                System.out.println("Input count of seating positions in car: ");
                String s = sc.next();
                countOfSeatingPositions = Integer.parseInt(s);
                isReinput = false;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect count of seating positions, please input again");
            }
        }
        return countOfSeatingPositions;
    }

    private double validateCarCost() {
        boolean isReinput = true;
        double cost = 0;
        while (isReinput) {
            try {
                System.out.println("Input car cost: ");
                String s = sc.next();
                cost = Double.parseDouble(s);
                isReinput = false;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect cost, please input again");
            }
        }
        return cost;
    }

    private int validateYearOfIssue() {
        boolean isReinput = true;
        int yearOfIssue = 0;
        while (isReinput) {
            try {
                System.out.println("Input car year of issue: ");
                String s = sc.next();
                yearOfIssue = Integer.parseInt(s);
                isReinput = false;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect year of issue, please input again");
            }
        }
        return yearOfIssue;
    }

    private String validateCarType() {
        System.out.println("Input car type (Sedan/Minivan/Bus): ");
        String type = sc.next();
        while (!type.equals("Sedan") && !type.equals("Minivan") && !type.equals("Bus")) {
            System.out.println("Incorrect type, please input again (Sedan/Minivan/Bus): ");
            type = sc.next();
        }
        return type;
    }
}
