package interfaceextends.robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class C3POTest {

    @Test
    void testMoveTo() {
        Point initialPoint = new Point(0, 0, 0);
        C3PO c3PO = new C3PO(initialPoint);
        Point targetPoint = new Point(12L, 23L, 0);

        c3PO.moveTo(targetPoint);

        assertEquals(targetPoint, c3PO.getPosition());
        assertEquals(targetPoint.getX(), c3PO.getPath().get(0).getX());
        assertEquals(targetPoint.getY(), c3PO.getPath().get(0).getY());
        assertEquals(targetPoint.getZ(), c3PO.getPath().get(0).getZ());
    }

    @Test
    void testFastMoveTo() {
        Point initialPoint = new Point(0, 0, 0);
        C3PO c3PO = new C3PO(initialPoint);
        Point targetPoint = new Point(12L, 23L, 0);

        c3PO.fastMoveTo(targetPoint);

        assertEquals(targetPoint, c3PO.getPosition());
        assertEquals(targetPoint.getX(), c3PO.getPath().get(0).getX());
        assertEquals(targetPoint.getY(), c3PO.getPath().get(0).getY());
        assertEquals(targetPoint.getZ(), c3PO.getPath().get(0).getZ());
    }

    @Test
    void testRotate() {
        Point initialPoint = new Point(0, 0, 0);
        C3PO c3PO = new C3PO(initialPoint);
        final int angle = 12;

        c3PO.rotate(angle);

        assertEquals(angle, c3PO.getAngle());
    }

}