package simplefactory.farm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrogTest {

    @Test
    public void speak() {
        Frog frog = new Frog();

        assertEquals("brekeke", frog.speak());
    }

}