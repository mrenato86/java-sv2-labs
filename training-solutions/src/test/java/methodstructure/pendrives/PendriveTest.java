package methodstructure.pendrives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PendriveTest {

    Pendrive pendrive = new Pendrive("Kingston", 32, 3500);

    @Test
    void testCreate() {
        Pendrive pendrive = new Pendrive("Kingston", 32, 3500);

        assertEquals("Kingston", pendrive.getName());
        assertEquals(32, pendrive.getCapacity());
        assertEquals(3500, pendrive.getPrice());
    }

    @Test
    void testRisePrice() {
        pendrive.risePrice(10);
        assertEquals(3850, pendrive.getPrice());
    }

    @Test
    void testComparePricePerCapacity() {
        Pendrive betterPriceCapacity = new Pendrive("Sandisk", 64, 6000);

        assertEquals(1, pendrive.comparePricePerCapacity(betterPriceCapacity));
        assertEquals(-1, betterPriceCapacity.comparePricePerCapacity(pendrive));
        assertEquals(0, pendrive.comparePricePerCapacity(pendrive));
    }

    @Test
    void testIsCheaperThan() {
        Pendrive cheaper = new Pendrive("Adata", 32, 3000);

        assertTrue(cheaper.isCheaperThan(pendrive));
        assertFalse(pendrive.isCheaperThan(cheaper));
    }
}