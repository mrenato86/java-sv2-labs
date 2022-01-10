package nestedclasses.thermo;

import java.util.ArrayList;
import java.util.List;

public class Thermostat {

    private final List<Thermometer> thermometers = new ArrayList<>();
    private final List<String> roomsToHeat = new ArrayList<>();
    private int temperatureLimit = 23;

    public void addThermometer(Thermometer thermometer) {
        thermometer.setThermometerObserver(new ThermometerObserver() {
            @Override
            public void handleTemperatureChange(int temp, String room) {
                if (temp < temperatureLimit) {
                    roomsToHeat.add(room);
                } else {
                    roomsToHeat.remove(room);
                }
            }
        });
        thermometers.add(thermometer);
    }

    public List<String> getRoomsToHeat() {
        return new ArrayList<>(roomsToHeat);
    }

    public List<Thermometer> getThermometers() {
        return new ArrayList<>(thermometers);
    }

    public void setTemperatureLimit(int temperatureLimit) {
        this.temperatureLimit = temperatureLimit;
    }
}
