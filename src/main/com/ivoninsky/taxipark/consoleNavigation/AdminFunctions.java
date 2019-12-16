package com.ivoninsky.taxipark.consoleNavigation;

import com.ivoninsky.taxipark.cars.Bus;
import com.ivoninsky.taxipark.cars.Car;
import com.ivoninsky.taxipark.cars.Minivan;
import com.ivoninsky.taxipark.cars.Sedan;
import com.ivoninsky.taxipark.interfaces.TaxiPark;
import com.ivoninsky.taxipark.json.JSONReader;
import com.ivoninsky.taxipark.taxiparks.UberCarSearcher;
import com.ivoninsky.taxipark.validators.FileNameValidator;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class AdminFunctions {
    TaxiPark taxiPark;
    Scanner sc = new Scanner(System.in);
    JSONReader jsonReader = new JSONReader();

    public AdminFunctions(TaxiPark taxiPark){
        this.taxiPark = taxiPark;
    }

    public void adminFunctionality(){
        sc = new Scanner(System.in);
        String numberOfFunction;
        do {
            System.out.println("\n" + "Input number of function: ");
            System.out.println("1. Add cars to taxi park from file" + "\n" +
                    "2. Get cars" + "\n" +
                    "3. Get cost of cars" + "\n" +
                    "4. Order cars by fuel consumption" + "\n" +
                    "5. Search car by criteria" + "\n" +
                    "6. Add cars to file" + "\n" +
                    "Input \"~\" for exit");
            numberOfFunction = sc.next();
            switch (numberOfFunction){
                case("1"):
                    System.out.println("Input file name: ");
                    try {
                        jsonReader.addCarsFromFileToTaxiPark(sc.next(), taxiPark);
                    }
                    catch (FileNotFoundException | StringIndexOutOfBoundsException e) {
                        System.out.println("File not found! " +
                                "Input \"yes\" to add car manualy and \"no\" for exit");
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
                        else if (isManuallyInputCars.equals("no")){
                            break;
                        }
                    }
                    break;
                case("2"):
                    printListOfCars(taxiPark.getListOfCars());
                    break;
                case ("3"):
                    System.out.println("Cost of cars: $" + taxiPark.getCostOfCars());
                    break;
                case ("4"):
                    taxiPark.orderCarByFuelConsumption();
                    break;
                case ("5"):
                    UberCarSearcher uberCarSearcher = new UberCarSearcher(taxiPark);
                    uberCarSearcher.start();
                    break;
                case("6"):
                    System.out.println("Input filename like \"test.json\": ");
                    String fileName = sc.next();
                    FileNameValidator fileNameValidator = new FileNameValidator();
                    while (!fileNameValidator.validate(fileName)){
                        System.out.println("file name is incorrect, please input name like \"test.json\": ");
                        fileName = sc.next();
                    }
                    taxiPark.writeCarsToJSON(fileName);
                    break;
                case ("~"):
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Input correct number of function");

            }
        }
        while (!numberOfFunction.equals("~"));
        sc.close();
    }

    private void printListOfCars(List<Car> listOfCars){
        if (listOfCars.size() != 0){
            for (int i = 0; i < listOfCars.size(); i++) {
                System.out.println(i+1 + ". " + listOfCars.get(i));
            }
        }
        else {
            System.out.println("No added cars to taxi park");
        }
    }

    private Car manualyCreateCar(){
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
