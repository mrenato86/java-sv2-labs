package methodpass.troopers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeadQuarterTest {

    HeadQuarter headQuarter;
    Trooper johnTrooper;
    Trooper jakeTrooper;

    @BeforeEach
    void init() {
        headQuarter = new HeadQuarter();
        johnTrooper = new Trooper("John Doe" );
        jakeTrooper = new Trooper("Jake Doe" );
        headQuarter.addTrooper(johnTrooper);
        headQuarter.addTrooper(jakeTrooper);
    }

    @Test
    void testAddTrooper() {
        Trooper trooper = new Trooper("New Trooper" );
        headQuarter.addTrooper(trooper);

        assertEquals(3, headQuarter.getTroopers().size());
        assertEquals("New Trooper", headQuarter.getTroopers().get(2).getName());
    }

    @Test
    void testMoveTrooperByName() {
        headQuarter.moveTrooperByName("Jake Doe", new Position(4, 7));

        assertEquals(4, jakeTrooper.getPosition().getPosX(), 0.000001);
        assertEquals(7, jakeTrooper.getPosition().getPosY(), 0.000001);

        assertEquals(0, johnTrooper.getPosition().getPosX(), 0.000001);
        assertEquals(0, johnTrooper.getPosition().getPosY(), 0.000001);
    }

    @Test
    void testMoveClosestTrooper() {
        johnTrooper.changePosition(new Position(8, 2));
        jakeTrooper.changePosition(new Position(-2, 5));

        Position target = new Position(10, -4);

        headQuarter.moveClosestTrooper(target);

        assertEquals(10, johnTrooper.getPosition().getPosX(), 0.000001);
        assertEquals(-4, johnTrooper.getPosition().getPosY(), 0.000001);

        assertEquals(-2, jakeTrooper.getPosition().getPosX(), 0.000001);
        assertEquals(5, jakeTrooper.getPosition().getPosY(), 0.000001);
    }

}