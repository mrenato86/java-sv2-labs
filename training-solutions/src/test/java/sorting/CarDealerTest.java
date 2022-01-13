package sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarDealerTest {

    List<Car> testCars = new ArrayList<>(List.of(
            new Car("Ferrari", 2005, 9_000_000),
            new Car("Trabant", 1983, 20_000),
            new Car("Suzuki", 2020, 4_000_000),
            new Car("Ford", 2015, 3_000_000),
            new Car("Opel", 1999, 250_000)
    ));
    CarDealer carDealer = new CarDealer(testCars);

    @Test
    void testGetCarsOrderedByConstruction() {
        List<Car> result = carDealer.getCarsOrderedByConstruction();

        assertEquals("Trabant", result.get(0).getBrand());
        assertEquals("Ferrari", result.get(2).getBrand());
        assertEquals("Suzuki", result.get(4).getBrand());
        assertEquals(testCars, carDealer.getCars());
    }

    @Test
    void testGetCarsOrderedByPrice() {
        List<Car> result = carDealer.getCarsOrderedByPrice();

        assertEquals("Trabant", result.get(0).getBrand());
        assertEquals("Ford", result.get(2).getBrand());
        assertEquals("Ferrari", result.get(4).getBrand());
        assertEquals(testCars, carDealer.getCars());
    }

}