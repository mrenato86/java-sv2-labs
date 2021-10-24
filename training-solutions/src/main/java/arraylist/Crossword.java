package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crossword {

    public static void main(String[] args) {
        String[] wordsArray = new String[]{"KULCS", "KÁLYHA", "LÓ", "AJTÓ", "CSERESZNYEFA", "TEJ",
                                            "FELHŐ", "CIPŐ", "MOSODA", "KÁVÉTEJSZÍN", "CITERA", "BABA" };
        List<String> words = new ArrayList<>(Arrays.asList(wordsArray));

        for (String word : words) {
            if (word.length() == 6)
                System.out.println(word);
        }
    }

}
