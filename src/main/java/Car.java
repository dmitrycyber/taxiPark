import java.util.Objects;

public abstract class Car implements Comparable<Car> {
    private String model;
    private String make;
    private double fuelConsumption;
    private int countOfSeatingPositions;
    private String type;
    private double cost;
    private int yearOfIssue;

    public Car(String model, String make, double fuelConsumption, int countOfSeatingPositions, String type) {
        this.model = model;
        this.make = make;
        this.fuelConsumption = fuelConsumption;
        this.countOfSeatingPositions = countOfSeatingPositions;
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getCountOfSeatingPositions() {
        return countOfSeatingPositions;
    }

    public void setCountOfSeatingPositions(int countOfSeatingPositions) {
        this.countOfSeatingPositions = countOfSeatingPositions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.fuelConsumption, fuelConsumption) == 0 &&
                countOfSeatingPositions == car.countOfSeatingPositions &&
                model.equals(car.model) &&
                make.equals(car.make);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, make, fuelConsumption, countOfSeatingPositions);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", fuelConsumption=" + fuelConsumption +
                ", countOfSeatingPositions=" + countOfSeatingPositions +
                '}';
    }

    @Override
    public int compareTo(Car car){
        return (int) (this.fuelConsumption - car.getFuelConsumption());
    }
}
