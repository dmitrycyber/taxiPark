package com.ivoninsky.taxipark.json;

import com.ivoninsky.taxipark.cars.Car;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class JSONWriter {
    public void writeToJSON(String pathToFile, Map<Car, Integer> cars){
        try (FileWriter fileWriter = new FileWriter(pathToFile, true); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            String start = "[";
            String finish = "]";
            bufferedWriter.write(start + "\n");
            Integer count = 0;

            for (Map.Entry<Car, Integer> entry : cars.entrySet()) {
                bufferedWriter.write("\t" + "{\n");
                bufferedWriter.write("\t\t" + "\"model\":" + "\"" + entry.getKey().getModel() + "\"" + ",\n");
                bufferedWriter.write("\t\t" + "\"make\":" + "\"" + entry.getKey().getMake() + "\"" + ",\n");
                bufferedWriter.write("\t\t" + "\"fuelConsumption\":" + "\"" + entry.getKey().getFuelConsumption() + "\"" + ",\n");
                bufferedWriter.write("\t\t" + "\"countOfSeatingPositions\":" + "\"" + entry.getKey().getCountOfSeatingPositions() + "\"" + ",\n");
                bufferedWriter.write("\t\t" + "\"cost\":" + "\"" + entry.getKey().getCost() + "\"" + ",\n");
                bufferedWriter.write("\t\t" + "\"yearOfIssue\":" + "\"" + entry.getKey().getYearOfIssue() + "\"" + ",\n");
                bufferedWriter.write("\t\t" + "\"type\":" + "\"" + entry.getKey().getType() + "\"" + "\n");
                count ++;
                if(count < cars.size()){
                    bufferedWriter.write("\t" + "},\n");
                }
                else {
                    bufferedWriter.write("\t" + "}\n");
                }
            }
            bufferedWriter.write(finish);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
