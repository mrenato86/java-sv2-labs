package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BucketList {

    private final List<Destination> destinations;

    public BucketList(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public List<Destination> getDestinations() {
        return new ArrayList<>(destinations);
    }

    public Optional<Destination> getDestinationWithKeyword(String keyword) {
        for (Destination destination : destinations) {
            if (destination.getDescription().contains(keyword)) {
                return Optional.of(destination);
            }
        }
        return Optional.empty();
    }

    public Optional<Destination> getDestinationNearerThanGiven(int maxKm) {
        for (Destination destination : destinations) {
            if (destination.getKmFromHome() < maxKm) {
                return Optional.of(destination);
            }
        }
        return Optional.empty();
    }

}
