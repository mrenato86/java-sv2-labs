package algorithmsfilter.zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private List<Animal> animals;

    public Zoo(List<Animal> animals) {
        this.animals = animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Animal> getAnimalsWithNumberOfLegsGiven(int numberOfLegs) {
        List<Animal> animalsFound = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getNumberOfLegs() == numberOfLegs) {
                animalsFound.add(animal);
            }
        }
        return animalsFound;
    }
}
