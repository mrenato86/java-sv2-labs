package introexceptionthrow.patient;

public class SsnValidator {

    public boolean isValidSsn(String ssn) {
        if (ssn == null || ssn.length() != 9) {
            return false;
        }
        int sum = 0;
        try {
            for (int i = 0; i < ssn.length() - 1; i++) {
                int num = intFromChar(ssn.charAt(i));
                sum += i % 2 == 0 ? (3 * num) : (7 * num);
            }
            return intFromChar(ssn.charAt(8)) == (sum % 10);
        } catch (IllegalArgumentException iae) {
            return false;
        }
    }

    private int intFromChar(char c) {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException("Not a digit!");
        }
        return c - '0';
    }
}
