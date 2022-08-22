package dpintro.iteratorpattern;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class IteratorTest {

    private final List<Animal> animalList = List.of(new Animal("zsiráf"), new Animal("oroszlán"), new Animal("gazella"), new Animal("leopárd"));
    private final List<String> testList = List.of("leopárd", "gazella", "oroszlán", "zsiráf");

    @Test
    public void testIterator() {
        Zoo zoo = new Zoo(animalList);
        Iterator iter = zoo.getIterator();

        while (iter.hasNext()) {
            assertTrue(testList.contains(((Animal) iter.next()).getName()));
        }
    }

}