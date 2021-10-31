package chars;

public class LettersAndDigits {

    public void printLetterOrDigit(String text) {
        for (char c : text.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                System.out.println(c + ": alphabetic");
                continue;
            }
            if (Character.isDigit(c)) {
                System.out.println(c + ": digit");
                continue;
            }
            System.out.println(c + ": other");
        }
    }

    public static void main(String[] args) {
        LettersAndDigits lettersAndDigits = new LettersAndDigits();
        lettersAndDigits.printLetterOrDigit("bfa68fF;X");
    }

}
