package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogItem {

    private final List<Feature> features = new ArrayList<>();
    private final int price;
    private final String registrationNumber;

    public CatalogItem(String registrationNumber, int price, Feature... feature) {
        validateArguments(registrationNumber, price, feature);
        this.registrationNumber = registrationNumber;
        this.price = price;
        this.features.addAll(Arrays.asList(feature));
    }

    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();
        for (Feature feature : features) {
            contributors.addAll(feature.getContributors());
        }
        return contributors;
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        for (Feature feature : features) {
            titles.add(feature.getTitle());
        }
        return titles;
    }

    public boolean hasAudioFeature() {
        for (Feature feature : features) {
            if (feature instanceof AudioFeatures) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPrintedFeature() {
        for (Feature feature : features) {
            if (feature instanceof PrintedFeatures) {
                return true;
            }
        }
        return false;
    }

    public int fullLengthAtOneItem() {
        int sumOfLength = 0;
        for (Feature feature : features) {
            if (feature instanceof AudioFeatures) {
                sumOfLength += ((AudioFeatures) feature).getLength();
            }
        }
        return sumOfLength;
    }

    public int numberOfPagesAtOneItem() {
        int sumOfPages = 0;
        for (Feature feature : features) {
            if (feature instanceof PrintedFeatures) {
                sumOfPages += ((PrintedFeatures) feature).getNumberOfPages();
            }
        }
        return sumOfPages;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getPrice() {
        return price;
    }

    public List<Feature> getFeatures() {
        return new ArrayList<>(features);
    }

    private void validateArguments(String registrationNumber, int price, Feature[] feature) {
        if (Validators.isBlank(registrationNumber)) {
            throw new IllegalArgumentException("Registration Number can't be empty!");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price can't be zero or negative!");
        }
        if (Validators.isEmptyArray(feature)) {
            throw new IllegalArgumentException("Feature can't be empty!");
        }
    }
}
