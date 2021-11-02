package stringbuilder;

public class PalindromeValidator {

    public boolean isPalindrome(String word) {
        word = word.strip();
        StringBuilder sb = new StringBuilder(word);
        return word.equalsIgnoreCase(sb.reverse().toString());
    }

    public static void main(String[] args) {
        PalindromeValidator palindromeValidator = new PalindromeValidator();

        System.out.println(palindromeValidator.isPalindrome(" RaceCar\n"));
        System.out.println(palindromeValidator.isPalindrome("wrong"));
        System.out.println(palindromeValidator.isPalindrome(""));
    }

}
