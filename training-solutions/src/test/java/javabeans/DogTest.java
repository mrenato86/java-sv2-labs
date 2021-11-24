package javabeans;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DogTest {

    @Test
    void testCreate() {
        Dog dog = new Dog();
        dog.setName("A Dog");
        dog.setPedigree(true);
        dog.setAge(3);
        dog.setWeight(8.5);

        assertEquals("A Dog", dog.getName());
        assertTrue(dog.isPedigree());
        assertEquals(3, dog.getAge());
        assertEquals(8.5, dog.getWeight());
    }
}