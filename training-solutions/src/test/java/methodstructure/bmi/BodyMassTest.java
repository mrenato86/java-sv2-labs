package methodstructure.bmi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassTest {

    BodyMass bmNormal = new BodyMass(75, 1.8);
    BodyMass bmUnder = new BodyMass(55, 1.9);
    BodyMass bmOver = new BodyMass(100, 1.7);

    @Test
    void testCreate() {
        BodyMass bm = new BodyMass(75, 1.8);

        assertEquals(75, bm.getWeight());
        assertEquals(1.8, bm.getHeight());
    }

    @Test
    void testGetBodyMassIndex() {
        assertEquals(23.14, bmNormal.getBodyMassIndex(), 0.01);
    }

    @Test
    void testGetBody() {
        assertEquals(BmiCategory.NORMAL, bmNormal.getBody());
        assertEquals(BmiCategory.UNDERWEIGHT, bmUnder.getBody());
        assertEquals(BmiCategory.OVERWEIGHT, bmOver.getBody());
    }

    @Test
    void testIsThinnerThan() {
        assertFalse(bmNormal.isThinnerThan(bmUnder));
        assertTrue(bmUnder.isThinnerThan(bmNormal));
        assertFalse(bmNormal.isThinnerThan(bmNormal));
    }

}