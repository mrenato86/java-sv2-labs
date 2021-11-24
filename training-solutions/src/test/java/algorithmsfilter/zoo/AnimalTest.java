package algorithmsfilter.zoo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalTest {
    @Test
    void testCreate() {
        Animal animal = new Animal("giraffe", 4);

        assertEquals("giraffe", animal.getName());
        assertEquals(4, animal.getNumberOfLegs());
    }

}