package simplefactory.farm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HorseTest {
    @Test
    public void speak() {
        Horse horse = new Horse();

        assertEquals("nyihaha", horse.speak());
    }

}