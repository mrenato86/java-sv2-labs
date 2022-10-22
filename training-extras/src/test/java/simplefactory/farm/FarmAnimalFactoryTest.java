package simplefactory.farm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FarmAnimalFactoryTest {

    @Test
    public void testCreateWithNull() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new FarmAnimalFactory().create(null));
        assertEquals("Animal type must not be empty!", ex.getMessage());
    }

    @Test
    public void testCreateWithEmpty() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new FarmAnimalFactory().create(""));
        assertEquals("Animal type must not be empty!", ex.getMessage());
    }

    @Test
    public void testCreateWithUnrecognizable() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new FarmAnimalFactory().create("alma"));
        assertEquals("Unrecognizable animal type!", ex.getMessage());
    }

    @Test
    public void testCreateCock() {
        FarmAnimalFactory animalFactory = new FarmAnimalFactory();
        Animal animal = animalFactory.create("cock");

        assertTrue(animal instanceof Cock);
    }

    @Test
    public void testCreateFrog() {
        FarmAnimalFactory animalFactory = new FarmAnimalFactory();
        Animal animal = animalFactory.create("frog");

        assertTrue(animal instanceof Frog);
    }

    @Test
    public void testCreateHorse() {
        FarmAnimalFactory animalFactory = new FarmAnimalFactory();
        Animal animal = animalFactory.create("horse");

        assertTrue(animal instanceof Horse);
    }
}