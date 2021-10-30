package primitivetypes.primitivetypes.exam;

import java.time.LocalDate;

public class Person {

    private String name;
    private LocalDate dateOfBirth;
    private int zipCode;
    private double avgResult;

    public Person(String name, LocalDate dateOfBirth, int zipCode, double avgResult) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.zipCode = zipCode;
        this.avgResult = avgResult;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getZipCode() {
        return zipCode;
    }

    public double getAvgResult() {
        return avgResult;
    }

    @Override
    public String toString() {
        return name + " (" + dateOfBirth + ", " + zipCode + "): " + avgResult;
    }
}
