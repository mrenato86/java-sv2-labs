package interfaceextends.robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AstroBoyTest {

    @Test
    void testMoveTo() {
        Point initialPoint = new Point(0, 0, 0);
        AstroBoy astroBoy = new AstroBoy(initialPoint);
        Point targetPoint = new Point(12L, 23L, 0);

        astroBoy.moveTo(targetPoint);

        assertEquals(targetPoint, astroBoy.getPosition());
        assertEquals(1, astroBoy.getPath().size());
        assertEquals(targetPoint.getX(), astroBoy.getPath().get(0).getX());
        assertEquals(targetPoint.getY(), astroBoy.getPath().get(0).getY());
        assertEquals(targetPoint.getZ(), astroBoy.getPath().get(0).getZ());
    }

    @Test
    void testFastMoveTo() {

        Point initialPoint = new Point(0, 0, 0);
        AstroBoy astroBoy = new AstroBoy(initialPoint);
        Point targetPoint = new Point(12L, 23L, 0);

        astroBoy.fastMoveTo(targetPoint);

        assertEquals(targetPoint.getX(), astroBoy.getPosition().getX());
        assertEquals(targetPoint.getY(), astroBoy.getPosition().getY());
        assertEquals(targetPoint.getZ(), astroBoy.getPosition().getZ());

        assertEquals(3, astroBoy.getPath().size());
        assertEquals(initialPoint.getX(), astroBoy.getPath().get(0).getX());
        assertEquals(initialPoint.getY(), astroBoy.getPath().get(0).getY());
        assertEquals(AstroBoy.ALTITUDE, astroBoy.getPath().get(0).getZ());

        assertEquals(targetPoint.getX(), astroBoy.getPath().get(1).getX());
        assertEquals(targetPoint.getY(), astroBoy.getPath().get(1).getY());
        assertEquals(AstroBoy.ALTITUDE, astroBoy.getPath().get(1).getZ());

        assertEquals(targetPoint.getX(), astroBoy.getPath().get(2).getX());
        assertEquals(targetPoint.getY(), astroBoy.getPath().get(2).getY());
        assertEquals(0L, astroBoy.getPath().get(2).getZ());
    }

    @Test
    void testRotate() {
        Point initialPoint = new Point(0, 0, 0);
        AstroBoy astroBoy = new AstroBoy(initialPoint);
        final int angle = 12;

        astroBoy.rotate(angle);

        assertEquals(angle, astroBoy.getAngle());
    }

    @Test
    void testLiftTo() {
        Point initialPoint = new Point(0, 0, 0);
        AstroBoy astroBoy = new AstroBoy(initialPoint);
        final long altitude = 12;

        astroBoy.liftTo(altitude);

        assertEquals(altitude, astroBoy.getAltitude());
    }

}