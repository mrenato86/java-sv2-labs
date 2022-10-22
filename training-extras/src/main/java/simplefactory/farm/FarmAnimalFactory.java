package simplefactory.farm;

public class FarmAnimalFactory {

    public Animal create(String animalType) {
        if (animalType == null || animalType.isBlank()) {
            throw new IllegalArgumentException("Animal type must not be empty!");
        }
        return switch (animalType) {
            case "cock" -> new Cock();
            case "horse" -> new Horse();
            case "frog" -> new Frog();
            default -> throw new IllegalArgumentException("Unrecognizable animal type!");
        };
    }
}
