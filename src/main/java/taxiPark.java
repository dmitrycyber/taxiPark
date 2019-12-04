import java.util.Map;

public interface taxiPark {
    void addCarToPark();
    double getCostOfCars();
    int calculateOrderCost();
    Car getOfferACar();
    Map<Car, Integer> orderCarByFuelConsumption();
    Map<Car, Integer> getTopExpensiveCars();

}
