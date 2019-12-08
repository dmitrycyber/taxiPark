import java.util.Map;

public interface TaxiPark {
    void addCarToPark(Car car);
    Map<Car, Integer> getCars();
    double getCostOfCars();
    void writeCarsToJSON(String pathToFile);
    int calculateOrderCost();
    Car getOfferACar();
    Map<Car, Integer> orderCarByFuelConsumption();
    Map<Car, Integer> getTopExpensiveCars();

}
