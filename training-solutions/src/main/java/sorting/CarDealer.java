package sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarDealer {

    private final List<Car> cars;

    public CarDealer(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public List<Car> getCarsOrderedByConstruction() {
        return getOrderedCarsBy(new CarConstructionComparator());
    }

    public List<Car> getCarsOrderedByPrice() {
        return getOrderedCarsBy(new CarPriceComparator());
    }

    private List<Car> getOrderedCarsBy(Comparator<Car> comparator) {
        List<Car> orderedCars = new ArrayList<>(cars);
        orderedCars.sort(comparator);
        return orderedCars;
    }
}
