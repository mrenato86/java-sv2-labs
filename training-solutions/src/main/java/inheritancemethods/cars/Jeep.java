package inheritancemethods.cars;

public class Jeep extends Car {

    private double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        if (extraFuel > extraCapacity) {
            throw new IllegalArgumentException("Extra capacity is less than extra fuel!");
        }
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    public double getExtraCapacity() {
        return extraCapacity;
    }

    public double getExtraFuel() {
        return extraFuel;
    }

    private boolean isEnoughFuel(int km) {
        return km * getFuelRate() / 100 <= getFuel() + extraFuel;
    }

    @Override
    public void drive(int km) {
        if (!isEnoughFuel(km)) {
            throw new RuntimeException("Not enough fuel available!");
        }
        double neededFuel = km * getFuelRate() / 100;
        extraFuel -= neededFuel;
        if (extraFuel < 0) {
            modifyFuelAmount(extraFuel);
            extraFuel = 0;
        }
    }

    @Override
    public double calculateRefillAmount() {
        return (extraCapacity + getTankCapacity()) - (getFuel() + extraFuel);
    }

}
