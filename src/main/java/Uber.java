import java.util.HashMap;
import java.util.Map;

public class Uber implements TaxiPark {
    private Map<Car, Integer> cars = new HashMap<>();
    private double costOfCars;

    @Override
    public void addCarToPark(Car car) {
        Integer countOfCars = cars.get(car);
        if (countOfCars == null){
            countOfCars = 0;
        }
        cars.put(car, countOfCars + 1);
        costOfCars += car.getCost();
    }

    public Map<Car, Integer> getCars() {
        return new HashMap<>(cars);
    }

    @Override
    public double getCostOfCars() {
        return new Double(costOfCars);
    }

    @Override
    public void writeCarsToJSON(String pathToFile) {
        JSONWriter jsonWriter = new JSONWriter();
        jsonWriter.writeToJSON(pathToFile, getCars());
    }

    @Override
    public int calculateOrderCost() {
        return 0;
    }

    @Override
    public Car getOfferACar() {
        return null;
    }

    @Override
    public Map<Car, Integer> orderCarByFuelConsumption() {
        return null;
    }

    @Override
    public Map<Car, Integer> getTopExpensiveCars() {
        return null;
    }
}
