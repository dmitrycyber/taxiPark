package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions.searcher;

import com.ivoninsky.taxipark.cars.Car;
import com.ivoninsky.taxipark.interfaces.TaxiPark;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarSearcher {
    private List<Car> listOfCars;



    public CarSearcher(TaxiPark taxiPark) {
        this.listOfCars = taxiPark.getListOfCars();
    }

    public void start() {
        List<Car> filteredListOfCars = new ArrayList<>(listOfCars);
        SearchCommandContainer searchCommandContainer = new SearchCommandContainer(listOfCars);
        Scanner sc = new Scanner(System.in);
        String isContinue;
        String command;

        do {
            System.out.println("Input filter criteria (model/make/fuelConsumption/countOfSeatingPositions/cost/yearOfIssue/type): ");
            command = sc.next();
            SearchCommand searchCommand = searchCommandContainer.getCommandMap().get(command);
            if (searchCommand != null){
                List<Car> filteredList = searchCommand.execute(listOfCars);
                listOfCars = filteredList;
                if (listOfCars.isEmpty()){
                    System.out.println("No Find Cars");

                }
            }
            else {
                System.out.println("Enter valid filter criteria");
            }


//            switch (sc.next()) {
//                case ("model"):
//                    System.out.println("Input model: ");
//                    filteredListOfCars = searchCarsByModel(sc.next(), filteredListOfCars);
//                    printFilteredListOfCars(filteredListOfCars);
//                    break;
//                case ("make"):
//                    System.out.println("Input make: ");
//                    filteredListOfCars = searchCarsByMake(sc.next(), filteredListOfCars);
//                    printFilteredListOfCars(filteredListOfCars);
//                    break;
//                case ("fuelConsumption"):
//                    System.out.println("Input fuelConsumption from: ");
//                    double startFuelConsumption = sc.nextDouble();
//                    System.out.println("Input fuelConsumption to: ");
//                    double finishFuelConsumption = sc.nextDouble();
//                    filteredListOfCars = searchCarsByFuelConsumption(startFuelConsumption, finishFuelConsumption, filteredListOfCars);
//                    printFilteredListOfCars(filteredListOfCars);
//                    break;
//                case ("countOfSeatingPositions"):
//                    System.out.println("Input countOfSeatingPositions from: ");
//                    int startCountOfSeatingPositions = sc.nextInt();
//                    System.out.println("Input countOfSeatingPositions to: ");
//                    int finishCountOfSeatingPositions = sc.nextInt();
//                    filteredListOfCars = searchCarsByCountOfSeatingPositions(startCountOfSeatingPositions, finishCountOfSeatingPositions, filteredListOfCars);
//                    printFilteredListOfCars(filteredListOfCars);
//                    break;
//                case ("cost"):
//                    System.out.println("Input cost from: ");
//                    double startCost = sc.nextDouble();
//                    System.out.println("Input cost to: ");
//                    double finishCost = sc.nextDouble();
//                    filteredListOfCars = searchCarsByCost(startCost, finishCost, filteredListOfCars);
//                    printFilteredListOfCars(filteredListOfCars);
//                    break;
//                case ("type"):
//                    System.out.println("Input type: ");
//                    filteredListOfCars = searchCarsByType(sc.next(), filteredListOfCars);
//                    printFilteredListOfCars(filteredListOfCars);
//                    break;
//                default:
//                    System.out.println("Input type correctly (model/make/fuelConsumption/countOfSeatingPositions/cost/type)");
//            }
            System.out.println("Do y want to continue? (yes/no)");
            isContinue = sc.next();
        }
        while (isContinue.equals("yes"));
    }

    public static List<Car> searchCarsByModel(String model, List<Car> listOfCars) {
        List<Car> filteredListOfCars = new ArrayList<>();
        for (int i = 0; i < listOfCars.size(); i++) {
            if (listOfCars.get(i).getModel().contains(model)) {
                filteredListOfCars.add(listOfCars.get(i));
            }
        }
        return filteredListOfCars;
    }


    public static List<Car> searchCarsByMake(String make, List<Car> listOfCars) {
        List<Car> filteredListOfCars = new ArrayList<>();
        for (int i = 0; i < listOfCars.size(); i++) {
            if (listOfCars.get(i).getMake().contains(make)) {
                filteredListOfCars.add(listOfCars.get(i));
            }
        }
        return filteredListOfCars;
    }


    public static List<Car> searchCarsByFuelConsumption(double startFuelConsumption, double finishFuelConsumption, List<Car> listOfCars) {
        List<Car> filteredListOfCars = new ArrayList<>();
        for (int i = 0; i < listOfCars.size(); i++) {
            if (listOfCars.get(i).getFuelConsumption() >= startFuelConsumption &&
                    listOfCars.get(i).getFuelConsumption() <= finishFuelConsumption) {
                filteredListOfCars.add(listOfCars.get(i));
            }
        }
        return filteredListOfCars;
    }


    public static List<Car> searchCarsByCountOfSeatingPositions(int startCountOfSeatingPositions, int finishCountOfSeatingPositions, List<Car> listOfCars) {
        List<Car> filteredListOfCars = new ArrayList<>();
        for (int i = 0; i < listOfCars.size(); i++) {
            if (listOfCars.get(i).getCountOfSeatingPositions() >= startCountOfSeatingPositions &&
                    listOfCars.get(i).getCountOfSeatingPositions() <= finishCountOfSeatingPositions) {
                filteredListOfCars.add(listOfCars.get(i));
            }
        }
        return filteredListOfCars;
    }


    public static List<Car> searchCarsByCost(double startCost, double finishCost, List<Car> listOfCars) {
        List<Car> filteredListOfCars = new ArrayList<>();
        for (int i = 0; i < listOfCars.size(); i++) {
            if (listOfCars.get(i).getCost() >= startCost &&
                    listOfCars.get(i).getCost() <= finishCost) {
                filteredListOfCars.add(listOfCars.get(i));
            }
        }
        return filteredListOfCars;
    }


    public static List<Car> searchCarsByYearOfIssue(int startYearOfIssue, int finishYearOfIssue, List<Car> listOfCars) {
        List<Car> filteredListOfCars = new ArrayList<>();
        for (int i = 0; i < listOfCars.size(); i++) {
            if (listOfCars.get(i).getYearOfIssue() >= startYearOfIssue &&
                    listOfCars.get(i).getYearOfIssue() <= finishYearOfIssue) {
                filteredListOfCars.add(listOfCars.get(i));
            }
        }
        return filteredListOfCars;
    }


    public static List<Car> searchCarsByType(String type, List<Car> listOfCars) {
        List<Car> filteredListOfCars = new ArrayList<>();
        for (int i = 0; i < listOfCars.size(); i++) {
            if (listOfCars.get(i).getType().contains(type)) {
                filteredListOfCars.add(listOfCars.get(i));
            }
        }
        return filteredListOfCars;
    }

    static void printFilteredListOfCars(List<Car> listOfCars) {
        for (int i = 0; i < listOfCars.size(); i++) {
            System.out.println(i + 1 + ". " + listOfCars.get(i));
        }
        System.out.println();
    }

}
