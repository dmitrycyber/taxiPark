package com.ivoninsky.taxipark.json;

import com.ivoninsky.taxipark.cars.Bus;
import com.ivoninsky.taxipark.cars.Car;
import com.ivoninsky.taxipark.cars.Minivan;
import com.ivoninsky.taxipark.cars.Sedan;
import com.ivoninsky.taxipark.interfaces.TaxiPark;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class JSONReader {

    public void addCarsFromFileToTaxiPark(String pathToFile, TaxiPark taxiPark){
        List<Car> listOfCars = init(pathToFile);
        for (int i = 0; i < listOfCars.size(); i++) {
            taxiPark.addCarToPark(listOfCars.get(i));
        }
    }

    private List<Car> init(String pathToFile){
        String parsedString = readJson(pathToFile);
        String formatedString = getFormatedStringFromJson(parsedString);
        List<Car> listOfCars = getListOfCarsFromFile(formatedString);
        return listOfCars;
    }

    private String readJson(String pathToFile){
        String parsedString = "";
        String line;
        try(FileReader fileReader = new FileReader(pathToFile); BufferedReader rd = new BufferedReader(fileReader)){
            while ((line = rd.readLine()) != null){
                parsedString += line;
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return parsedString;
    }

    private String getFormatedStringFromJson(String parsedString){
        String formatedString;
        String string1 = parsedString.replaceAll("]", "");
        String string2 = string1.replaceAll("\\[", "");
        String string3 = string2.replaceAll(" ", "");
        String string4 = string3.replaceAll("\"", "");

        StringBuffer sb = new StringBuffer(string4);
        sb.delete(0, 1);
        sb.delete(sb.length()-1, sb.length());
        formatedString = sb.toString();
        return formatedString;
    }

    private List<Car> getListOfCarsFromFile(String formatedString){
        String[] carStrings = formatedString.split("},\\{");
        Map<String, String> propertiesOfCar = new HashMap<>();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carStrings.length; i++) {
            String carProperties = carStrings[i];
            String[] carProperty = carProperties.split(",");
            for (int j = 0; j < carProperty.length; j++) {
                String addToMapProperty = carProperty[j];
                String[] finaly = addToMapProperty.split(":");
                propertiesOfCar.put(finaly[0], finaly[1]);
            }
            cars.add(createCarFromMapOfProperties(propertiesOfCar));
            propertiesOfCar.clear();
        }
        return cars;
    }

    private Car createCarFromMapOfProperties(Map<String, String> map){
        Car car = null;
        if(map.get("type").equals("Sedan")){
             car = new Sedan(map.get("model"),
                    map.get("make"),
                    Double.parseDouble(map.get("fuelConsumption")) ,
                    Integer.parseInt(map.get("countOfSeatingPositions")),
                    Double.parseDouble(map.get("cost")),
                    Integer.parseInt(map.get("yearOfIssue")),
                    map.get("type"));
        }
        else if (map.get("type").equals("Minivan")){
            car = new Minivan(map.get("model"),
                    map.get("make"),
                    Double.parseDouble(map.get("fuelConsumption")) ,
                    Integer.parseInt(map.get("countOfSeatingPositions")),
                    Double.parseDouble(map.get("cost")),
                    Integer.parseInt(map.get("yearOfIssue")),
                    map.get("type"));
        }
        else if (map.get("type").equals("Bus")){
            car = new Bus(map.get("model"),
                    map.get("make"),
                    Double.parseDouble(map.get("fuelConsumption")) ,
                    Integer.parseInt(map.get("countOfSeatingPositions")),
                    Double.parseDouble(map.get("cost")),
                    Integer.parseInt(map.get("yearOfIssue")),
                    map.get("type"));
        }
        return car;
    }
}
