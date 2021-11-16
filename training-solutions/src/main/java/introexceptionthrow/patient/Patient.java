package introexceptionthrow.patient;

public class Patient {

    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is null or empty!");
        }
        if (yearOfBirth < 1900) {
            throw new IllegalArgumentException("Invalid year of birth: " + yearOfBirth);
        }
        if (!new SsnValidator().isValidSsn(socialSecurityNumber)) {
            throw new IllegalArgumentException("Invalid Social Security Number: " + socialSecurityNumber);
        }
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return String.format("%s (%d) : %s", name, yearOfBirth, socialSecurityNumber);
    }

    public static void main(String[] args) {
        //All good
        Patient firstPatient = new Patient("First Patient", "123456788", 1954);
        System.out.println(firstPatient);

        // Empty name
        Patient secondPatient = new Patient("", "123456788", 1954);
        System.out.println(secondPatient);

        //Wrong ssn calculation
        Patient thirdPatient = new Patient("Third Patient", "123456789", 1954);
        System.out.println(thirdPatient);

        //Wrong year
        Patient fourthPatient = new Patient("Fourth Patient", "123456788", 1888);
        System.out.println(fourthPatient);

        //Letter in ssn
        Patient fifthPatient = new Patient("Fifth Patient", "12T456788", 1954);
        System.out.println(fifthPatient);
    }

}
