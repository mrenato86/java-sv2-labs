package recursion;

public class Vowels {

    public int getNumberOfVowels(String word) {
        if (word == null || word.length() == 0) {
            return 0;
        }
        String vowels = "aáeéiíoóöőuúüű";
        if (vowels.indexOf(word.charAt(0)) >= 0) {
            return 1 + getNumberOfVowels(word.substring(1));
        } else {
            return getNumberOfVowels(word.substring(1));
        }
    }

}
