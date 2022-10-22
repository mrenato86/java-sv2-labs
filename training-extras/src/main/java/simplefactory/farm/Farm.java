package simplefactory.farm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Farm {

    private final FarmAnimalFactory animalFactory;
    private final List<Animal> animals = new ArrayList<>();

    public Farm(FarmAnimalFactory animalFactory) {
        this.animalFactory = animalFactory;
    }

    public void newAnimalArrived(String animalType) {
        if (animalType == null || animalType.isBlank()) {
            throw new IllegalArgumentException("Animal type must not be empty!");
        }
        animals.add(animalFactory.create(animalType));
    }

    public List<String> getAnimalVoices() {
        return animals.stream()
                .map(Animal::speak)
                .distinct()
                .collect(Collectors.toList());
    }
}
