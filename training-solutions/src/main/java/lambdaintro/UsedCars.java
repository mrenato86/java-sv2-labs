package lambdaintro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UsedCars {

    private final List<Car> cars;

    public UsedCars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> listCarsByPrice() {
        List<Car> sorted = new ArrayList<>(cars);
        sorted.sort((c1, c2) -> c1.getPrice() - c2.getPrice());
        return sorted;
    }

    public List<Car> listCarsByLengthDesc() {
        List<Car> sorted = new ArrayList<>(cars);
        sorted.sort((c1, c2) -> (Double.compare(c1.getLength(), c2.getLength())));
        Collections.reverse(sorted);
        return sorted;
    }

    public List<Car> listCarsOneBrandByType(String brand) {
        return cars.stream()
                .filter(car -> car.getBrand().equals(brand))
                .sorted((c1, c2) -> c1.getType().compareTo(c2.getType()))
                .collect(Collectors.toList());
    }

}
