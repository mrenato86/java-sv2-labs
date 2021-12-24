package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {

    private List<Ship> ships = new ArrayList<>();

    private int waitingPeople;
    private int waitingCargo;

    public void addShip(Ship newShip) {
        ships.add(newShip);
    }

    public void loadShip(int passengers, int cargoWeight) {
        int remainingPassengers = passengers;
        int remainingCargo = cargoWeight;
        for (Ship ship : ships) {
            if (ship instanceof CanCarryPassengers) {
                remainingPassengers = ((CanCarryPassengers) ship).loadPassenger(remainingPassengers);
            }
            if (ship instanceof CanCarryGoods) {
                remainingCargo = ((CanCarryGoods) ship).loadCargo(remainingCargo);
            }
        }
        waitingPeople = remainingPassengers;
        waitingCargo = remainingCargo;
    }

    public int getWaitingPeople() {
        return waitingPeople;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }
}
