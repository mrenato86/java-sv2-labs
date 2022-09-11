package solid.base;

public class AccountValidator implements Validator {

    private static final int MIN_USERNAME_LENGTH = 6;

    @Override
    public boolean isValid(String userName) {
        return userName != null
                && !userName.contains(" ")
                && userName.length() >= MIN_USERNAME_LENGTH;
    }
}
