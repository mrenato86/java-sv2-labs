package stringbuilder.airport;

import java.util.ArrayList;
import java.util.List;

public class Airport {

    private List<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public String getDeletedFlights() {
        StringBuilder sb = new StringBuilder("Deleted flights:");
        for (Flight flight : flights) {
            if (flight.getStatus() == Status.DELETED) {
                sb.append("\n").append(flight.getFlightNumber());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Airport airport = new Airport();
        airport.addFlight(new Flight("B-2351", Status.DELETED));
        airport.addFlight(new Flight("P-626783", Status.ACTIVE));
        airport.addFlight(new Flight("F-24671", Status.ACTIVE));
        airport.addFlight(new Flight("N-312561", Status.DELETED));
        airport.addFlight(new Flight("S-35", Status.DELETED));

        System.out.println(airport.getDeletedFlights());
    }

}
