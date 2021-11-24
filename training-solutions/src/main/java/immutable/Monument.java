package immutable;

import java.time.LocalDate;

public class Monument {

    private final String name;
    private final String address;
    private final LocalDate dateOfRegistry;
    private final String registryNumber;

    public Monument(String name, String address, LocalDate dateOfRegistry, String registryNumber) {
        validateParameters(name, address, registryNumber);
        this.name = name;
        this.address = address;
        this.dateOfRegistry = dateOfRegistry;
        this.registryNumber = registryNumber;
    }

    private void validateParameters(String name, String address, String registryNumber) {
        if (isEmpty(name) || isEmpty(address) || isEmpty(registryNumber)) {
            throw new IllegalArgumentException("Name, address or registry number cannot be empty!");
        }
    }

    private boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDateOfRegistry() {
        return dateOfRegistry;
    }

    public String getRegistryNumber() {
        return registryNumber;
    }
}
