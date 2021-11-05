package controlselection.consonant;

public class ToConsonant {

    public char convertToConsonant(char c) {
        String vowels = "aeiou";
        if (vowels.indexOf(c) >= 0) {
            return (char) (c + 1);
        }
        return c;
    }

}
