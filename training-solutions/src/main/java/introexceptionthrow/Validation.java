package introexceptionthrow;

public class Validation {

    public void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is null or empty!");
        }
    }

    public void validateAge(String ageString) {
        if (ageString == null || ageString.isBlank()) {
            throw new IllegalArgumentException("Age is null or empty!");
        }
        for (int i = 0; i < ageString.length(); i++) {
            if (!Character.isDigit(ageString.charAt(i))) {
                throw new IllegalArgumentException("Age is not a positive number!");
            }
        }
        if (Integer.parseInt(ageString) > 120) {
            throw new IllegalArgumentException("Age is not valid!");
        }
    }

}
