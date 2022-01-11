package searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LostAndFoundOffice {

    private final List<LostProperty> lostProperties;

    public LostAndFoundOffice(List<LostProperty> lostProperties) {
        this.lostProperties = lostProperties;
    }

    public List<LostProperty> getLostProperties() {
        return new ArrayList<>(lostProperties);
    }

    public LostProperty findLostProperty(LostProperty searched) {
        int index = Collections.binarySearch(lostProperties, searched);
        if (index < 0) {
            throw new IllegalArgumentException("Property not found.");
        }
        return lostProperties.get(index);
    }
}
