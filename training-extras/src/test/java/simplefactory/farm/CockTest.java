package simplefactory.farm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CockTest {

    @Test
    public void speak() {
        Cock cock = new Cock();

        assertEquals("kukuriku", cock.speak());
    }

}