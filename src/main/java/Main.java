public class Main {
    public static void main(String[] args) {
        TaxiPark taxiPark = new Uber();
        JSONReader jsonReader = new JSONReader();
        jsonReader.addCarsFromFileToTaxiPark("cars.json", taxiPark);

        taxiPark.writeCarsToJSON("test.json");




    }
}
