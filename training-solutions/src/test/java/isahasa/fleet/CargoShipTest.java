package isahasa.fleet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CargoShipTest {

    CargoShip cargoShip = new CargoShip(100);

    @Test
    void testLoad() {
        assertEquals(0, cargoShip.getCargoWeight());

        assertEquals(0, cargoShip.loadCargo(56));
        assertEquals(56, cargoShip.getCargoWeight());
    }

    @Test
    void testLoadTooMuch() {
        assertEquals(0, cargoShip.getCargoWeight());

        assertEquals(11, cargoShip.loadCargo(111));
        assertEquals(100, cargoShip.getCargoWeight());
    }

}