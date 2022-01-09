package collectionsequalshash;

import java.util.Objects;

public class Company {

    private String name;
    private String taxId;

    public Company(String name, String taxId) {
        this.name = name;
        this.taxId = taxId;
    }

    public String getName() {
        return name;
    }

    public String getTaxId() {
        return taxId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) && Objects.equals(taxId, company.taxId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, taxId);
    }
}
