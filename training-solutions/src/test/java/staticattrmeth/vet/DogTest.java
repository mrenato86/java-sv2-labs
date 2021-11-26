package staticattrmeth.vet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DogTest {

    @Test
    void testCreate() {
        Dog dog = new Dog("Rex", 8, Species.GERMAN_SHEPHERD);

        assertEquals("Rex", dog.getName());
        assertEquals(8, dog.getAge());
        assertEquals(Species.GERMAN_SHEPHERD, dog.getBreed());
        assertEquals(0L, dog.getCode());
    }

}