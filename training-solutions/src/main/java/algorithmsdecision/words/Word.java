package algorithmsdecision.words;

import java.util.List;

public class Word {

    public boolean containsLongerWord(List<String> words, String word) {
        for (String s : words) {
            if (s.length() > word.length()) {
                return true;
            }
        }
        return false;
    }
}
