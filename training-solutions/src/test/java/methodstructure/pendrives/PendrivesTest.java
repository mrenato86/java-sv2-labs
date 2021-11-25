package methodstructure.pendrives;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class PendrivesTest {

    List<Pendrive> pendriveList = List.of(
            new Pendrive("Kingston", 64, 3500),
            new Pendrive("Adata", 32, 2000),
            new Pendrive("Sandisk", 64, 3000),
            new Pendrive("Samsung", 32, 2500)
    );
    Pendrives pendrives = new Pendrives();

    @Test
    void testGetBest() {
        assertSame(pendriveList.get(2), pendrives.getBest(pendriveList));
    }

    @Test
    void testGetCheapest() {
        assertSame(pendriveList.get(1), pendrives.getCheapest(pendriveList));
    }

    @Test
    void risePriceWhereCapacity() {
        pendrives.risePriceWhereCapacity(pendriveList, 10, 32);

        assertEquals(3500, pendriveList.get(0).getPrice());
        assertEquals(2200, pendriveList.get(1).getPrice());
        assertEquals(2750, pendriveList.get(3).getPrice());
    }
}