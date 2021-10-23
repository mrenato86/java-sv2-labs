package stringtype.registration;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserValidator validator = new UserValidator();
        System.out.print("User Name: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password1 = scanner.nextLine();
        System.out.print("Password again: ");
        String password2 = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.println(validator.isValidUsername(username) ? "Valid Username" : "Invalid Username");
        System.out.println(validator.isValidPassword(password1, password2) ? "Valid Password" : "Invalid Password");
        System.out.println(validator.isValidEmail(email) ? "Valid E-mail" : "Invalid E-mail");


    }

}
