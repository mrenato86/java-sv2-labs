package algorithmsfilter.zoo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZooTest {

    Zoo zoo;

    @BeforeEach
    void init() {
        List<Animal> animals = List.of(
                new Animal("giraffe", 4),
                new Animal("lion", 4),
                new Animal("ladybug", 6),
                new Animal("snake", 0),
                new Animal("elephant", 4),
                new Animal("centipede", 100),
                new Animal("chicken", 2)
        );
        zoo = new Zoo(animals);
    }

    @Test
    void testGetAnimalsWithNumberOfLegsGiven() {
        List<Animal> expected = List.of(
                zoo.getAnimals().get(0),
                zoo.getAnimals().get(1),
                zoo.getAnimals().get(4)
        );
        List<Animal> filtered = zoo.getAnimalsWithNumberOfLegsGiven(4);

        assertEquals(3, filtered.size());
        assertEquals(expected, filtered);
    }

    @Test
    void testGetAnimalsWithNumberOfLegsGivenNoResult() {
        List<Animal> filtered = zoo.getAnimalsWithNumberOfLegsGiven(-4);

        assertEquals(0, filtered.size());
    }

}