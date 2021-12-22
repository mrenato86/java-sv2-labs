package interfacedefaultmethods.seats;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeatTest {

    @Test
    void testGetNumberOfSeatsCar() {
        Car car = new Car("Audi", 4);
        assertEquals(4, car.getNumberOfSeats());
    }

    @Test
    void testGetNumberOfSeatsFamilyCar() {
        FamilyCar familyCar = new FamilyCar();
        assertEquals(5, familyCar.getNumberOfSeats());
    }

    @Test
    void testGetNumberOfSeatsSportsCar() {
        SportsCar sportsCar = new SportsCar();
        assertEquals(2, sportsCar.getNumberOfSeats());
    }
}