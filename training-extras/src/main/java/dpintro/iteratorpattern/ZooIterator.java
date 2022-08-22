package dpintro.iteratorpattern;

import java.util.List;

public class ZooIterator implements Iterator {

    private int index;

    private final List<Animal> animalList;

    public ZooIterator(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @Override
    public boolean hasNext() {
        return index < animalList.size();
    }

    @Override
    public Object next() {
        return hasNext() ? animalList.get(index++) : null;
    }
}
