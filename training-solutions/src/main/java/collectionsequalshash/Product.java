package collectionsequalshash;

import java.util.Objects;

public class Product {

    private String name;
    private String registrationNumber;

    public Product(String name, String registrationNumber) {
        this.name = name;
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        Product product = (Product) obj;
        return Objects.equals(this.registrationNumber, product.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }

}
