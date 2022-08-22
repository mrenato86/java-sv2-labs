package dpintro.iteratorpattern;

import java.util.List;

public class Zoo implements Container {

    private List<Animal> animals;

    public Zoo(List<Animal> animals) {
        if (!animals.isEmpty()) {
            this.animals = animals;
        }
    }

    @Override
    public Iterator getIterator() {
        return new ZooIterator(animals);
    }
}
