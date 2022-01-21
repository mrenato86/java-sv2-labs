package lambdaintro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RealEstateAgency {

    private final List<Flat> flats;

    public RealEstateAgency(List<Flat> flats) {
        this.flats = new ArrayList<>(flats);
    }

    private Flat findFirst(Predicate<Flat> condition) {
        for (Flat flat : flats) {
            if (condition.test(flat)) {
                return flat;
            }
        }
        throw new IllegalArgumentException("No such flat.");
    }

    public Flat findFirstCheaperFlat(int maxPrice) {
        return findFirst(f -> f.getPrice() < maxPrice);
    }

    public Flat findFirstGreaterFlat(double minArea) {
        return findFirst(f -> f.getArea() > minArea);
    }

    public Flat findFirstFlatInSameTown(String town) {
        return findFirst(f -> f.getAddress().startsWith(town));
    }
}
