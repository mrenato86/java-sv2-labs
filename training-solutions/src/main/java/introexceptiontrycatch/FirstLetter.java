package introexceptiontrycatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstLetter {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("dog", "cat", "lion", "", null));
        try {
            for (String s : words) {
                System.out.println(s.charAt(0));
            }
        } catch (NullPointerException | StringIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
