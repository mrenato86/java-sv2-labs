package immutable;

import java.time.LocalDate;

public class Car {

    private final String brand;
    private final String model;
    private final int yearOfProduction;

    public Car(String brand, String model, int yearOfProduction) {
        validateBrand(brand);
        validateYearOfProduction(yearOfProduction);
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
    }

    private void validateYearOfProduction(int yearOfProduction) {
        if (yearOfProduction > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Year of production cannot be in the future!");
        }
    }

    private void validateBrand(String brand) {
        if (brand == null || brand.isBlank()) {
            throw new IllegalArgumentException("Brand name cannot be empty!");
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }
}
