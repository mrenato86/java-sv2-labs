package dynamictypes.publictransport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PublicTransportTest {

    @Test
    void testPublicVehicles() {
        PublicVehicle bus = new Bus(24, 20.4, "Ferrari");
        PublicVehicle tram = new Tram(2, 32.3, 4);
        PublicVehicle metro = new Metro(4, 78.5, 10);

        PublicTransport publicTransport = new PublicTransport();
        publicTransport.addVehicle(bus);
        publicTransport.addVehicle(tram);
        publicTransport.addVehicle(metro);

        assertEquals(3, publicTransport.getVehicles().size());
    }

}