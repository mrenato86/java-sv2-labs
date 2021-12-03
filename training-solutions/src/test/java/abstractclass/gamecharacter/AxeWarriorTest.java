package abstractclass.gamecharacter;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AxeWarriorTest {

    @Test
    void testCreate() {
        Random random = new Random(123);
        Character character = new AxeWarrior(new Point(5, 10), random);

        assertEquals(100, character.getHitPoint());
        assertTrue(character.isAlive());
        assertEquals(5L, character.getPosition().getX());
        assertEquals(10L, character.getPosition().getY());
    }

    @Test
    void testKill() {
        Random random = new Random(123);
        Character offender = new AxeWarrior(new Point(0, 0), random);
        Character defender = new AxeWarrior(new Point(1, 0), random);
        while (defender.getHitPoint() > 0) {
            offender.secondaryAttack(defender);
        }

        assertTrue(defender.getHitPoint() <= 0);
        assertFalse(defender.isAlive());
    }

    @Test
    void testSecondaryAttack() {
        Random random = new Random(123);
        Character offender = new AxeWarrior(new Point(0, 0), random);
        Character defender = new AxeWarrior(new Point(1, 0), random);
        offender.secondaryAttack(defender);

        assertEquals(100, offender.getHitPoint());
        assertTrue(defender.getHitPoint() >= 80);
    }

}