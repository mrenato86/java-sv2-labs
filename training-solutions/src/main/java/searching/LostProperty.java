package searching;

import java.time.LocalDate;

public class LostProperty implements Comparable<LostProperty> {

    private String id;
    private final String description;
    private final LocalDate registrationDate;

    public LostProperty(String id, String description, LocalDate registrationDate) {
        this(description, registrationDate);
        this.id = id;
    }

    public LostProperty(String description, LocalDate registrationDate) {
        this.description = description;
        this.registrationDate = registrationDate;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public int compareTo(LostProperty o) {
        if (description.compareTo(o.description) != 0) {
            return description.compareTo(o.description);
        }
        return registrationDate.compareTo(o.registrationDate);
    }

    @Override
    public String toString() {
        return description + "-" + registrationDate;
    }
}
