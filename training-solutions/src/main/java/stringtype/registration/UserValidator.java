package stringtype.registration;

public class UserValidator {

    public boolean isValidUsername(String username) {
        return !"".equals(username);
    }

    public boolean isValidPassword(String password1, String password2) {
        return password1.length()>=8 && password1.equals(password2);
    }

    public boolean isValidEmail(String email) {
        int atIndex = email.indexOf('@');
        int lastDotIndex = email.lastIndexOf('.');
        return atIndex > 0 && lastDotIndex > atIndex + 1 && lastDotIndex < email.length() - 1;
    }

}
