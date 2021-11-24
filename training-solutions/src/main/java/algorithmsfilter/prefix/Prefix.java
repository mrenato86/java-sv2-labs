package algorithmsfilter.prefix;

import java.util.ArrayList;
import java.util.List;

public class Prefix {

    public List<String> getWordsStartWith(List<String> words, String prefix) {
        List<String> filteredList = new ArrayList<>();
        for (String word : words) {
            if (word.startsWith(prefix)) {
                filteredList.add(word);
            }
        }
        return filteredList;
    }

}
