package lambdaintermediate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LongWords {

    private final List<String> words;

    public LongWords(List<String> words) {
        this.words = new ArrayList<>(words);
    }

    public long getNumberOfWordsStartWith(String keyWord) {
        return words.stream()
                .filter(w -> w.startsWith(keyWord))
                .count();
    }

    public List<String> getLongerWords(int number) {
        return words.stream()
                .filter(w -> w.length() > number)
                .collect(Collectors.toList());
    }

    public Optional<String> getShortestWordContainingGivenCharacter(char character) {
        return words.stream()
                .filter(w -> w.indexOf(character) >= 0)
                .min(Comparator.comparingInt(String::length));
    }
}
